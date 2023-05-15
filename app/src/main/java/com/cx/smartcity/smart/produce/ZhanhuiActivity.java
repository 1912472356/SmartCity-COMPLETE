package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ZhanhuiBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ZhanhuiActivity extends AppCompatActivity {
    private RecyclerView eventRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhanhui);
        eventRecyc = (RecyclerView) findViewById(R.id.event_recyc);
        eventRecyc.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<ZhanhuiBean>>() {
        }.getType();
        List<ZhanhuiBean> list = new Gson().fromJson(SPUtil.get(SPUtil.ZHIZAO_ZHANHUI),type);
        List<String> arr = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (ZhanhuiBean row : list) {
            titles.add(row.getTitle());
            arr.add("展会日期："+row.getDate()+"\n展会内容："+row.getContent());
        }
        eventRecyc.setAdapter(new ZhanhuiAdapter(this, arr, titles));
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, AddZhanhuiActivity.class));
    }

    public void detail(View view) {
        Intent intent = new Intent(this, ZhanhuiDetailActivity.class);
        switch (view.getId()) {
            case R.id.card1:
                intent.putExtra("name", "2023年第25届中国（广州）国际建筑装饰博览会");
                break;
            case R.id.card2:
                intent.putExtra("name", "CICEE2023长沙国际工程机械展览会(双年展）");
                break;
            case R.id.card3:
                intent.putExtra("name", "2023第三十五届中国国际塑料橡胶工业展览会");
                break;
        }
        startActivity(intent);
    }
}