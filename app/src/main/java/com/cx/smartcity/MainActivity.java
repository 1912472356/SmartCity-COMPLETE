package com.cx.smartcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cx.smartcity.data.DataFragment;
import com.cx.smartcity.home.HomeFragment;
import com.cx.smartcity.home.ServiceFragment;
import com.cx.smartcity.person.PersonFragment;
import com.cx.smartcity.smart.SmartFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabLayout;
    String ns[] = {
            "首页", "全部服务", "智慧城市","数据分析", "个人中心"
    };
    int imgs[] = {
            R.mipmap.home, R.mipmap.service,
            R.mipmap.build,R.mipmap.news,R.mipmap.prson
    };
    private Class<?>[] frags = {
            HomeFragment.class, ServiceFragment.class,
            SmartFragment.class, DataFragment.class, PersonFragment.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (FragmentTabHost) findViewById(R.id.tab_layout);
        tabLayout.setup(getApplicationContext(), getSupportFragmentManager(), R.id.main_frame);

        for (int i = 0; i < 5; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
            ImageView img = (ImageView) view.findViewById(R.id.img);
            TextView  name = (TextView) view.findViewById(R.id.name);

            img.setImageResource(imgs[i]);
            name.setText(ns[i]);
            tabLayout.addTab(tabLayout.newTabSpec(i+"").setIndicator(view), frags[i], null);
        }

    }

    public void ser(){
        tabLayout.setCurrentTab(1);
    }
}