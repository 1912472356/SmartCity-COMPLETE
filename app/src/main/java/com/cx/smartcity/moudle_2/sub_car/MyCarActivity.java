package com.cx.smartcity.moudle_2.sub_car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.CarBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyCarActivity extends AppCompatActivity {
    private RecyclerView carRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        carRecyc = (RecyclerView) findViewById(R.id.car_recyc);
        carRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        RetrofitUtil.get("/prod-api/api/traffic/car/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<CarBean.RowsDTO> list = new Gson().fromJson(json, CarBean.class).getRows();
                final List<String> arr = new ArrayList<>();
                final List<String> titles = new ArrayList<>();
                RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        String phonenumber = new Gson().fromJson(json, UserBean.class).getUser().getPhonenumber();
                        for (CarBean.RowsDTO row : list) {
                            titles.add(row.getPlateNo());
                            arr.add("车架号："+row.getEngineNo()
                                    +"\n车辆类型："+row.getType()
                                    +"\n公里数：100Km"
                                    +"\n手机号："+phonenumber);
                        }

                        carRecyc.setAdapter(new CommonAdapter(MyCarActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                            @Override
                            public void onRequest(String json) {
                                Intent intent = new Intent(MyCarActivity.this, AddMyCarActivity.class);
                                intent.putExtra("data", list.get(Integer.parseInt(json)));
                                startActivity(intent);
                            }
                        }));
                    }
                });
            }
        });

    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        Intent intent = new Intent(MyCarActivity.this, AddMyCarActivity.class);
        startActivity(intent);
    }
}