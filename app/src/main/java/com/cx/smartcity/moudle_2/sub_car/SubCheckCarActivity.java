package com.cx.smartcity.moudle_2.sub_car;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.CarBean;
import com.cx.smartcity.bean.SubCarBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubCheckCarActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private EditText date;
    private EditText address;

    private int addId;
    private List<CarBean.RowsDTO> carList;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_check_car);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        date = (EditText) findViewById(R.id.date);
        address = (EditText) findViewById(R.id.address);

        initMsg();

        initCheck();


    }

    private void initMsg() {
        RetrofitUtil.get("/prod-api/api/traffic/car/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                carList = new Gson().fromJson(json, CarBean.class).getRows();
                if (carList.size() == 0) {
                    startActivity(new Intent(SubCheckCarActivity.this, MyCarActivity.class));
                    finish();
                }else {
                    int idx = 0;
                    for (CarBean.RowsDTO row : carList) {
                        RadioButton button = new RadioButton(SubCheckCarActivity.this);
                        button.setText(row.getPlateNo());
                        button.setPadding(10, 10, 10, 10);
                        button.setTag(idx);
                        button.setChecked(true);
                        button.setId(idx ++);
                        radioGroup.addView(button);
                    }
                }

            }
        });
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                userId = new Gson().fromJson(json, UserBean.class).getUser().getUserId();
            }
        });
    }

    private void initCheck() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SubCheckCarActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(i+"-"+(i1+1) + "-" + i2);
                    }
                }, 2022, 1, 1).show();
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitUtil.get("/prod-api/api/traffic/checkCar/place/list", new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        final List<SubCarBean.RowsDTO> list = new Gson().fromJson(json, SubCarBean.class).getRows();
                        List<CharSequence> arr = new ArrayList<>();
                        for (SubCarBean.RowsDTO row : list) {
                            arr.add(row.getPlaceName());
                        }
                        final AlertDialog.Builder builder = new AlertDialog.Builder(SubCheckCarActivity.this);
                        builder.setTitle("选择地点");
                        builder.setSingleChoiceItems(arr.toArray(new CharSequence[list.size()]), 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SubCarBean.RowsDTO rowsDTO = list.get(i);
                                address.setText(rowsDTO.getPlaceName());
                                addId = rowsDTO.getId();
                            }
                        });
                        builder.show();
                    }
                });
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void sub(View view) {
        int carid = carList.get(radioGroup.getCheckedRadioButtonId()).getId();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("carId", carid);
        map.put("aptTime", date.getText().toString());
        map.put("addressId", addId);
        RetrofitUtil.post("/prod-api/api/traffic/checkCar/apply", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(SubCheckCarActivity.this, "预约成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SubCheckCarActivity.this, MySubActivity.class));
                    }else {
                        Toast.makeText(SubCheckCarActivity.this, "预约失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}