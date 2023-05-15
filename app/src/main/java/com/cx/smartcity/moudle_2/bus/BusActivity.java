package com.cx.smartcity.moudle_2.bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.BusBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class BusActivity extends AppCompatActivity {
    private RecyclerView busRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        busRecyc = (RecyclerView) findViewById(R.id.bus_recyc);

        busRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/bus/line/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<BusBean.RowsDTO> list = new Gson().fromJson(json, BusBean.class).getRows();
                busRecyc.setAdapter(new BusAdapter(BusActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}