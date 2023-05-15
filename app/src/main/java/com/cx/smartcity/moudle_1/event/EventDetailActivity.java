package com.cx.smartcity.moudle_1.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.EventBean;
import com.cx.smartcity.bean.EventCommentBean;
import com.cx.smartcity.bean.EventDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class EventDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private Button signBtn;
    private TextView content;
    private RecyclerView eventRecyc;
    private TextView commentCnt;
    private RecyclerView commentRecyc;
    private EditText commentEt;
    private Button commentBtn;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        initView();
        id = getIntent().getIntExtra("id", 11);
        initMsg();
        initSign();
        initEvent();
        initComment();

        toComment();
    }

    private void toComment() {
        commentRecyc.setLayoutManager(new LinearLayoutManager(this));
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = commentEt.getText().toString();
                commentEt.setText("");
                HashMap<Object, Object> map = new HashMap<>();
                map.put("activityId", id);
                map.put("content", s);
                RetrofitUtil.post("/prod-api/api/activity/comment", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(EventDetailActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
                                initComment();
                            }else {
                                Toast.makeText(EventDetailActivity.this, "评论失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void initComment() {
        RetrofitUtil.get("/prod-api/api/activity/comment/list?activityId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<EventCommentBean.RowsDTO> list = new Gson().fromJson(json, EventCommentBean.class).getRows();
                commentCnt.setText("评论列表（共"+list.size()+"条评论）");
                commentRecyc.setAdapter(new EventCommentAdapter(EventDetailActivity.this, list));
            }
        });
    }

    private void initEvent() {
        eventRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/activity/activity/list?categoryId=1", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<EventBean.RowsDTO> list = new Gson().fromJson(json, EventBean.class).getRows();
                eventRecyc.setAdapter(new EventAdapter(EventDetailActivity.this, list.subList(0, 3)));
            }
        });
    }

    private void initSign() {
        checkSign();
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("activityId", id);
                RetrofitUtil.post("/prod-api/api/activity/signup", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(EventDetailActivity.this, "报名成功", Toast.LENGTH_SHORT).show();
                                checkSign();
                            }else {
                                Toast.makeText(EventDetailActivity.this, "报名失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void checkSign() {
        RetrofitUtil.get("/prod-api/api/activity/signup/check?activityId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getBoolean("isSignup")) {
                        signBtn.setClickable(false);
                        signBtn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
                        signBtn.setText("已报名");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initMsg() {
        RetrofitUtil.get("/prod-api/api/activity/activity/"+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                EventDetailBean.DataDTO data = new Gson().fromJson(json, EventDetailBean.class).getData();
                Glide.with(EventDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
                name.setText(data.getName());
                content.setText(Html.fromHtml(data.getContent()));
            }
        });
    }

    private void initView() {


        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        signBtn = (Button) findViewById(R.id.sign_btn);
        content = (TextView) findViewById(R.id.content);
        eventRecyc = (RecyclerView) findViewById(R.id.event_recyc);
        commentCnt = (TextView) findViewById(R.id.comment_cnt);
        commentRecyc = (RecyclerView) findViewById(R.id.comment_recyc);
        commentEt = (EditText) findViewById(R.id.comment_et);
        commentBtn = (Button) findViewById(R.id.comment_btn);

    }

    public void back(View view) {
        finish();
    }
}