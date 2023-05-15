package com.cx.smartcity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.NewsBean;
import com.cx.smartcity.home.adap.NewsAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private TextView cnt;
    private RecyclerView newsRecyc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String name = getIntent().getStringExtra("name");
        cnt = (TextView) findViewById(R.id.cnt);
        newsRecyc = (RecyclerView) findViewById(R.id.news_recyc);

        RetrofitUtil.get("/prod-api/press/press/list?title="+name, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<NewsBean.RowsDTO> list = new Gson().fromJson(json, NewsBean.class).getRows();
                cnt.setText("搜索结果（"+list.size()+"条）");
                newsRecyc.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                newsRecyc.setAdapter(new NewsAdapter(SearchActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}