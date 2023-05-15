package com.cx.smartcity.smart.produce;

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
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ZhizaoActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout facList;
    private LinearLayout productList;
    private LinearLayout eventList;
    private LinearLayout facEmploy;
    private LinearLayout facRuzhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhizao);

        banner = (Banner) findViewById(R.id.banner);
        facList = (LinearLayout) findViewById(R.id.fac_list);
        productList = (LinearLayout) findViewById(R.id.product_list);
        eventList = (LinearLayout) findViewById(R.id.event_list);
        facEmploy = (LinearLayout) findViewById(R.id.fac_employ);
        facRuzhu = (LinearLayout) findViewById(R.id.fac_ruzhu);

        initBanner();

        facList.setOnClickListener(this);
        productList.setOnClickListener(this);
        eventList.setOnClickListener(this);
        facEmploy.setOnClickListener(this);
        facRuzhu.setOnClickListener(this);
    }

    private void initBanner() {
        List<Integer> arr = new ArrayList<>();
        arr.add(R.mipmap.zhizao_banner1);
        arr.add(R.mipmap.zhizao_banner2);
        arr.add(R.mipmap.zhizao_banner3);
        arr.add(R.mipmap.zhizao_banner4);
        arr.add(R.mipmap.zhizao_banner5);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        banner.setImages(arr);
        banner.start();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fac_list:
                startActivity(new Intent(this, FacListActivity.class));
                break;
            case R.id.product_list:
                startActivity(new Intent(this, ProduceListActivity.class));
                break;
            case R.id.event_list:
                startActivity(new Intent(this, ZhanhuiActivity.class));
                break;
            case R.id.fac_employ:
                startActivity(new Intent(this, FacEmployActivity.class));
                break;
            case R.id.fac_ruzhu:
                startActivity(new Intent(this, FacRuzhuActivity.class));
                break;
        }
    }
}