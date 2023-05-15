package com.cx.smartcity.smart.environ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HuanbaoYuyueBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class YuyueLishActivity extends AppCompatActivity {
    private RecyclerView hisRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_lish);

        hisRecyc = (RecyclerView) findViewById(R.id.his_recyc);

        hisRecyc.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        Type type = new TypeToken<List<HuanbaoYuyueBean>>() {
        }.getType();
        List<HuanbaoYuyueBean> list = new Gson().fromJson(SPUtil.get(SPUtil.HUANBAO_YUYUE), type);
        List<String> arr = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (HuanbaoYuyueBean row : list) {
            titles.add(row.getDate());
            arr.add("垃圾种类："+row.getType()
                    +"\n联系电话："+row.getPhone()
                    +"\n预约地址："+row.getAddress()
                    );
        }
        hisRecyc.setAdapter(new CommonAdapter(this, arr,titles));
    }

    public void back(View view) {
        finish();
    }
}