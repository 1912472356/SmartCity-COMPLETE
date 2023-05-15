package com.cx.smartcity.moudle_2.volunteer;

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
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.bean.VolunNewsBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Collections;
import java.util.List;

public class VolunActivity extends AppCompatActivity {
    private Banner banner;
    private RecyclerView newsRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun);
        banner = (Banner) findViewById(R.id.banner);
        newsRecyc = (RecyclerView) findViewById(R.id.news_recyc);

        initBanner();
        initNews();
    }

    private void initNews() {
        newsRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/volunteer-service/news/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<VolunNewsBean.RowsDTO> list = new Gson().fromJson(json, VolunNewsBean.class).getRows();
                Collections.reverse(list);
                newsRecyc.setAdapter(new VolunNewsAdapter(VolunActivity.this, list));
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
        RetrofitUtil.get("/prod-api/api/volunteer-service/ad-banner/list", new RetrofitUtil.OnRequest() {
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

    public void my_volun(View view) {
        startActivity(new Intent(this, MyVolunActivity.class));
    }

    public void volun(View view) {
        startActivity(new Intent(this, VolunEvebtActivity.class));
    }
}