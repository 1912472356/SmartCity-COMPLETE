package com.cx.smartcity.moudle_2.law;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LawTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

public class LawTypeActivity extends AppCompatActivity {
    private RecyclerView typeRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_type);
        typeRecyc = (RecyclerView) findViewById(R.id.type_recyc);

        typeRecyc.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/legal-expertise/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LawTypeBean.RowsDTO> list = new Gson().fromJson(json, LawTypeBean.class).getRows();
                Collections.reverse(list);
                typeRecyc.setAdapter(new LawTypeAdapter(LawTypeActivity.this, list, true));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}