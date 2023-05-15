package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubPatientActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private RecyclerView subRecyc;
    private TextView noData;
    private String name;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_patient);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        subRecyc = (RecyclerView) findViewById(R.id.sub_recyc);
        noData = (TextView) findViewById(R.id.no_data);
        name = getIntent().getStringExtra("name");
        type = getIntent().getStringExtra("type");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    noData.setVisibility(View.VISIBLE);
                    subRecyc.setVisibility(View.GONE);
                }else {
                    noData.setVisibility(View.GONE);
                    subRecyc.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        subRecyc.setLayoutManager(new LinearLayoutManager(this));
        load();
    }

    private void load() {
        List<String> titles = new ArrayList<>();
        final List<String> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            titles.add("预约科室："+name);
        }

        arr.add("2020-9-21 周一， 下午14:00");
        arr.add("2020-9-21 周一， 下午15:00");
        arr.add("2020-9-21 周一， 下午16:00");
        arr.add("2020-9-21 周一， 下午17:00");
        arr.add("2020-9-21 周一， 下午18:00");
        arr.add("2020-9-21 周一， 下午19:00");
        arr.add("2020-9-21 周一， 下午20:00");
        arr.add("2020-9-22 周二， 下午8:00");
        arr.add("2020-9-22 周二， 下午9:00");
        arr.add("2020-9-22 周二， 下午10:00");

        subRecyc.setAdapter(new SubPatientAdapter(this, arr, titles, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                Intent intent = new Intent(SubPatientActivity.this, SubResultActivity.class);
                intent.putExtra("title", "预约科室："+name);
                intent.putExtra("content", "门诊类型："+(type.equals("1")?"专家诊":"普通诊")+"\n预约时间："+arr.get(Integer.parseInt(json)));
                startActivity(intent);
            }
        }));
    }

    public void back(View view) {
        finish();
    }
}