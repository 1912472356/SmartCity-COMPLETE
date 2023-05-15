package com.cx.smartcity.moudle_2.consult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ConsultBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.List;

public class ConsultListActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private RecyclerView consultRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_list);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        consultRecyc = (RecyclerView) findViewById(R.id.consult_recyc);

        consultRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadData(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadData(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void loadData(int position) {
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/legal-advice/list?state="+position, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<ConsultBean.RowsDTO> list = new Gson().fromJson(json, ConsultBean.class).getRows();
                if (list.size() == 0) {
                    Toast.makeText(ConsultListActivity.this, "暂无咨询", Toast.LENGTH_SHORT).show();
                }
                consultRecyc.setAdapter(new ConsultAdapter(ConsultListActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}