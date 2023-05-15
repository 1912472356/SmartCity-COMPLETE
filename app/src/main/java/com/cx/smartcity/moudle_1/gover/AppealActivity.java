package com.cx.smartcity.moudle_1.gover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.AppealBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppealActivity extends AppCompatActivity {
    private RecyclerView appealRecyc;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeal);
        appealRecyc = (RecyclerView) findViewById(R.id.appeal_recyc);

        id = getIntent().getIntExtra("id", 11);
        appealRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        RetrofitUtil.get("/prod-api/api/gov-service-hotline/appeal/list?appealCategoryId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<AppealBean.RowsDTO> list = new Gson().fromJson(json, AppealBean.class).getRows();
                Collections.sort(list);
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (AppealBean.RowsDTO row : list) {
                    titles.add(row.getTitle());
                    arr.add("承办单位："+row.getUndertaker()
                            +"\n提交时间："+row.getCreateTime()
                            +"\n处理状态："+(row.getState().equals("0") ? "未完结":"已完结"));
                }

                appealRecyc.setAdapter(new CommonAdapter(AppealActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(AppealActivity.this, AppealDetailActivity.class);
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

    public void add(View view) {
        Intent intent = new Intent(this, AddAppealActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}