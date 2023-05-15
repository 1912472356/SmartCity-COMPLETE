package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.cx.smartcity.R;
import com.google.android.material.tabs.TabLayout;

import java.sql.SQLIntegrityConstraintViolationException;

public class YanglaoJIluActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ScrollView xunjianPage;
    private ScrollView yongcanPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanglao_j_ilu);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        xunjianPage = (ScrollView) findViewById(R.id.xunjian_page);
        yongcanPage = (ScrollView) findViewById(R.id.yongcan_page);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    xunjianPage.setVisibility(View.VISIBLE);
                    yongcanPage.setVisibility(View.GONE);
                }else {
                    xunjianPage.setVisibility(View.GONE);
                    yongcanPage.setVisibility(View.VISIBLE);
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

    public void back(View view) {
        finish();
    }
}