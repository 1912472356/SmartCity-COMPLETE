package com.cx.smartcity.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.FeedRecordBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FeedRecordActivity extends AppCompatActivity {
    private RecyclerView recordRecyc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_record);
        recordRecyc = (RecyclerView) findViewById(R.id.record_recyc);

        recordRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/common/feedback/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<FeedRecordBean.RowsDTO> list = new Gson().fromJson(json, FeedRecordBean.class).getRows();
                List<String> titles = new ArrayList<>();
                List<String> arr = new ArrayList<>();
                for (FeedRecordBean.RowsDTO row : list) {
                    titles.add(row.getTitle());
                    arr.add("反馈内容："+row.getContent()
                            +"\n反馈时间："+row.getCreateTime());
                }
                recordRecyc.setAdapter(new CommonAdapter(FeedRecordActivity.this, arr, titles));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}