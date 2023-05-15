package com.cx.smartcity.moudle_2.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ConsultBean;
import com.cx.smartcity.bean.LawDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class ConsultDetaActivity extends AppCompatActivity {
    private ImageView img;
    private TextView haoping;
    private TextView name;
    private TextView content;
    private TextView lawType;
    private TextView question;
    private ImageView queImg;
    private EditText phone;
    private Button toCommentBtn;
    private ConsultBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_deta);
        initView();
        data = (ConsultBean.RowsDTO) getIntent().getSerializableExtra("data");
        initLaw();
        initQuestion();
    }

    private void initQuestion() {
        question.setText("受理状态：" + (data.getState().equals("0") ? "未受理" : (data.getState().equals("1") ? "受理中" : "已完成"))
                + "\n问题类型：" + data.getLegalExpertiseName()
                + "\n问题描述：" + data.getContent());
        if(data.getImageUrls() != null) {
            String path = data.getImageUrls().split(",")[0];
            Glide.with(this).load(BitmapFactory.decodeFile(path))
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(queImg);
            if(path.contains("/prod-api") || path.contains("/profile")){
                Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + path)
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(queImg);
            }
        }
        phone.setText(data.getPhone());

        if (data.getState().equals("2")) {
            toCommentBtn.setVisibility(View.VISIBLE);
        } else {
            toCommentBtn.setVisibility(View.GONE);
        }

        toCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConsultDetaActivity.this, ConsultCommentActivity.class));
            }
        });
    }

    private void initLaw() {

        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/" + data.getLawyerId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LawDetailBean.DataDTO lawData = new Gson().fromJson(json, LawDetailBean.class).getData();

                haoping.setText(lawData.getFavorableRate() + "%好评");
                name.setText(lawData.getName());
                int year = Math.min("2022".compareTo(lawData.getWorkStartAt()), 1);
                content.setText("从业" + year + "年，" + lawData.getServiceTimes() + "人咨询过");
                lawType.setText(lawData.getLegalExpertiseName());
                Glide.with(ConsultDetaActivity.this).load(SPUtil.get(SPUtil.HTTP) + lawData.getAvatarUrl())
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
            }
        });
    }

    private void initView() {


        img = (ImageView) findViewById(R.id.img);
        haoping = (TextView) findViewById(R.id.haoping);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        lawType = (TextView) findViewById(R.id.law_type);
        question = (TextView) findViewById(R.id.question);
        queImg = (ImageView) findViewById(R.id.que_img);
        phone = (EditText) findViewById(R.id.phone);
        toCommentBtn = (Button) findViewById(R.id.to_comment_btn);

    }

    public void back(View view) {
        finish();
    }
}