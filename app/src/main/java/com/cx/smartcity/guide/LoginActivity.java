package com.cx.smartcity.guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private EditText nameEt;
    private EditText pwdEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameEt = (EditText) findViewById(R.id.name_et);
        pwdEt = (EditText) findViewById(R.id.pwd_et);

        if (SPUtil.get(SPUtil.TOKEN) != null) {
            RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    try {
                        JSONObject obj = new JSONObject(json);
                        if (obj.getInt("code") == 200) {
                            Toast.makeText(LoginActivity.this, "已登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, ""+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            SPUtil.put(SPUtil.TOKEN, null);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void login(View view) {
        final HashMap<Object, Object> map = new HashMap<>();
        map.put("username", nameEt.getText().toString());
        map.put("password", pwdEt.getText().toString());

        RetrofitUtil.post("/prod-api/api/login", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        SPUtil.put(SPUtil.TOKEN, obj.getString("token"));
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this, "登录失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}