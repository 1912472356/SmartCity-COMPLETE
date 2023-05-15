package com.cx.smartcity.moudle_1.love;

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
import com.cx.smartcity.R;
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.bean.LoveBean;
import com.cx.smartcity.bean.LoveTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class LoveActivity extends AppCompatActivity {
    private SearchView searchEt;
    private Banner banner;
    private RecyclerView serviceRecyc;
    private RecyclerView recommandRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        searchEt = (SearchView) findViewById(R.id.search_et);
        banner = (Banner) findViewById(R.id.banner);
        serviceRecyc = (RecyclerView) findViewById(R.id.service_recyc);
        recommandRecyc = (RecyclerView) findViewById(R.id.recommand_recyc);

        initSearch();;
        initBanner();
        initService();
        loadNews();
    }
    private void loadNews() {
        recommandRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/public-welfare/public-welfare-activity/recommend-list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LoveBean.RowsDTO> list = new Gson().fromJson(json, LoveBean.class).getRows();
                recommandRecyc.setAdapter(new LoveRecommandAdapter(LoveActivity.this, list));
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
        RetrofitUtil.get("/prod-api/api/public-welfare/ad-banner/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, LoveBannerBean.class).getData();
                banner.setImages(list[0]);
                banner.start();
            }
        });

    }

    private void initService() {
        serviceRecyc.setLayoutManager(new GridLayoutManager(LoveActivity.this, 4));
        RetrofitUtil.get("/prod-api/api/public-welfare/public-welfare-type/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LoveTypeBean.DataDTO> list = new Gson().fromJson(json, LoveTypeBean.class).getData();
                serviceRecyc.setAdapter(new LoveTypeAdapter(LoveActivity.this, list));
            }
        });
    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(LoveActivity.this, LoveEventActivity.class);
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

    public void back(View view) {
        finish();
    }
}