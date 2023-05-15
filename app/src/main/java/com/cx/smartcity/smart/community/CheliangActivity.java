package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.CheliangBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CheliangActivity extends AppCompatActivity {
    private RecyclerView carRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheliang);
        carRecyc = (RecyclerView) findViewById(R.id.car_recyc);

        carRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Type type = new TypeToken<List<CheliangBean>>() {
        }.getType();
        List<CheliangBean> list = new Gson().fromJson(SPUtil.get(SPUtil.SHEQU_CHELIANG), type);
        if (list.size() == 0) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        }
        List<String> arr = new ArrayList<>();
        for (CheliangBean row : list) {
            arr.add("车牌号码："+row.getCarNo()
                    +"\n车位号："+row.getChewei()
                    +"\n停车卡号："+row.getParkNo()
                    +"\n车主姓名："+row.getName()
                    +"\n车主手机号："+row.getPhone()
                    +"\n住户姓名："+row.getAddressName()
                    +"\n地址："+row.getAddress());
        }
        carRecyc.setAdapter(new CommonAdapter(this, arr, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                Intent intent = new Intent(CheliangActivity.this, ModifyCheliangActivity.class);
                intent.putExtra("id", Integer.parseInt(json));
                startActivity(intent);
            }
        }));
    }

    public void back(View view) {
        finish();
    }

    public void more(View view) {
        startActivity(new Intent(this, AddCheliangActivity.class));
    }
}