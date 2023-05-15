package com.cx.smartcity.moudle_1.love;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.DonateBean;
import com.cx.smartcity.bean.LoveBean;
import com.cx.smartcity.bean.LoveDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class LoveDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private ProgressBar progress;
    private TextView donate;
    private TextView content;
    private TextView desc;
    private TextView form;
    private TextView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_detail);
        initView();
        LoveBean.RowsDTO d = (LoveBean.RowsDTO) getIntent().getSerializableExtra("data");
        RetrofitUtil.get("/prod-api/api/public-welfare/public-welfare-activity/"+d.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LoveDetailBean.DataDTO data = new Gson().fromJson(json, LoveDetailBean.class).getData();
                Glide.with(LoveDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                        .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
                name.setText(data.getName());
                progress.setProgress(data.getMoneyNow()/data.getMoneyTotal()*100);
                donate.setText("已筹善款"+data.getMoneyNow()+"元，筹款目标"+data.getMoneyTotal()+"元");
                desc.setText(Html.fromHtml(data.getDescription()));
                for (LoveDetailBean.DataDTO.DetailsListDTO row : data.getDetailsList()) {
                    form.setText(row.getItemName()+"  ——————  "+row.getItemMoney()+"元\n"+form.getText().toString());
                }

                content.setText("参与人数："+data.getDonateCount()+"人"
                        +"\n项目时间："+data.getActivityAt());


            }
        });

        RetrofitUtil.get("/prod-api/api/public-welfare/donate-record/list?activityId="+d.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                scroll.requestFocus();
                scroll.requestFocusFromTouch();
                List<DonateBean.RowsDTO> list = new Gson().fromJson(json, DonateBean.class).getRows().subList(0, 30);
                for (DonateBean.RowsDTO row : list) {
                    scroll.setText(scroll.getText()+"          "+row.getUserName()+"捐助了"+row.getDonateMoney()+"元");
                }
            }
        });
    }

    private void initView() {


        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        progress = (ProgressBar) findViewById(R.id.progress);
        donate = (TextView) findViewById(R.id.donate);
        content = (TextView) findViewById(R.id.content);
        desc = (TextView) findViewById(R.id.desc);
        form = (TextView) findViewById(R.id.form);
        scroll = (TextView) findViewById(R.id.scroll);

    }

    public void back(View view) {
        finish();
    }
}