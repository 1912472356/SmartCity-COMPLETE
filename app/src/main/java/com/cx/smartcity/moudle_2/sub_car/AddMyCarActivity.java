package com.cx.smartcity.moudle_2.sub_car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.CarBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

public class AddMyCarActivity extends AppCompatActivity {
    private EditText plate;
    private EditText engin;
    private Spinner type;
    private EditText distance;
    private EditText phone;
    private CarBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_my_car);

        plate = (EditText) findViewById(R.id.plate);
        engin = (EditText) findViewById(R.id.engin);
        type = (Spinner) findViewById(R.id.type);
        distance = (EditText) findViewById(R.id.distance);
        phone = (EditText) findViewById(R.id.phone);

        Serializable ser = getIntent().getSerializableExtra("data");
        if (ser != null) {
            data = (CarBean.RowsDTO) ser;
            plate.setText(data.getPlateNo());
            engin.setText(data.getEngineNo());
            type.setSelection(0);
            distance.setText("100");
            RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    String phonenumber = new Gson().fromJson(json, UserBean.class).getUser().getPhonenumber();
                    phone.setText(phonenumber);
                }
            });
        }
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("engineNo", engin.getText().toString());
        map.put("plateNo",plate.getText().toString());
        map.put("type", type.getSelectedItem().toString());
        if(data != null){
            map.put("id", data.getId());
            RetrofitUtil.put("/prod-api/api/traffic/car", map, new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    try {
                        JSONObject obj = new JSONObject(json);
                        if (obj.getInt("code") == 200) {
                            Toast.makeText(AddMyCarActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(AddMyCarActivity.this, "保存失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }else {
            RetrofitUtil.put("/prod-api/api/traffic/car", map, new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    try {
                        JSONObject obj = new JSONObject(json);
                        if (obj.getInt("code") == 200) {
                            Toast.makeText(AddMyCarActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(AddMyCarActivity.this, "保存失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}