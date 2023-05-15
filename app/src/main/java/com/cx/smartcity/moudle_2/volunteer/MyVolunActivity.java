package com.cx.smartcity.moudle_2.volunteer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.VolunBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.List;

public class MyVolunActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private RecyclerView volunRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_volun);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        volunRecyc = (RecyclerView) findViewById(R.id.volun_recyc);
        volunRecyc.setLayoutManager(new LinearLayoutManager(this));
        load(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                load(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void load(final int i) {
        RetrofitUtil.get("/prod-api/api/volunteer-service/activity/my-list/"+i, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<VolunBean.RowsDTO> list = new Gson().fromJson(json, VolunBean.class).getRows();
                if (list.size() == 0) {
                    Toast.makeText(MyVolunActivity.this, "暂无相关活动", Toast.LENGTH_SHORT).show();
                }
                volunRecyc.setAdapter(new VolunAdapter(MyVolunActivity.this, list, i, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        load(i);
                    }
                }));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}