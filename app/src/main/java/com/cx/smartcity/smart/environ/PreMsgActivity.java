package com.cx.smartcity.smart.environ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HuanbaoYuyueBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class PreMsgActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText address;
    private Spinner sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_msg);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        sex = (Spinner) findViewById(R.id.sex);

        HuanbaoYuyueBean huanbaoYuyueBean = new Gson().fromJson(SPUtil.get(SPUtil.HUANBAO_PRE_MSg), HuanbaoYuyueBean.class);
        name.setText(huanbaoYuyueBean.getType());
        phone.setText(huanbaoYuyueBean.getPhone());
        address.setText(huanbaoYuyueBean.getAddress());
        sex.setSelection(Integer.parseInt(huanbaoYuyueBean.getDate()));
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HuanbaoYuyueBean huanbaoYuyueBean = new HuanbaoYuyueBean(name.getText().toString(), sex.getSelectedItemPosition() + "", phone.getText().toString(), address.getText().toString());
        SPUtil.put(SPUtil.HUANBAO_PRE_MSg, new Gson().toJson(huanbaoYuyueBean));
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}