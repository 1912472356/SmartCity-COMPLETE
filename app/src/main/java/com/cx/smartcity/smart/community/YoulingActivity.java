package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class YoulingActivity extends AppCompatActivity {
    private RecyclerView youlingRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youling);

        youlingRecyc = (RecyclerView) findViewById(R.id.youling_recyc);

        youlingRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<ShequYoulingBean>>() {
        }.getType();
        List<ShequYoulingBean> list = new Gson().fromJson(SPUtil.get(SPUtil.SHEQU_YOULING), type);
        if (list.size() == 0) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        }
        youlingRecyc.setAdapter(new ShequYoulingAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, AddYoulingActivity.class));
    }
}