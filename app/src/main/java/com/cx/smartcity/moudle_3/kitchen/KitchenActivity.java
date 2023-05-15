package com.cx.smartcity.moudle_3.kitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.KitchenBean;
import com.cx.smartcity.bean.KitchenHotBean;
import com.cx.smartcity.util.ListAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class KitchenActivity extends AppCompatActivity {
    private SearchView searchEt;
    private RecyclerView hosRecyc;
    private RecyclerView kitchenRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        searchEt = (SearchView) findViewById(R.id.search_et);
        hosRecyc = (RecyclerView) findViewById(R.id.hos_recyc);
        kitchenRecyc = (RecyclerView) findViewById(R.id.kitchen_recyc);

        kitchenRecyc.setLayoutManager(new LinearLayoutManager(this));
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                load(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        hosRecyc.requestFocus();
        hosRecyc.requestFocusFromTouch();
        RetrofitUtil.get("/prod-api/api/kitchen-helper/dishes/hot-keywords", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<KitchenHotBean.DataDTO> list = new Gson().fromJson(json, KitchenHotBean.class).getData().subList(0, 15);
                final List<String> arr = new ArrayList<>();
                for (KitchenHotBean.DataDTO row : list) {
                    arr.add(row.getKeyword());
                }
                hosRecyc.setLayoutManager(new GridLayoutManager(KitchenActivity.this, 5));
                hosRecyc.setAdapter(new ListAdapter(KitchenActivity.this, arr, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        load(arr.get(Integer.parseInt(json)));
                    }
                }));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        load(searchEt.getQuery().toString());
    }

    private void load(String s) {
        RetrofitUtil.get("/prod-api/api/kitchen-helper/dishes/list?name="+s, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<KitchenBean.RowsDTO> list = new Gson().fromJson(json, KitchenBean.class).getRows();
                kitchenRecyc.setAdapter(new KitchenAdapter(KitchenActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void collect(View view) {
        startActivity(new Intent(this, MyCollectActivity.class));
    }
}