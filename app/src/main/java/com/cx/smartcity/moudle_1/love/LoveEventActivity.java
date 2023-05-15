package com.cx.smartcity.moudle_1.love;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LoveBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.List;

public class LoveEventActivity extends AppCompatActivity {
    private SearchView searchEt;
    private RecyclerView loveRecyc;
    private TabLayout tabLayout;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_event);
        searchEt = (SearchView) findViewById(R.id.search_et);
        loveRecyc = (RecyclerView) findViewById(R.id.love_recyc);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        int i = getIntent().getIntExtra("id", -1);
        id =  (i== -1?"":i+"");
        String name = getIntent().getStringExtra("name");
        if (name == null) {
            name = "";
        }
        initSearch();
        initTab();
        loadData(0, name);
    }

    private void initTab() {
        loveRecyc.setLayoutManager(new LinearLayoutManager(this));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadData(tab.getPosition(), searchEt.getQuery().toString());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private void initSearch() {

        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadData(0, query);
                tabLayout.getTabAt(0).select();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void loadData(final int i, String name) {
        RetrofitUtil.get("/prod-api/api/public-welfare/public-welfare-activity/list?typeId="+id+"&name="+name, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<LoveBean.RowsDTO> list = new Gson().fromJson(json, LoveBean.class).getRows();
                int min = Math.min(list.size(), i * 10);
                int max = Math.min(list.size(),min + 10);
                if(min == list.size()){
                    loveRecyc.setAdapter(new LoveAdapter(LoveEventActivity.this, list.subList(0, 0)));
                }else {
                    loveRecyc.setAdapter(new LoveAdapter(LoveEventActivity.this, list.subList(min, max)));
                }
            }
        });
    }

    public void back(View view) {
        finish();
    }
}