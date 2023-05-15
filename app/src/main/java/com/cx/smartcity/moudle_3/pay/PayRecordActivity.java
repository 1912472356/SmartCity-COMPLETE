package com.cx.smartcity.moudle_3.pay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.CallPayRecordBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PayRecordActivity extends AppCompatActivity {
    private RecyclerView recordRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_record);
        recordRecyc = (RecyclerView) findViewById(R.id.record_recyc);
        recordRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/living/phone/record/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<CallPayRecordBean.RowsDTO> list = new Gson().fromJson(json, CallPayRecordBean.class).getRows();
                List<String> arr = new ArrayList<>();
                List<String> titles = new ArrayList<>();
                for (CallPayRecordBean.RowsDTO row : list) {
                    titles.add(row.getPhonenumber());
                    arr.add(row.getRechargeTime()+"交费");
                }

                recordRecyc.setAdapter(new CommonAdapter(PayRecordActivity.this,arr, titles));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}