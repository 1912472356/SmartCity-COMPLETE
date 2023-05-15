package com.cx.smartcity.moudle_2.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.MovieBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.home.SearchActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class MovieActivity extends AppCompatActivity {
    private Banner banner;
    private SearchView searchEt;
    private RecyclerView movieRecyc;
    private Button moreBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        banner = (Banner) findViewById(R.id.banner);
        searchEt = (SearchView) findViewById(R.id.search_et);
        movieRecyc = (RecyclerView) findViewById(R.id.movie_recyc);
        moreBtn = (Button) findViewById(R.id.more_btn);

        initBanner();
        initSearch();
        movieRecyc.setLayoutManager(new LinearLayoutManager(this));
        load("");
    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                load(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void load(String query) {
        RetrofitUtil.get("/prod-api/api/movie/film/list?name="+query, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<MovieBean.RowsDTO> list = new Gson().fromJson(json, MovieBean.class).getRows();
                movieRecyc.setAdapter(new MovieAdapter(MovieActivity.this, list.subList(0, Math.min(4, list.size()))));
                if (list.size() <= 4) {
                    moreBtn.setVisibility(View.GONE);
                }else {
                    moreBtn.setVisibility(View.VISIBLE);
                    moreBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            movieRecyc.setAdapter(new MovieAdapter(MovieActivity.this, list));
                            moreBtn.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
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
        RetrofitUtil.get("/prod-api/api/movie/rotation/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, BannerBean.class).getRows();
                banner.setImages(list[0]);
                banner.start();
            }
        });

    }

    public void back(View view) {
        finish();
    }
}