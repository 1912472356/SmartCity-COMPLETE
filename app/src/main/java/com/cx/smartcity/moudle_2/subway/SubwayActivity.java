package com.cx.smartcity.moudle_2.subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.SubwaySizeBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SubwayActivity extends AppCompatActivity {
    private RecyclerView subwayRecyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        subwayRecyc = (RecyclerView) findViewById(R.id.subway_recyc);

        subwayRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/metro/list?currentName=建国门", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<SubwaySizeBean.DataDTO> list = new Gson().fromJson(json, SubwaySizeBean.class).getData();
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (SubwaySizeBean.DataDTO row : list) {
                    titles.add(row.getLineName());
                    arr.add("下一站名称："+row.getNextStep().getName()+"\n到达本站时长："+row.getReachTime()+"分钟");
                }
                subwayRecyc.setAdapter(new CommonAdapter(SubwayActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(SubwayActivity.this, SubwayDetaActivity.class);
                        intent.putExtra("data", list.get(Integer.parseInt(json)));
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void zonglan(View view) {
        startActivity(new Intent(this, SubwayMapActivity.class));
    }
}