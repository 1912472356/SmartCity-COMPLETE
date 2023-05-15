package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.CheliangBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddCheliangActivity extends AppCompatActivity {
    private EditText carNo;
    private EditText chewei;
    private EditText parkNo;
    private EditText name;
    private EditText phone;
    private EditText addressName;
    private EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cheliang);
        carNo = (EditText) findViewById(R.id.car_no);
        chewei = (EditText) findViewById(R.id.chewei);
        parkNo = (EditText) findViewById(R.id.park_no);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        addressName = (EditText) findViewById(R.id.addressName);
        address = (EditText) findViewById(R.id.address);

        
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        CheliangBean cheliangBean = new CheliangBean(
                carNo.getText().toString(),
                chewei.getText().toString(),
                parkNo.getText().toString(),
                name.getText().toString(),
                phone.getText().toString(),
                addressName.getText().toString(),
                address.getText().toString()
        );

        Type type = new TypeToken<List<CheliangBean>>() {
        }.getType();
        List<CheliangBean> list = new Gson().fromJson(SPUtil.get(SPUtil.SHEQU_CHELIANG), type);
        list.add(cheliangBean);
        SPUtil.put(SPUtil.SHEQU_CHELIANG, new Gson().toJson(list));
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}