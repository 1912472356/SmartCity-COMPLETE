package com.cx.smartcity.moudle_3.pay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.RecentCallBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.ListAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CallQueryActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private EditText call;
    private RecyclerView recentCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_query);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        call = (EditText) findViewById(R.id.call);
        recentCall = (RecyclerView) findViewById(R.id.recent_call);
        recentCall.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Type type = new TypeToken<List<RecentCallBean>>() {
        }.getType();
        final List<RecentCallBean> list = new Gson().fromJson(SPUtil.get(SPUtil.RECENT_CALL), type);
        List<String> arr = new ArrayList<>();
        for (RecentCallBean row : list) {
            arr.add(row.getTell()+"（"+row.getType()+"）\n添加时间："+row.getDate());
        }
        recentCall.setAdapter(new ListAdapter(this, arr, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                call.setText(list.get(Integer.parseInt(json)).getTell());
                String phType = list.get(Integer.parseInt(json)).getType();
                if (phType.equals("中国移动")) {
                    tabLayout.getTabAt(0).select();
                }else if (phType.equals("中国电信")) {
                    tabLayout.getTabAt(1).select();
                }else if (phType.equals("中国联通")) {
                    tabLayout.getTabAt(2).select();
                }
                query(recentCall);
            }
        }));
    }

    public void back(View view) {
        finish();
    }

    public void query(View view) {
        int selectedTabPosition = tabLayout.getSelectedTabPosition();
        String type = "中国移动";
        switch (selectedTabPosition) {
            case 1:
                type = "中国电信";
                break;
            case 2:
                type = "中国联通";
                break;
        }
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra("call", call.getText().toString());
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void record(View view) {
        startActivity(new Intent(this, PayRecordActivity.class));
    }
}