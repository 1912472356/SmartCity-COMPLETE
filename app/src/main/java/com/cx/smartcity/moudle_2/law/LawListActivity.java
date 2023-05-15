package com.cx.smartcity.moudle_2.law;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.LawBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

public class LawListActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private RecyclerView lawRecyc;
    private String id;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_list);
        int i = getIntent().getIntExtra("id", -1);
        if (i == -1) {
            id = "";
        }else {
            id = i+"";
        }
        name = getIntent().getStringExtra("name");
        if (name == null) {
            name = "";
        }
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        lawRecyc = (RecyclerView) findViewById(R.id.law_recyc);

        lawRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadData("");
        initTab();
    }

    private void initTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                resort(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private void resort(int position) {
        switch (position) {
            case 0:
                loadData("");
                break;
            case 1:
                loadData("workStartAt");
                break;
            case 2:
                loadData("serviceTimes");
                break;
            case 3:
                loadData("favorableRate");
                break;
        }
    }

    private void loadData(final String sort) {
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/list?legalExpertiseId="+id+"&sort="+sort+"&name="+name, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LawBean.RowsDTO> list = new Gson().fromJson(json, LawBean.class).getRows();
                if (list.size() == 0) {
                    Toast.makeText(LawListActivity.this, "暂无相关律师", Toast.LENGTH_SHORT).show();
                    finish();
                }
                lawRecyc.setAdapter(new LawAdapter(LawListActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void shuai(View view) {
        new LawTypeDialog(this, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                id = json;
                resort(tabLayout.getSelectedTabPosition());
            }
        }).show();
    }
}