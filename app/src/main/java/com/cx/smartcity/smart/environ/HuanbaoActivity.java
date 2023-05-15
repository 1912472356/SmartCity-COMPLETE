package com.cx.smartcity.smart.environ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.smart.community.NoticeActivity;
import com.cx.smartcity.smart.community.ShequActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HuanbaoActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout yuyue;
    private LinearLayout yuyueLish;
    private LinearLayout preMsg;
    private LinearLayout near;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanbao);
        banner = (Banner) findViewById(R.id.banner);
        yuyue = (LinearLayout) findViewById(R.id.yuyue);
        yuyueLish = (LinearLayout) findViewById(R.id.yuyue_lish);
        preMsg = (LinearLayout) findViewById(R.id.pre_msg);
        near = (LinearLayout) findViewById(R.id.near);

        initBanner();

        yuyue.setOnClickListener(this);
        yuyueLish.setOnClickListener(this);
        preMsg.setOnClickListener(this);
        near.setOnClickListener(this);
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        List<Integer> arr = new ArrayList<>();
        arr.add(R.mipmap.huanbao_banner1);
        arr.add(R.mipmap.huanbao_banner2);
        arr.add(R.mipmap.huanbao_banner3);
        arr.add(R.mipmap.huanbao_banner4);
        arr.add(R.mipmap.huanbao_banner5);
        banner.setImages(arr);
        banner.start();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yuyue:
                startActivity(new Intent(this, YuyueActivity.class));
                break;
            case R.id.yuyue_lish:
                startActivity(new Intent(this, YuyueLishActivity.class));
                break;
            case R.id.pre_msg:
                startActivity(new Intent(this, PreMsgActivity.class));
                break;
            case R.id.near:
                startActivity(new Intent(this, NearHuishoujiActivity.class));
                break;
        }
    }
}