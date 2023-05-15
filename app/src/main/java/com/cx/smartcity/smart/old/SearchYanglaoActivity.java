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

public class SearchYanglaoActivity extends AppCompatActivity {
    private RecyclerView yanglaoRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_yanglao);
        yanglaoRecyc = (RecyclerView) findViewById(R.id.yanglao_recyc);

        yanglaoRecyc.setLayoutManager(new LinearLayoutManager(this));
        Type type = new TypeToken<List<YanglaoBean>>() {
        }.getType();
        List<YanglaoBean> list = new Gson().fromJson(SPUtil.get(SPUtil.YANGLAO), type);
        String name = getIntent().getStringExtra("name");;
        List<YanglaoBean> arr = new ArrayList<>();
        for (YanglaoBean row : list) {
            if (row.getName().contains(name)) arr.add(row);
        }
        if (arr.size() == 0) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "搜索成功", Toast.LENGTH_SHORT).show();
        }
        yanglaoRecyc.setAdapter(new YanglaoAdapter(this, arr));
    }

    public void back(View view) {
        finish();
    }
}