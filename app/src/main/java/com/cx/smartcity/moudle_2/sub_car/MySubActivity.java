package com.cx.smartcity.moudle_2.sub_car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.SubCarOrderBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MySubActivity extends AppCompatActivity {
    private RecyclerView subRecyc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sub);
        subRecyc = (RecyclerView) findViewById(R.id.sub_recyc);

        subRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/traffic/checkCar/apply/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<SubCarOrderBean.RowsDTO> list = new Gson().fromJson(json, SubCarOrderBean.class).getRows();
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (SubCarOrderBean.RowsDTO row : list) {
                    titles.add(row.getPlateNo());
                    arr.add("预约时间："+row.getAptTime()+"\n预约检车地点："+row.getPlaceName());
                }
                subRecyc.setAdapter(new CommonAdapter(MySubActivity.this, arr, titles));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}