package com.cx.smartcity.moudle_2.pet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.PetInquiryBean;
import com.cx.smartcity.bean.PetTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

public class PetActivity extends AppCompatActivity {
    private RecyclerView typeRecyc;
    private RecyclerView myInquiryRecyc;
    private RecyclerView inquiryRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        typeRecyc = (RecyclerView) findViewById(R.id.type_recyc);
        myInquiryRecyc = (RecyclerView) findViewById(R.id.my_inquiry_recyc);
        inquiryRecyc = (RecyclerView) findViewById(R.id.inquiry_recyc);

        typeRecyc.setLayoutManager(new GridLayoutManager(this, 5));
        RetrofitUtil.get("/prod-api/api/pet-hospital/pet-type/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PetTypeBean.DataDTO> list = new Gson().fromJson(json, PetTypeBean.class).getData();
                typeRecyc.setAdapter(new PetTypeAdapter(PetActivity.this, list));
            }
        });

        myInquiryRecyc.setLayoutManager(new LinearLayoutManager(this));
        inquiryRecyc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        RetrofitUtil.get("/prod-api/api/pet-hospital/inquiry/my-list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PetInquiryBean.RowsDTO> list = new Gson().fromJson(json, PetInquiryBean.class).getRows();
                myInquiryRecyc.setAdapter(new MyCaseAdapter(PetActivity.this, list));
            }
        });

        RetrofitUtil.get("/prod-api/api/pet-hospital/inquiry/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PetInquiryBean.RowsDTO> list = new Gson().fromJson(json, PetInquiryBean.class).getRows().subList(0, 20);
                inquiryRecyc.setAdapter(new CaseAdapter(PetActivity.this, list));
            }
        });


    }

    public void back(View view) {
        finish();
    }
}