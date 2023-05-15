package com.cx.smartcity.moudle_1.park;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ParkBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ParkActivity extends AppCompatActivity {
    private RecyclerView parkRecyc;
    private Button moreBtn;
    int size = 5;
    private List<ParkBean.RowsDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        parkRecyc = (RecyclerView) findViewById(R.id.park_recyc);
        moreBtn = (Button) findViewById(R.id.more_btn);

        parkRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/park/lot/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list = new Gson().fromJson(json, ParkBean.class).getRows();
                loadData();
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size += 5;
                loadData();
            }
        });
    }

    private void loadData() {
        List<String> arr = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<ParkBean.RowsDTO> dtos = list.subList(0, Math.min(size, list.size()));
        for (ParkBean.RowsDTO row : dtos) {
            titles.add(row.getParkName());
            arr.add("空位数量："+row.getVacancy()+"个"
                    +"\n地址："+row.getAddress()
                    +"\n收费价格："+row.getRates()+"元/小时"
                    +"\n距离："+row.getDistance()+"米");
        }
        if (list.size() <= size)
            moreBtn.setVisibility(View.GONE);
        else moreBtn.setVisibility(View.VISIBLE);
        parkRecyc.setAdapter(new CommonAdapter(ParkActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                Intent intent = new Intent(ParkActivity.this, ParkDetailActivity.class);
                intent.putExtra("data", list.get(Integer.parseInt(json)));
                startActivity(intent);
            }
        }));
    }

    public void back(View view) {
        finish();
    }

    public void his(View view) {
        startActivity(new Intent(this, ParkRecordActivity.class));
    }
}