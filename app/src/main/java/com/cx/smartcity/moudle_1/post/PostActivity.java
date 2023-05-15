package com.cx.smartcity.moudle_1.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.AreaBean;
import com.cx.smartcity.bean.PostBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class PostActivity extends AppCompatActivity {
    private RecyclerView areaRecyc;
    private RecyclerView postRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        areaRecyc = (RecyclerView) findViewById(R.id.area_recyc);
        postRecyc = (RecyclerView) findViewById(R.id.post_recyc);

        areaRecyc.setLayoutManager(new GridLayoutManager(this, 3));
        RetrofitUtil.get("/prod-api/api/youth-inn/talent-policy-area/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<AreaBean.DataDTO> list = new Gson().fromJson(json, AreaBean.class).getData();
                areaRecyc.setAdapter(new AreaAdapter(PostActivity.this, list));
            }
        });

        postRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/youth-inn/youth-inn/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PostBean.RowsDTO> list = new Gson().fromJson(json, PostBean.class).getRows();
                postRecyc.setAdapter(new PostAdapter(PostActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}