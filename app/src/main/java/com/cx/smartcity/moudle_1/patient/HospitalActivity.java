package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HospitalBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class HospitalActivity extends AppCompatActivity {
    private ImageView layout;
    private SearchView searchEt;
    private RecyclerView hosRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        layout = (ImageView) findViewById(R.id.layout);
        searchEt = (SearchView) findViewById(R.id.search_et);
        hosRecyc = (RecyclerView) findViewById(R.id.hos_recyc);

        hosRecyc.setLayoutManager(new LinearLayoutManager(this));
        load("");
        initLayout();
        initSearch();
    }

    private void initLayout() {
        layout.setTag("0");
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout.getTag().equals("0")) {
                    hosRecyc.setLayoutManager(new GridLayoutManager(HospitalActivity.this, 2));
                    layout.setTag("1");
                }else {
                    hosRecyc.setLayoutManager(new LinearLayoutManager(HospitalActivity.this));
                    layout.setTag("0");
                }
            }
        });
    }

    private void initSearch() {
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

    private void load(String query) {
        RetrofitUtil.get("/prod-api/api/hospital/hospital/list?hospitalName="+query, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<HospitalBean.RowsDTO> list = new Gson().fromJson(json, HospitalBean.class).getRows();
                hosRecyc.setAdapter(new HospitalAdapter(HospitalActivity.this, list));
            }
        });
    }
    public void back(View view) {
        finish();
    }
}