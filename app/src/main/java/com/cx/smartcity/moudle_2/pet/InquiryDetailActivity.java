package com.cx.smartcity.moudle_2.pet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.PetCommentBean;
import com.cx.smartcity.bean.PetInquiryBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class InquiryDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private TextView question;
    private ImageView queImg;
    private RecyclerView commentRecyc;
    private Button inquiryBtn;
    private LinearLayout bottom;
    private EditText commentEt;
    private Button commentBtn;
    PetInquiryBean.RowsDTO data;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_detail);
        initView();
        id = getIntent().getIntExtra("id", 0);
        data = (PetInquiryBean.RowsDTO) getIntent().getSerializableExtra("data");
        initMsg();
        initComment();
        loadComment();
        initInquiry();
    }

    private void initInquiry() {
        inquiryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InquiryDetailActivity.this, PetInquiryActivity.class);
                intent.putExtra("data", new Gson().toJson(data.getDoctor()));
                startActivity(intent);
            }
        });
    }

    private void initComment() {
        commentRecyc.setLayoutManager(new LinearLayoutManager(this));
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = commentEt.getText().toString();
                commentEt.setText("");
                HashMap<Object, Object> map = new HashMap<>();
                map.put("inquiryId", data.getId());
                map.put("content", s);
                RetrofitUtil.post("/prod-api/api/pet-hospital/inquiry-message", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(InquiryDetailActivity.this, "追问成功", Toast.LENGTH_SHORT).show();
                                loadComment();
                            } else {
                                Toast.makeText(InquiryDetailActivity.this, "追问失败：" + obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void loadComment() {
        RetrofitUtil.get("/prod-api/api/pet-hospital/inquiry-message/list?inquiryId=" + data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<PetCommentBean.RowsDTO> list = new Gson().fromJson(json, PetCommentBean.class).getRows();
                commentRecyc.setAdapter(new PetCommentAdapter(InquiryDetailActivity.this, list));
            }
        });
    }

    private void initMsg() {
        if (data.getDoctor() != null) {
            name.setText(data.getDoctor().getName() + "（" + data.getDoctor().getJobName() + "）");
            Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getDoctor().getAvatar())
                    .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(img);
            content.setText("执业编号：" + data.getDoctor().getPracticeNo() + "\n从业" + data.getDoctor().getWorkingYears() + "年，" + data.getDoctor().getGoodAt());
        }

        question.setText(data.getQuestion());
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getImageUrls())
                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(queImg);
        if (data.getImageUrls().contains("/storage")) {
            Glide.with(this).load(BitmapFactory.decodeFile(data.getImageUrls()))
                    .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(queImg);
        }


        if (id == 0) {
            inquiryBtn.setVisibility(View.GONE);
            bottom.setVisibility(View.VISIBLE);
        } else {
            inquiryBtn.setVisibility(View.VISIBLE);
            bottom.setVisibility(View.GONE);
        }
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        queImg = (ImageView) findViewById(R.id.que_img);
        commentRecyc = (RecyclerView) findViewById(R.id.comment_recyc);
        inquiryBtn = (Button) findViewById(R.id.inquiry_btn);
        bottom = (LinearLayout) findViewById(R.id.bottom);
        commentEt = (EditText) findViewById(R.id.comment_et);
        commentBtn = (Button) findViewById(R.id.comment_btn);
        question = (TextView) findViewById(R.id.question);
    }

    public void back(View view) {
        finish();
    }
}