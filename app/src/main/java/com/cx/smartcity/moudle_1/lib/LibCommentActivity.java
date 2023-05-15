package com.cx.smartcity.moudle_1.lib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LibCommentBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LibCommentActivity extends AppCompatActivity {
    private RecyclerView commentRecyc;
    private EditText commentEt;
    private Button commentBtn;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_comment);
        commentRecyc = (RecyclerView) findViewById(R.id.comment_recyc);
        commentEt = (EditText) findViewById(R.id.comment_et);
        commentBtn = (Button) findViewById(R.id.comment_btn);

        commentRecyc.setLayoutManager(new LinearLayoutManager(this));
        id = getIntent().getIntExtra("id", 11);
        loadCommnet();

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = commentEt.getText().toString();
                commentEt.setText("");
                HashMap<Object, Object> map = new HashMap<>();
                map.put("libraryId", id);
                map.put("content", s);
                RetrofitUtil.post("/prod-api/api/digital-library/library-comment", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(LibCommentActivity.this, "发表成功", Toast.LENGTH_SHORT).show();
                                loadCommnet();
                            }else {
                                Toast.makeText(LibCommentActivity.this, "发表失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void loadCommnet() {
        RetrofitUtil.get("/prod-api/api/digital-library/library-comment/list?libraryId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LibCommentBean.DataDTO> list = new Gson().fromJson(json, LibCommentBean.class).getData();
                list = new ArrayList<>();  // 接口无效
                Collections.sort(list);
                commentRecyc.setAdapter(new LibCommentAdapter(LibCommentActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}