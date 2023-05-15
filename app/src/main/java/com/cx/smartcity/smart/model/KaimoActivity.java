package com.cx.smartcity.smart.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.smart.community.NoticeActivity;
import com.cx.smartcity.smart.community.ShequActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class KaimoActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout kaimo;
    private LinearLayout hero;
    private LinearLayout learn;
    private LinearLayout gongyi;
    private LinearLayout nearHero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaimo);

        banner = (Banner) findViewById(R.id.banner);
        kaimo = (LinearLayout) findViewById(R.id.kaimo);
        hero = (LinearLayout) findViewById(R.id.hero);
        learn = (LinearLayout) findViewById(R.id.learn);
        gongyi = (LinearLayout) findViewById(R.id.gongyi);
        nearHero = (LinearLayout) findViewById(R.id.near_hero);

        kaimo.setOnClickListener(this);
        hero.setOnClickListener(this);
        learn.setOnClickListener(this);
        gongyi.setOnClickListener(this);
        nearHero.setOnClickListener(this);

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
        arr.add(R.mipmap.kaimo_banner1);
        arr.add(R.mipmap.kaimo_banner2);
        arr.add(R.mipmap.kaimo_banner3);
        arr.add(R.mipmap.kaimo_banner4);
        arr.add(R.mipmap.kaimo_banner5);
        banner.setImages(arr);
        banner.start();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kaimo:
                startActivity(new Intent(this, KaimoLiebiaoActivity.class));
                break;
            case R.id.hero:
                startActivity(new Intent(this, HeroActivity.class));
                break;
            case R.id.learn:
                startActivity(new Intent(this, LearnXindeActivity.class));
                break;
            case R.id.gongyi:
                startActivity(new Intent(this, KaimoGongyiActivity.class));
                break;
            case R.id.near_hero:
                startActivity(new Intent(this, NearHeroActivity.class));
                break;
        }
    }
}