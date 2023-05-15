package com.cx.smartcity.moudle_2.law;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.cx.smartcity.bean.LawBean;
import com.cx.smartcity.bean.LawTypeBean;
import com.cx.smartcity.bean.RubBannerBean;
import com.cx.smartcity.bean.ServiceBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.home.SearchActivity;
import com.cx.smartcity.home.adap.ServiceAdapter;
import com.cx.smartcity.moudle_2.consult.ConsultListActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Collections;
import java.util.List;

public class LawerActivity extends AppCompatActivity {
    private SearchView searchEt;
    private Banner banner;
    private RecyclerView typeRecyc;
    private RecyclerView lawRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawer);
        searchEt = (SearchView) findViewById(R.id.search_et);
        banner = (Banner) findViewById(R.id.banner);
        typeRecyc = (RecyclerView) findViewById(R.id.type_recyc);
        lawRecyc = (RecyclerView) findViewById(R.id.law_recyc);


        initBanner();
        initSearch();
        initType();
        initLaw();
    }

    private void initLaw() {
        lawRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/list-top10", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LawBean.RowsDTO> list = new Gson().fromJson(json, LawBean.class).getRows();
                lawRecyc.setAdapter(new LawAdapter(LawerActivity.this, list));
            }
        });
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                String advImg = ((RubBannerBean.DataDTO) o).getImgUrl();
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
            }
        });
        final List<RubBannerBean.DataDTO>[] list = new List[1];
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/ad-banner/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, RubBannerBean.class).getData();
                banner.setImages(list[0]);
                banner.start();
            }
        });

    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(LawerActivity.this, LawListActivity.class);
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

    private void initType() {
        typeRecyc.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/legal-expertise/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LawTypeBean.RowsDTO> list = new Gson().fromJson(json, LawTypeBean.class).getRows();
                Collections.reverse(list);
                typeRecyc.setAdapter(new LawTypeAdapter(LawerActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void lawList(View view) {
        startActivity(new Intent(this, LawListActivity.class));
    }

    public void myConsult(View view) {
        startActivity(new Intent(this, ConsultListActivity.class));
    }
}