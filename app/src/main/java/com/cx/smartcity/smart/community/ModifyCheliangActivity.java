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
import java.util.List;

public class ModifyCheliangActivity extends AppCompatActivity {
    private EditText carNo;
    private EditText chewei;
    private EditText parkNo;
    private EditText name;
    private EditText phone;
    private EditText addressName;
    private EditText address;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cheliang);

        carNo = (EditText) findViewById(R.id.car_no);
        chewei = (EditText) findViewById(R.id.chewei);
        parkNo = (EditText) findViewById(R.id.park_no);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        addressName = (EditText) findViewById(R.id.addressName);
        address = (EditText) findViewById(R.id.address);

        id = getIntent().getIntExtra("id", -1);

        Type type = new TypeToken<List<CheliangBean>>() {
        }.getType();
        List<CheliangBean> list = new Gson().fromJson(SPUtil.get(SPUtil.SHEQU_CHELIANG), type);
        CheliangBean cheliangBean = list.get(id);
        carNo.setText(cheliangBean.getCarNo());
        chewei.setText(cheliangBean.getChewei());
        parkNo.setText(cheliangBean.getParkNo());
        name.setText(cheliangBean.getName());
        phone.setText(cheliangBean.getPhone());
        addressName.setText(cheliangBean.getAddressName());
        address.setText(cheliangBean.getAddress());
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
        list.set(id, cheliangBean);
        SPUtil.put(SPUtil.SHEQU_CHELIANG, new Gson().toJson(list));
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}