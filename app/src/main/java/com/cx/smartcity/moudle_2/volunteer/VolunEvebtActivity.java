package com.cx.smartcity.moudle_2.volunteer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.VolunBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class VolunEvebtActivity extends AppCompatActivity {
    private SearchView searchEt;
    private RecyclerView volunRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun_evebt);
        searchEt = (SearchView) findViewById(R.id.search_et);
        volunRecyc = (RecyclerView) findViewById(R.id.volun_recyc);

        volunRecyc.setLayoutManager(new LinearLayoutManager(this));
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        load(searchEt.getQuery().toString());
    }

    private void load(final String s) {
        RetrofitUtil.get("/prod-api/api/volunteer-service/activity/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<VolunBean.RowsDTO> list = new Gson().fromJson(json, VolunBean.class).getRows();
                List<VolunBean.RowsDTO> arr = new ArrayList<>();
                for (VolunBean.RowsDTO row : list) {
                    if (row.getTitle().contains(s)) {
                        arr.add(row);
                    }
                }
                volunRecyc.setAdapter(new VolunAdapter(VolunEvebtActivity.this, arr, -1, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        load(s);
                    }
                }));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}