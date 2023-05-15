package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.YanglaoBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class YanglaoActivity extends AppCompatActivity implements View.OnClickListener {
    private SearchView searchEt;
    private LinearLayout pinggu;
    private LinearLayout yuyue;
    private LinearLayout pingtai;
    private LinearLayout jilu;
    private LinearLayout jizhong;
    private RecyclerView yanglaoRecyc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanglao);
        searchEt = (SearchView) findViewById(R.id.search_et);
        pinggu = (LinearLayout) findViewById(R.id.pinggu);
        yuyue = (LinearLayout) findViewById(R.id.yuyue);
        pingtai = (LinearLayout) findViewById(R.id.pingtai);
        jilu = (LinearLayout) findViewById(R.id.jilu);
        jizhong = (LinearLayout) findViewById(R.id.jizhong);
        yanglaoRecyc = (RecyclerView) findViewById(R.id.yanglao_recyc);


        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(YanglaoActivity.this, SearchYanglaoActivity.class);
                intent.putExtra("name", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        pinggu.setOnClickListener(this);
        yuyue.setOnClickListener(this);
        pingtai.setOnClickListener(this);
        jilu.setOnClickListener(this);
        jizhong.setOnClickListener(this);

        yanglaoRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<YanglaoBean>>() {
        }.getType();
        List<YanglaoBean> list = new Gson().fromJson(SPUtil.get(SPUtil.YANGLAO), type);
        yanglaoRecyc.setAdapter(new YanglaoAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pinggu:
                startActivity(new Intent(this, PingguActivity.class));
                break;
            case R.id.yuyue:
                startActivity(new Intent(this, YanglaoYuyueActivity.class));
                break;
            case R.id.pingtai:
                startActivity(new Intent(this, PingtaiActivity.class));
                break;
            case R.id.jilu:
                startActivity(new Intent(this, YanglaoJIluActivity.class));
                break;
            case R.id.jizhong:
                startActivity(new Intent(this, YanglaoJIzhongActivity.class));
                break;
        }
    }
}