package com.cx.smartcity.moudle_1.event;

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
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.EventBean;
import com.cx.smartcity.bean.NewsTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Collections;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private Banner banner;
    private TabLayout tabLayout;
    private RecyclerView newsRecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        banner = (Banner) findViewById(R.id.banner);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        newsRecyc = (RecyclerView) findViewById(R.id.news_recyc);


        initBanner();
        initTab();
    }
    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                String advImg = ((BannerBean.RowsDTO) o).getAdvImg();
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
            }
        });
        final List<BannerBean.RowsDTO>[] list = new List[1];
        RetrofitUtil.get("/prod-api/api/activity/rotation/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, BannerBean.class).getRows();
                banner.setImages(list[0]);
                banner.start();
            }
        });

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                int targetId = list[0].get(i).getTargetId();
                Intent intent = new Intent(EventActivity.this, EventDetailActivity.class);
                intent.putExtra("id", targetId);
                startActivity(intent);
            }
        });
    }

    private void initTab() {
        newsRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/activity/category/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<NewsTypeBean.DataDTO> list = new Gson().fromJson(json, NewsTypeBean.class).getData();
                for (NewsTypeBean.DataDTO row : list) {
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
        RetrofitUtil.get("/prod-api/api/activity/activity/list?categoryId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<EventBean.RowsDTO> list = new Gson().fromJson(json, EventBean.class).getRows();
                Collections.sort(list);
                newsRecyc.setAdapter(new EventAdapter(EventActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}