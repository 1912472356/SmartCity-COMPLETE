package com.cx.smartcity.moudle_2.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BusBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BusSubActivity extends AppCompatActivity {
    private TextView content;
    private Map map;
    private BusBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_sub);
        map = (Map) getIntent().getSerializableExtra("data");

        content = (TextView) findViewById(R.id.content);

        content.setText("乘客姓名："+map.get("name")
                +"\n手机号码："+map.get("tel")
                +"\n上车地点："+map.get("entry")
                +"\n下车地点："+map.get("out")
                +"\n乘车日期："+map.get("date"));

        data = new Gson().fromJson(SPUtil.get(SPUtil.BUS_MSG), BusBean.RowsDTO.class);
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> mMap = new HashMap<>();
        mMap.put("start", map.get("entry"));
        mMap.put("end", map.get("out"));
        mMap.put("price", data.getPrice());
        mMap.put("path", data.getName());
        mMap.put("status", 0);
        RetrofitUtil.post("/prod-api/api/bus/order", mMap, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(BusSubActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(BusSubActivity.this, "提交失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}