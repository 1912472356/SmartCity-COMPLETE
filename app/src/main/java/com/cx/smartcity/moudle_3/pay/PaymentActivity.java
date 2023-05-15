package com.cx.smartcity.moudle_3.pay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.RecentCallBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    private TextView call;
    private TabLayout tabLayout;
    private String ph;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        call = (TextView) findViewById(R.id.call);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

         ph = getIntent().getStringExtra("call");
         type = getIntent().getStringExtra("type");
        call.setText("手机缴费："+ph);

    }

    public void back(View view) {
        finish();
    }

    public void pay(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("paymentType", "电子支付");
        map.put("phonenumber", ph);
        map.put("rechargeAmount",Math.min(50, tabLayout.getSelectedTabPosition() * 100));
        map.put("type", "1");
        RetrofitUtil.post("/prod-api/api/living/phone/recharge", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(PaymentActivity.this, "充值成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(PaymentActivity.this, "充值失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void add(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Type typeToken = new TypeToken<List<RecentCallBean>>() {
        }.getType();
        List<RecentCallBean> list = new Gson().fromJson(SPUtil.get(SPUtil.RECENT_CALL), typeToken);
        for (RecentCallBean row : list) {
            if (row.getTell().equals(ph) && row.getType().equals(type)) {
                Toast.makeText(this, "添加过该手机号", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        list.add(new RecentCallBean(ph, type, sdf.format(new Date())));
        SPUtil.put(SPUtil.RECENT_CALL, new Gson().toJson(list));
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();

    }
}