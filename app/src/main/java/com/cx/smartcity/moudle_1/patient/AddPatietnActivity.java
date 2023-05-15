package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.PatientBean;
import com.cx.smartcity.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

public class AddPatietnActivity extends AppCompatActivity {
    private EditText name;
    private Spinner sex;
    private EditText card;
    private EditText date;
    private EditText tell;
    private EditText address;
    private PatientBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patietn);
        initView();
        Serializable serializableExtra = getIntent().getSerializableExtra("data");
        if (serializableExtra != null) {
            data = (PatientBean.RowsDTO) serializableExtra;
            name.setText(data.getName());
            sex.setSelection(Integer.parseInt(data.getSex()));
            card.setText(data.getCardId());
            date.setText(data.getBirthday());
            tell.setText(data.getTel());
            address.setText(data.getAddress());
        }

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddPatietnActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(i+"-"+(i1+1) + "-"+i2);
                    }
                }, 2022, 1, 1).show();
            }
        });
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        sex = (Spinner) findViewById(R.id.sex);
        card = (EditText) findViewById(R.id.card);
        date = (EditText) findViewById(R.id.date);
        tell = (EditText) findViewById(R.id.tell);
        address = (EditText) findViewById(R.id.address);
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("address", address.getText().toString());
        map.put("birthday", date.getText().toString());
        map.put("cardId", card.getText().toString());
        map.put("name", name.getText().toString());
        map.put("sex", sex.getSelectedItemPosition());
        map.put("tel", tell.getText().toString());

        RetrofitUtil.OnRequest onRequest = new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(AddPatietnActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddPatietnActivity.this, "保存失败：" + obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        if (data == null) {
            RetrofitUtil.post("/prod-api/api/hospital/patient", map, onRequest);
        }else {
            map.put("id", data.getId());
            RetrofitUtil.put("/prod-api/api/hospital/patient", map, onRequest);
        }
    }
}