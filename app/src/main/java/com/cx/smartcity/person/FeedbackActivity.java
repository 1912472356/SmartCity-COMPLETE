package com.cx.smartcity.person;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class FeedbackActivity extends AppCompatActivity {
    private TextView cnt;
    private EditText content;
    private EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        cnt = (TextView) findViewById(R.id.cnt);
        content = (EditText) findViewById(R.id.content);
        title = (EditText) findViewById(R.id.title);


        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cnt.setText(charSequence.length() + "/150");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        finish();

//        send();
    }

    private void send() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", title.getText().toString());
        map.put("content", content.getText().toString());
        RetrofitUtil.post("/prod-api/api/common/feedback", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(FeedbackActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(FeedbackActivity.this, "提交失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void more(View view) {
        startActivity(new Intent(this, FeedRecordActivity.class));
    }
}