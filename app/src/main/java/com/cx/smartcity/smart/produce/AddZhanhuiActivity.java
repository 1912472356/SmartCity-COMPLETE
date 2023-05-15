package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ZhanhuiBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AddZhanhuiActivity extends AppCompatActivity {
    private EditText title;
    private EditText date;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_zhanhui);
        title = (EditText) findViewById(R.id.title);
        date = (EditText) findViewById(R.id.date);
        content = (EditText) findViewById(R.id.content);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddZhanhuiActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(i+"-"+(i1+1)+"-"+i2);
                    }
                }, 2022, 1, 1).show();
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {

        Type type = new TypeToken<List<ZhanhuiBean>>() {
        }.getType();
        List<ZhanhuiBean> list = new Gson().fromJson(SPUtil.get(SPUtil.ZHIZAO_ZHANHUI),type);
        list.add(new ZhanhuiBean(title.getText().toString(), content.getText().toString(), date.getText().toString()));
        SPUtil.put(SPUtil.ZHIZAO_ZHANHUI, new Gson().toJson(list));
        finish();
        Toast.makeText(this, "展会发布成功", Toast.LENGTH_SHORT).show();
    }
}