package com.cx.smartcity.moudle_3.kitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.KitchenBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class MyCollectActivity extends AppCompatActivity {
    private RecyclerView kitchenRecyc;
    private TextView cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        cnt = (TextView) findViewById(R.id.cnt);


        kitchenRecyc = (RecyclerView) findViewById(R.id.kitchen_recyc);
        kitchenRecyc.setLayoutManager(new LinearLayoutManager(this));

        RetrofitUtil.get("/prod-api/api/kitchen-helper/dishes-collection/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<KitchenBean.RowsDTO> list = new Gson().fromJson(json, KitchenBean.class).getRows();
                cnt.setText("共收藏了"+list.size()+"个菜品");
                kitchenRecyc.setAdapter(new KitchenAdapter(MyCollectActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}