package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ShequActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout wuye;
    private LinearLayout kuaijian;
    private LinearLayout youling;
    private LinearLayout cheliang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shequ);

        initView();
        initBanner();
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        List<Integer> arr = new ArrayList<>();
        arr.add(R.mipmap.shequ_banner1);
        arr.add(R.mipmap.shequ_banner2);
        arr.add(R.mipmap.shequ_banner3);
        arr.add(R.mipmap.shequ_banner4);
        arr.add(R.mipmap.shequ_banner5);
        arr.add(R.mipmap.shequ_banner6);

        List<String> titles = new ArrayList<>();
        titles.add("物业通知-1");
        titles.add("社区居委会通知-1");
        titles.add("物业通知-2");
        titles.add("社区居委会通知-2");
        titles.add("物业通知-3");
        titles.add("社区居委会通知-3");
        banner.setImages(arr);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                Intent intent = new Intent(ShequActivity.this, NoticeActivity.class);
                intent.putExtra("id", i);
                startActivity(intent);
            }
        });
    }

    private void initView() {

        banner = (Banner) findViewById(R.id.banner);
        wuye = (LinearLayout) findViewById(R.id.wuye);
        kuaijian = (LinearLayout) findViewById(R.id.kuaijian);
        youling = (LinearLayout) findViewById(R.id.youling);
        cheliang = (LinearLayout) findViewById(R.id.cheliang);

        wuye.setOnClickListener(this);
        kuaijian.setOnClickListener(this);
        youling.setOnClickListener(this);
        cheliang.setOnClickListener(this);
    }

    public void back(View view) {
        finish();
    }

    public void tuiguang(View view) {
        startActivity(new Intent(this, TuiguangActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wuye:
                startActivity(new Intent(this, WuyeActivity.class));
                break;
            case R.id.kuaijian:
                startActivity(new Intent(this, KuaijianActivity.class));
                break;
            case R.id.youling:
                startActivity(new Intent(this, YoulingActivity.class));
                break;
            case R.id.cheliang:
                startActivity(new Intent(this, CheliangActivity.class));
                break;
        }
    }
}