package com.cx.smartcity.person;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ModifyPwdActivity extends AppCompatActivity {
    private EditText oldPwd;
    private EditText newPwd;
    private EditText confirmPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pwd);
        oldPwd = (EditText) findViewById(R.id.old_pwd);
        newPwd = (EditText) findViewById(R.id.new_pwd);
        confirmPwd = (EditText) findViewById(R.id.confirm_pwd);

    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        if (!newPwd.getText().toString().equals(confirmPwd.getText().toString())) {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<Object, Object> map = new HashMap<>();
        map.put("oldPassword", oldPwd.getText().toString());
        map.put("newPassword", newPwd.getText().toString());
        RetrofitUtil.put("/prod-api/api/common/user/resetPwd", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(ModifyPwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(ModifyPwdActivity.this, "修改失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}