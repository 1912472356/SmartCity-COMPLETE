package com.cx.smartcity.smart.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.KaimoGongyiBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class KaimoGongyiActivity extends AppCompatActivity {
    private RecyclerView gongyiRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaimo_gongyi);
        gongyiRecyc = (RecyclerView) findViewById(R.id.gongyi_recyc);

        gongyiRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<KaimoGongyiBean>>() {
        }.getType();
        List<KaimoGongyiBean> list = new Gson().fromJson(SPUtil.get(SPUtil.KAIMO_GONGYI), type);
        gongyiRecyc.setAdapter(new KaimoGongyiAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, AddGongyiActivity.class));
    }
}