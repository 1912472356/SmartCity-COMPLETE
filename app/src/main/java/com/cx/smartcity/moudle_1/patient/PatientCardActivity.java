package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.PatientBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class PatientCardActivity extends AppCompatActivity {
    private RecyclerView patientRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_card);
        patientRecyc = (RecyclerView) findViewById(R.id.patient_recyc);
        patientRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        RetrofitUtil.get("/prod-api/api/hospital/patient/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PatientBean.RowsDTO> list = new Gson().fromJson(json, PatientBean.class).getRows();
                patientRecyc.setAdapter(new PatientAdapter(PatientCardActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, AddPatietnActivity.class));
    }
}