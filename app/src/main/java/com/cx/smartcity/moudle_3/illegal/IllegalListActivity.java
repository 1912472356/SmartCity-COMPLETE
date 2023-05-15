package com.cx.smartcity.moudle_3.illegal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.IllegalBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class IllegalListActivity extends AppCompatActivity {
    private RecyclerView recordRecyc;
    private Button moreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegal_list);
        recordRecyc = (RecyclerView) findViewById(R.id.record_recyc);
        moreBtn = (Button) findViewById(R.id.more_btn);

        recordRecyc.setLayoutManager(new LinearLayoutManager(this));
        String name = getIntent().getStringExtra("name");
        RetrofitUtil.get(name, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<IllegalBean.RowsDTO> list = new Gson().fromJson(json, IllegalBean.class).getRows();
                final List<String> arr = new ArrayList<>();
                for (IllegalBean.RowsDTO row : list) {
                    arr.add("违法时间："+row.getBadTime()
                            +"\n违章地点："+row.getIllegalSites()
                            +"\n违章记分："+row.getDeductMarks()
                            +"分\n罚款金额："+row.getMoney()+"元"
                            +"\n处理状态："+row.getDisposeState()
                            +"");
                }
                recordRecyc.setAdapter(new CommonAdapter(IllegalListActivity.this, arr.subList(0, Math.min(5, arr.size())), new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(IllegalListActivity.this, IllegalDetaActivity.class);
                        intent.putExtra("data", list.get(Integer.parseInt(json)));
                        startActivity(intent);
                    }
                }));
                if (arr.size() <= 5) {
                    moreBtn.setVisibility(View.GONE);
                }else {
                    moreBtn.setVisibility(View.VISIBLE);
                    moreBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recordRecyc.setAdapter(new CommonAdapter(IllegalListActivity.this, arr, new RetrofitUtil.OnRequest() {
                                @Override
                                public void onRequest(String json) {
                                    Intent intent = new Intent(IllegalListActivity.this, IllegalDetaActivity.class);
                                    intent.putExtra("data", list.get(Integer.parseInt(json)));
                                    startActivity(intent);
                                }
                            }));
                        }
                    });
                }
            }
        });
    }

    public void back(View view) {
        finish();
    }
}