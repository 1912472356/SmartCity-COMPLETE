package com.cx.smartcity.moudle_1.rubbish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.RubBannerBean;
import com.cx.smartcity.bean.RubTypeHotBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RubSearchActivity extends AppCompatActivity {
    private Banner banner;
    private SearchView searchEt;
    private GridView hotRecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub_search);

        banner = (Banner) findViewById(R.id.banner);
        searchEt = (SearchView) findViewById(R.id.search_et);
        hotRecyc = (GridView) findViewById(R.id.hot_recyc);

        initBanner();
        initSearch();
        RetrofitUtil.get("/prod-api/api/garbage-classification/garbage-classification/hot/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<RubTypeHotBean.DataDTO> list = new Gson().fromJson(json, RubTypeHotBean.class).getData().subList(0, 40);
                List<String> arr = new ArrayList<>();
                for (RubTypeHotBean.DataDTO row : list) {
                    arr.add(row.getKeyword());
                }
                hotRecyc.setAdapter(new ArrayAdapter<String>(RubSearchActivity.this, R.layout.support_simple_spinner_dropdown_item, arr));
                hotRecyc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        search(list.get(i).getKeyword());
                    }
                });
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
        RetrofitUtil.get("/prod-api/api/garbage-classification/ad-banner/list", new RetrofitUtil.OnRequest() {
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
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void search(String query) {
        Intent intent = new Intent(this, RubDetailActivity.class);
        intent.putExtra("name", query);
        startActivity(intent);
    }


    public void back(View view) {
        finish();
    }
}