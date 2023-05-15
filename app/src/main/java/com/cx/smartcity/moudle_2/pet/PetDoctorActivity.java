package com.cx.smartcity.moudle_2.pet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.PetDoctorBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class PetDoctorActivity extends AppCompatActivity {
    private RecyclerView doctorRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_doctor);
        doctorRecyc = (RecyclerView) findViewById(R.id.doctor_recyc);

        int id = getIntent().getIntExtra("id", 11);
        doctorRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/pet-hospital/pet-doctor/list?typeId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PetDoctorBean.RowsDTO> list = new Gson().fromJson(json, PetDoctorBean.class).getRows();
                doctorRecyc.setAdapter(new PetDoctorAdapter(PetDoctorActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}