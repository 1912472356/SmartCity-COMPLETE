package com.cx.smartcity.moudle_1.rubbish;

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
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.bean.RubNewsBean;
import com.cx.smartcity.bean.RubNewsTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class RubActivity extends AppCompatActivity {
    private Banner banner;
    private TabLayout tabLayout;
    private RecyclerView newsRecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub);

        banner = (Banner) findViewById(R.id.banner);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        newsRecyc = (RecyclerView) findViewById(R.id.news_recyc);

        initBanner();
        initTab();
    }

    private void initTab() {
        newsRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/garbage-classification/news-type/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<RubNewsTypeBean.RowsDTO> list = new Gson().fromJson(json, RubNewsTypeBean.class).getRows();
                for (RubNewsTypeBean.RowsDTO row : list) {
                    tabLayout.addTab(tabLayout.newTab().setText(row.getName()));
                }
                loadNews(list.get(0).getId());
                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        loadNews(list.get(tab.getPosition()).getId());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });
    }

    private void loadNews(int id) {
        RetrofitUtil.get("/prod-api/api/garbage-classification/news/list?type="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<RubNewsBean.RowsDTO> list = new Gson().fromJson(json, RubNewsBean.class).getRows();
                newsRecyc.setAdapter(new RubNewsAdapter(RubActivity.this, list));
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
        RetrofitUtil.get("/prod-api/api/garbage-classification/ad-banner/list", new RetrofitUtil.OnRequest() {
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

    public void type(View view) {
        startActivity(new Intent(this, RubClassActivity.class));
    }

    public void search(View view) {
        startActivity(new Intent(this, RubSearchActivity.class));
    }
}