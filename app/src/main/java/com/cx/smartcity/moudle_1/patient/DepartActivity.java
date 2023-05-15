package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.DepartBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DepartActivity extends AppCompatActivity {
    private ListView departRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart);
        departRecyc = (ListView) findViewById(R.id.depart_recyc);
        departRecyc.setDivider(new ColorDrawable(Color.LTGRAY));
        departRecyc.setDividerHeight(1);

        RetrofitUtil.get("/prod-api/api/hospital/category/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<DepartBean.RowsDTO> list = new Gson().fromJson(json, DepartBean.class).getRows();
                List<String> arr = new ArrayList<>();
                for (DepartBean.RowsDTO row : list) {
                    arr.add(row.getCategoryName());
                }
                departRecyc.setAdapter(new ArrayAdapter<String>(DepartActivity.this, R.layout.support_simple_spinner_dropdown_item, arr));
                departRecyc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        DepartBean.RowsDTO rowsDTO = list.get(i);
                        Intent intent = new Intent(DepartActivity.this, SubPatientActivity.class);
                        intent.putExtra("name", rowsDTO.getCategoryName());
                        intent.putExtra("type", rowsDTO.getType());
                        startActivity(intent);
                    }
                });
            }
        });
    }

    public void back(View view) {
        finish();
    }
}