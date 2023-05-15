package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.YanglaoBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class YanglaoYuyueActivity extends AppCompatActivity {
    private RecyclerView yanglaoRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanglao_yuyue);

        yanglaoRecyc = (RecyclerView) findViewById(R.id.yanglao_recyc);

        yanglaoRecyc.setLayoutManager(new LinearLayoutManager(this));
        Type type = new TypeToken<List<YanglaoBean>>() {
        }.getType();
        List<YanglaoBean> list = new Gson().fromJson(SPUtil.get(SPUtil.YANGLAO), type);
        yanglaoRecyc.setAdapter(new YanglaoAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }
}