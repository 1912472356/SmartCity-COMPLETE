package com.cx.smartcity.smart.partisan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.smart.community.SimpleCommentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DynamicActivity extends AppCompatActivity  {
    private TabLayout tabLayout;
    private CardView card1;
    private RecyclerView commentRecyc1;
    private SearchView commentEt1;
    private CardView card2;
    private RecyclerView commentRecyc2;
    private SearchView commentEt2;
    private CardView card3;
    private RecyclerView commentRecyc3;
    private SearchView commentEt3;

    List<ShequYoulingBean.SimpleCommentBean> commentList[] = new ArrayList[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        card1 = (CardView) findViewById(R.id.card1);
        commentRecyc1 = (RecyclerView) findViewById(R.id.comment_recyc_1);
        commentEt1 = (SearchView) findViewById(R.id.comment_et_1);
        card2 = (CardView) findViewById(R.id.card2);
        commentRecyc2 = (RecyclerView) findViewById(R.id.comment_recyc_2);
        commentEt2 = (SearchView) findViewById(R.id.comment_et_2);
        card3 = (CardView) findViewById(R.id.card3);
        commentRecyc3 = (RecyclerView) findViewById(R.id.comment_recyc_3);
        commentEt3 = (SearchView) findViewById(R.id.comment_et_3);

        initComment();
        initTab();
    }

    private void initTab() {
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

                    switch (tab.getPosition()){
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

    private void initComment() {
        commentList[0] = new ArrayList<>();
        commentList[1] = new ArrayList<>();
        commentList[2] = new ArrayList<>();

        commentRecyc1.setLayoutManager(new LinearLayoutManager(this));
        commentRecyc2.setLayoutManager(new LinearLayoutManager(this));
        commentRecyc3.setLayoutManager(new LinearLayoutManager(this));

        commentEt1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        commentEt2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        commentEt3.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                comment(query, 2);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void comment(String query, int i) {
        commentList[i].add(new ShequYoulingBean.SimpleCommentBean("评论用户", query));
        loadCommnetAda();
    }

    private void loadCommnetAda() {
        commentRecyc1.setAdapter(new SimpleCommentAdapter(this, commentList[0]));
        commentRecyc2.setAdapter(new SimpleCommentAdapter(this, commentList[1]));
        commentRecyc3.setAdapter(new SimpleCommentAdapter(this, commentList[2]));
    }

    public void back(View view) {
        finish();
    }

}