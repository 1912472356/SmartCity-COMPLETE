package com.cx.smartcity.moudle_1.gover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.AppealBean;
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.bean.LoveTypeBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoverActivity extends AppCompatActivity {
    private Banner banner;
    private RecyclerView typeRecyc;
    private RecyclerView myAppealRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gover);
        banner = (Banner) findViewById(R.id.banner);
        typeRecyc = (RecyclerView) findViewById(R.id.type_recyc);
        myAppealRecyc = (RecyclerView) findViewById(R.id.my_appeal_recyc);

        initBanner();
        initType();
        myAppealRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        initAppeal();
    }

    private void initAppeal() {
        RetrofitUtil.get("/prod-api/api/gov-service-hotline/appeal/my-list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<AppealBean.RowsDTO> list = new Gson().fromJson(json, AppealBean.class).getRows();
                Collections.sort(list);
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (AppealBean.RowsDTO row : list) {
                    titles.add(row.getTitle());
                    arr.add("承办单位："+row.getUndertaker()
                            +"\n提交时间："+row.getCreateTime()
                            +"\n处理状态："+(row.getState().equals("0") ? "未完结":"已完结"));
                }

                myAppealRecyc.setAdapter(new CommonAdapter(GoverActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(GoverActivity.this, AppealDetailActivity.class);
                        intent.putExtra("data", list.get(Integer.parseInt(json)));
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    private void initType() {
        typeRecyc.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        RetrofitUtil.get("/prod-api/api/gov-service-hotline/appeal-category/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                json = json.replaceFirst("rows", "data");
                List<LoveTypeBean.DataDTO> list = new Gson().fromJson(json, LoveTypeBean.class).getData();
                LoveTypeBean.DataDTO end = list.get(list.size() - 1);
                LoveTypeBean.DataDTO start = list.get(0);
                list.set(0, end);
                list.set(list.size()-1, start);
                Collections.reverse(list);
                typeRecyc.setAdapter(new AppealTypeAdapter(GoverActivity.this, list));
            }
        });
    }


    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                String advImg = ((LoveBannerBean.DataDTO) o).getImgUrl();
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
            }
        });
        final List<LoveBannerBean.DataDTO>[] list = new List[1];
        RetrofitUtil.get("/prod-api/api/gov-service-hotline/ad-banner/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, LoveBannerBean.class).getData();
                banner.setImages(list[0]);
                banner.start();
            }
        });

    }

    public void back(View view) {
        finish();
    }
}