package com.cx.smartcity.moudle_2.subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.AllLineaBean;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class SubwayMapActivity extends AppCompatActivity {
    private RecyclerView lineRecyc;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_map);
        lineRecyc = (RecyclerView) findViewById(R.id.line_recyc);
        img = (ImageView) findViewById(R.id.img);

        String path = "/prod-api/profile/upload/image/2021/05/08/554f2392-1e1c-4449-b95c-327a5f7ec91d.jpeg";

        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + path)
                                .error(R.mipmap.resource).into(img);

        lineRecyc.setLayoutManager(new LinearLayoutManager(this));

        RetrofitUtil.get("/prod-api/api/metro/line/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<AllLineaBean.DataDTO> list = new Gson().fromJson(json, AllLineaBean.class).getData();
                lineRecyc.setAdapter(new AllLineAdapter(SubwayMapActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}