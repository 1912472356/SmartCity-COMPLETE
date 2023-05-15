package com.cx.smartcity.moudle_1.lib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LibraryBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {
    private RecyclerView libRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        libRecyc = (RecyclerView) findViewById(R.id.lib_recyc);

        libRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/digital-library/library/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<LibraryBean.RowsDTO> list = new Gson().fromJson(json, LibraryBean.class).getRows();
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (LibraryBean.RowsDTO row : list) {
                    titles.add(row.getName());
                    arr.add("营业时间："+row.getBusinessHours()
                            +"\n营业状态："+(row.getBusinessState().equals("0")?"未营业":"营业中")
                            +"\n图书馆具体地址："+row.getAddress()
                            +"");
                }
                libRecyc.setAdapter(new CommonAdapter(LibraryActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(LibraryActivity.this, LibDetailActivity.class);
                        intent.putExtra("data", list.get(Integer.parseInt(json)));
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}