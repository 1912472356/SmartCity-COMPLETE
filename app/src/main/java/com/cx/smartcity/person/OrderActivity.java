package com.cx.smartcity.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.BusOrderBean;
import com.cx.smartcity.bean.OrderBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView orderRecyc;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderRecyc = (RecyclerView) findViewById(R.id.order_recyc);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

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

        orderRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadData(0);
    }

    private void loadData(int toString) {
        RetrofitUtil.get("/prod-api/api/bus/order/list?status="+toString, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<BusOrderBean.RowsDTO> list = new Gson().fromJson(json, BusOrderBean.class).getRows();

                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();

                for (BusOrderBean.RowsDTO row : list) {
                    titles.add("订单编号："+row.getOrderNum());
                    arr.add("路线名称："+row.getPath()
                            +"\n起点："+row.getStart()
                            +"\n终点："+row.getEnd()
                            +"\n票价："+row.getPrice()+"元"
                            +"\n乘车日期："+row.getCreateTime());
                }
                orderRecyc.setAdapter(new CommonAdapter(OrderActivity.this, arr, titles));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}