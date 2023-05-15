package com.cx.smartcity.moudle_2.move;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.bean.WuliuBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.home.SearchActivity;
import com.cx.smartcity.util.ListAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MoveActivity extends AppCompatActivity {
    private SearchView searchEt;
    private Banner banner;
    private RecyclerView wuliuRecRecyc;

    private RecyclerView wuliuRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        searchEt = (SearchView) findViewById(R.id.search_et);
        banner = (Banner) findViewById(R.id.banner);
        wuliuRecRecyc = (RecyclerView) findViewById(R.id.wuliu_rec_recyc);
        wuliuRecyc = (RecyclerView) findViewById(R.id.wuliu_recyc);
        banner.requestFocus();
        banner.requestFocusFromTouch();
        initSearch();
        initBanner();
        initWuRec();
    }

    private void initWuRec() {
        wuliuRecRecyc.setLayoutManager(new GridLayoutManager(this, 4));
        RetrofitUtil.get("/prod-api/api/logistics-inquiry/logistics_company/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<WuliuBean.DataDTO> list = new Gson().fromJson(json, WuliuBean.class).getData();
                wuliuRecRecyc.setAdapter(new WuliuRecAdapter(MoveActivity.this, list.subList(0, 12)));
                List<String> arr = new ArrayList<>();
                for (WuliuBean.DataDTO row : list.subList(12, list.size())) {
                    arr.add(row.getName());
                }
                wuliuRecyc.setLayoutManager(new LinearLayoutManager(MoveActivity.this));
                wuliuRecyc.setAdapter(new ListAdapter(MoveActivity.this, arr, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(MoveActivity.this, WuliuDetailActivity.class);
                        intent.putExtra("id", list.get(Integer.parseInt(json)).getId());
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MoveActivity.this, MoveSearchActivity.class);
                intent.putExtra("name", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
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
        RetrofitUtil.get("/prod-api/api/logistics-inquiry/ad-banner/list", new RetrofitUtil.OnRequest() {
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