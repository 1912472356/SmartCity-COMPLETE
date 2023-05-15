package com.cx.smartcity.smart.environ;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.HuanbaoYuyueBean;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.smart.community.ShequYoulingAdapter;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class YuyueActivity extends AppCompatActivity {
    private Spinner type;
    private EditText date;
    private EditText phone;
    private EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue);
        type = (Spinner) findViewById(R.id.type);
        date = (EditText) findViewById(R.id.date);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(YuyueActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(i+"-"+(i1+1) + "-" + i2);
                    }
                }, 2022, 1, 1).show();;
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        Type type1 = new TypeToken<List<HuanbaoYuyueBean>>() {
        }.getType();
        List<HuanbaoYuyueBean> list = new Gson().fromJson(SPUtil.get(SPUtil.HUANBAO_YUYUE), type1);
        list.add(new HuanbaoYuyueBean(type.getSelectedItem().toString(), date.getText().toString(), phone.getText().toString(), address.getText().toString()));
        SPUtil.put(SPUtil.HUANBAO_YUYUE, new Gson().toJson(list));
        Toast.makeText(this, "预约成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}