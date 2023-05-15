package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CasePubActivity extends AppCompatActivity {
    private RecyclerView caseRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_pub);
        caseRecyc = (RecyclerView) findViewById(R.id.case_recyc);

        caseRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<FupingBean>>(){}.getType();
        List<FupingBean> list = new Gson().fromJson(SPUtil.get(SPUtil.FUPING_CASE), type);
        caseRecyc.setAdapter(new FupingAdapter(this, list));
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, AddCaseActivity.class));
    }
}