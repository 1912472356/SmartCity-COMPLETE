package com.cx.smartcity.moudle_2.bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BusBean;
import com.cx.smartcity.bean.BusSizeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BusDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView start;
    private TextView end;
    private TextView content;
    private RecyclerView sizeRecyc;
    private BusBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_detail);
        title = (TextView) findViewById(R.id.title);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        content = (TextView) findViewById(R.id.content);
        sizeRecyc = (RecyclerView) findViewById(R.id.size_recyc);

        data = (BusBean.RowsDTO) getIntent().getSerializableExtra("data");

        title.setText(data.getName());
        start.setText(data.getFirst());
        end.setText(data.getEnd());
        content.setText("运行时间：首班|"+data.getStartTime()+"，末班|"+data.getEndTime()
                +"\n票价："+data.getPrice()+"元"
                +"\n里程："+data.getMileage()+"Km");

        sizeRecyc.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        RetrofitUtil.get("/prod-api/api/bus/stop/list?linesId="+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<BusSizeBean.RowsDTO> list = new Gson().fromJson(json, BusSizeBean.class).getRows();
                sizeRecyc.setAdapter(new BusSiteAdapter(BusDetailActivity.this, list));
            }
        });

    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        SPUtil.put(SPUtil.BUS_MSG, new Gson().toJson(data));
        startActivity(new Intent(this, BusDateActivity.class));
    }
}