package com.cx.smartcity.moudle_2.subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.SubwayLineBean;
import com.cx.smartcity.bean.SubwaySizeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

public class SubwayDetaActivity extends AppCompatActivity {
    private TextView name;
    private TextView start;
    private TextView end;
    private TextView content;
    private RecyclerView siteRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_deta);
        name = (TextView) findViewById(R.id.name);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        content = (TextView) findViewById(R.id.content);
        siteRecyc = (RecyclerView) findViewById(R.id.site_recyc);

        final SubwaySizeBean.DataDTO data = (SubwaySizeBean.DataDTO) getIntent().getSerializableExtra("data");

        name.setText(data.getLineName());
        RetrofitUtil.get("/prod-api/api/metro/line/"+data.getLineId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                SubwayLineBean.DataDTO lineData = new Gson().fromJson(json, SubwayLineBean.class).getData();
                start.setText(lineData.getFirst());
                end.setText(lineData.getEnd());
                content.setText("剩余时间："+lineData.getRemainingTime()+"分钟\n间隔"+lineData.getMetroStepList().size()+"站\n剩余距离："+lineData.getKm()+"Km");

                siteRecyc.setLayoutManager(new LinearLayoutManager(SubwayDetaActivity.this, RecyclerView.HORIZONTAL, false));
                String currentName = data.getCurrentName();
                siteRecyc.setAdapter(new SubwayLineAdapter(SubwayDetaActivity.this, lineData.getMetroStepList(), currentName));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}