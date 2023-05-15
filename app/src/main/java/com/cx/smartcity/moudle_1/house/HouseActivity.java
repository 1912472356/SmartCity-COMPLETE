package com.cx.smartcity.moudle_1.house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HouseBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class HouseActivity extends AppCompatActivity {
    private SearchView searchEt;
    private RecyclerView houseRecyc;
    private String id = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        searchEt = (SearchView) findViewById(R.id.search_et);
        houseRecyc = (RecyclerView) findViewById(R.id.house_recyc);

        houseRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadData("");

        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                id = "";
                loadData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void loadData(String name) {
        RetrofitUtil.get("/prod-api/api/house/housing/list?houseType="+id+"&sourceName="+name, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<HouseBean.RowsDTO> list = new Gson().fromJson(json, HouseBean.class).getRows();
                list = list.subList(0, Math.min(30, list.size()));
                houseRecyc.setAdapter(new HouseAdapter(HouseActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void load(View view) {
        switch (view.getId()) {
            case R.id.loupan:
                id = "楼盘";
                break;
            case R.id.zufang:
                id = "租房";
                break;
            case R.id.ershou:
                id = "二手";
                break;
            case R.id.zhizao:
                id = "中介";
                break;
        }
        loadData(searchEt.getQuery().toString());
    }
}