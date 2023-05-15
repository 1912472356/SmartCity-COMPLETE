package com.cx.smartcity.moudle_2.move;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.WuliuBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TousuActivity extends AppCompatActivity {
    private Spinner type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tousu);
        type = (Spinner) findViewById(R.id.type);

        RetrofitUtil.get("/prod-api/api/logistics-inquiry/logistics_company/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<WuliuBean.DataDTO> data = new Gson().fromJson(json, WuliuBean.class).getData();
                List<String> arr = new ArrayList<>();
                for (WuliuBean.DataDTO row : data) {
                    arr.add(row.getName());
                }
                type.setAdapter(new ArrayAdapter<String>(TousuActivity.this, R.layout.support_simple_spinner_dropdown_item, arr));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        Toast.makeText(this, "投诉成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}