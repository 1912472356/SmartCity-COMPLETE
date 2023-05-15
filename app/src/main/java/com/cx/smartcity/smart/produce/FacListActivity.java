package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.google.android.material.tabs.TabLayout;

public class FacListActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private CardView card1;
    private CardView card2;
    private CardView card3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac_list);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    card1.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.VISIBLE);
                    card3.setVisibility(View.VISIBLE);
                }else {
                    card1.setVisibility(View.GONE);
                    card2.setVisibility(View.GONE);
                    card3.setVisibility(View.GONE);

                    switch (tab.getPosition()) {
                        case 1:
                            card1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            card2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            card3.setVisibility(View.VISIBLE);
                            break;
                    }
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

    public void detail(View view) {
        Intent intent = new Intent(this, FacDetailActivity.class);

        switch (view.getId()) {
            case R.id.card1:
                intent.putExtra("id", 1);
                break;
            case R.id.card2:
                intent.putExtra("id", 2);
                break;
            case R.id.card3:
                intent.putExtra("id", 3);
                break;
        }
        startActivity(intent);
    }
}