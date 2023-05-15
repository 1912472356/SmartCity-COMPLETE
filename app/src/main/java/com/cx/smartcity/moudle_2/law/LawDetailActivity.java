package com.cx.smartcity.moudle_2.law;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.LawBean;
import com.cx.smartcity.bean.LawCommentBean;
import com.cx.smartcity.bean.LawDetailBean;
import com.cx.smartcity.moudle_2.consult.ConsultActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.List;

public class LawDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private TextView lawType;
    private TabLayout tabLayout;
    private LinearLayout userPage;
    private TextView baseMsg;
    private TextView intro;
    private ImageView zhengImg;
    private RecyclerView commentRecyc;

    private LawBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_detail);
        initView();
        data = (LawBean.RowsDTO) getIntent().getSerializableExtra("data");
        initLaw();
        initTab();
        initComment();
    }

    private void initComment() {
        commentRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/list-evaluate?lawyerId=11", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LawCommentBean.RowsDTO> list = new Gson().fromJson(json, LawCommentBean.class).getRows();
                commentRecyc.setAdapter(new LawCommentAdapter(LawDetailActivity.this, list));
            }
        });
    }

    private void initTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    userPage.setVisibility(View.VISIBLE);
                    commentRecyc.setVisibility(View.GONE);
                }else {
                    userPage.setVisibility(View.GONE);
                    commentRecyc.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initLaw() {
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getAvatarUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        name.setText(data.getName());
        final int year = Math.min("2022".compareTo(data.getWorkStartAt()),1);
        content.setText("从业"+year+"年，"+data.getServiceTimes()+"人咨询过");
        lawType.setText(data.getLegalExpertiseName());

        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/"+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LawDetailBean.DataDTO lawData = new Gson().fromJson(json, LawDetailBean.class).getData();

                baseMsg.setText("教育背景："+data.getEduInfo()
                        +"\n从业年限："+year+"年"
                        +"\n执业证号："+data.getLicenseNo());

                intro.setText(data.getBaseInfo());
                Glide.with(LawDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + lawData.getCertificateImgUrl())
                                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(5)).into(zhengImg);
            }
        });
    }

    private void initView() {

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        lawType = (TextView) findViewById(R.id.law_type);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        userPage = (LinearLayout) findViewById(R.id.user_page);
        baseMsg = (TextView) findViewById(R.id.base_msg);
        intro = (TextView) findViewById(R.id.intro);
        zhengImg = (ImageView) findViewById(R.id.zheng_img);
        commentRecyc = (RecyclerView) findViewById(R.id.comment_recyc);

    }

    public void back(View view) {
        finish();
    }

    public void consult(View view) {
        Intent intent = new Intent(this, ConsultActivity.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}