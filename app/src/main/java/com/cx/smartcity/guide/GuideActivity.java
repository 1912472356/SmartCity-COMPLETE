package com.cx.smartcity.guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.util.SPUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private Banner banner;
    private Button netBtn;
    private Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if (SPUtil.get(SPUtil.FIRST) != null) {
            startActivity(new Intent(GuideActivity.this, LoginActivity.class));
            finish();
        }
        banner = (Banner) findViewById(R.id.banner);
        netBtn = (Button) findViewById(R.id.net_btn);
        homeBtn = (Button) findViewById(R.id.home_btn);

        initBanner();

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SPUtil.get(SPUtil.HTTP) == null) {
                    Toast.makeText(GuideActivity.this, "请设置网络", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                SPUtil.put(SPUtil.FIRST, "true");
                finish();
            }
        });

        netBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NetsetDialog(GuideActivity.this).show();
            }
        });
    }

    private void initBanner() {
        List<Integer> arr = new ArrayList<>();
        arr.add(R.mipmap.guide1);
        arr.add(R.mipmap.guide2);
        arr.add(R.mipmap.guide3);
        arr.add(R.mipmap.guide4);
        arr.add(R.mipmap.guide5);

        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        banner.setImages(arr);
        banner.start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 4) {
                    homeBtn.setVisibility(View.VISIBLE);
                    netBtn.setVisibility(View.VISIBLE);
                }else{
                    homeBtn.setVisibility(View.INVISIBLE);
                    netBtn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}