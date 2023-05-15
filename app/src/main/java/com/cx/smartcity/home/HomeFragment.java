package com.cx.smartcity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.NewsBean;
import com.cx.smartcity.bean.NewsTypeBean;
import com.cx.smartcity.bean.ServiceBean;
import com.cx.smartcity.home.adap.NewsAdapter;
import com.cx.smartcity.home.adap.ServiceAdapter;
import com.cx.smartcity.home.adap.ThemeAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;


public class HomeFragment extends Fragment {
    private Banner banner;
    private RecyclerView serviceRecyc;
    private RecyclerView themeRecyc;
    private TabLayout tabLayout;
    private RecyclerView newsRecyc;
    private SearchView searchEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initSearch();
        initBanner();
        initService();
        initTheme();
        initTab();
    }

    private void initTab() {
        newsRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        RetrofitUtil.get("/prod-api/press/category/list", new RetrofitUtil.OnRequest() {
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
        RetrofitUtil.get("/prod-api/press/press/list?type="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<NewsBean.RowsDTO> list = new Gson().fromJson(json, NewsBean.class).getRows();
                newsRecyc.setAdapter(new NewsAdapter(getContext(), list));
            }
        });
    }

    private void initTheme() {
        themeRecyc.setLayoutManager(new GridLayoutManager(getContext(),2));
        RetrofitUtil.get("/prod-api/press/press/list?hot=Y", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<NewsBean.RowsDTO> list = new Gson().fromJson(json, NewsBean.class).getRows();
                themeRecyc.setAdapter(new ThemeAdapter(getContext(), list));
            }
        });
    }

    private void initService() {
        serviceRecyc.setLayoutManager(new GridLayoutManager(getContext(), 5));
        RetrofitUtil.get("/prod-api/api/service/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<ServiceBean.RowsDTO> list = new Gson().fromJson(json, ServiceBean.class).getRows();
                serviceRecyc.setAdapter(new ServiceAdapter(getContext(), list.subList(0, 10), true));
            }
        });
    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
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

    private void initView(View view) {
        searchEt = (SearchView) view.findViewById(R.id.search_et);
        banner = (Banner) view.findViewById(R.id.banner);
        serviceRecyc = (RecyclerView) view.findViewById(R.id.service_recyc);
        themeRecyc = (RecyclerView) view.findViewById(R.id.theme_recyc);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        newsRecyc = (RecyclerView) view.findViewById(R.id.news_recyc);

        banner.requestFocusFromTouch();
        banner.requestFocus();
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
        RetrofitUtil.get("/prod-api/api/rotation/list?type=2", new RetrofitUtil.OnRequest() {
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
                Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                intent.putExtra("id", targetId);
                startActivity(intent);
            }
        });
    }
}