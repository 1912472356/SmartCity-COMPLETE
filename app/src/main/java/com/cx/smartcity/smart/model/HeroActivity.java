package com.cx.smartcity.smart.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.smart.community.SimpleCommentAdapter;

import java.util.ArrayList;
import java.util.List;

public class HeroActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView simpleCommentRecyc;
    private EditText commentEt;
    private Button commentBtn;
    private RecyclerView simpleCommentRecyc2;
    private EditText commentEt2;
    private Button commentBtn2;
    private RecyclerView simpleCommentRecyc3;
    private EditText commentEt3;
    private Button commentBtn3;
    private List<ShequYoulingBean.SimpleCommentBean> commentList = new ArrayList<>();
    private List<ShequYoulingBean.SimpleCommentBean> commentList2 = new ArrayList<>();
    private List<ShequYoulingBean.SimpleCommentBean> commentList3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        simpleCommentRecyc = (RecyclerView) findViewById(R.id.simple_comment_recyc);
        commentEt = (EditText) findViewById(R.id.comment_et);
        commentBtn = (Button) findViewById(R.id.comment_btn);
        simpleCommentRecyc2 = (RecyclerView) findViewById(R.id.simple_comment_recyc2);
        commentEt2 = (EditText) findViewById(R.id.comment_et2);
        commentBtn2 = (Button) findViewById(R.id.comment_btn2);
        simpleCommentRecyc3 = (RecyclerView) findViewById(R.id.simple_comment_recyc3);
        commentEt3 = (EditText) findViewById(R.id.comment_et3);
        commentBtn3 = (Button) findViewById(R.id.comment_btn3);

        simpleCommentRecyc.setLayoutManager(new LinearLayoutManager(this));
        simpleCommentRecyc2.setLayoutManager(new LinearLayoutManager(this));
        simpleCommentRecyc3.setLayoutManager(new LinearLayoutManager(this));


        commentBtn.setOnClickListener(this);
        commentBtn2.setOnClickListener(this);
        commentBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.comment_btn:
                comment(commentEt, simpleCommentRecyc, commentList);
                break;
            case R.id.comment_btn2:
                comment(commentEt2, simpleCommentRecyc2, commentList2);
                break;
            case R.id.comment_btn3:
                comment(commentEt3, simpleCommentRecyc3, commentList3);
                break;
        }
    }

    private void comment(EditText commentEt3, RecyclerView simpleCommentRecyc3, List<ShequYoulingBean.SimpleCommentBean> commentList3) {
        String s = commentEt3.getText().toString();
        commentList3.add(new ShequYoulingBean.SimpleCommentBean("评论用户", s));
        simpleCommentRecyc3.setAdapter(new SimpleCommentAdapter(this, commentList3));
    }
    public void back(View view) {
        finish();
    }

    public void btn(View view) {
        Toast.makeText(this, "致敬成功", Toast.LENGTH_SHORT).show();
        Button btn = (Button) view;
        btn.setClickable(false);
        btn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
    }
}