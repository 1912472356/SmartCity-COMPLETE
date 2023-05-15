package com.cx.smartcity.moudle_1.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.AreaBean;
import com.cx.smartcity.bean.AreaDetailBean;
import com.cx.smartcity.bean.AreaFileBean;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class AreaDetailActivity extends AppCompatActivity {
    private TextView title;
    private ImageView img;
    private TextView intro;
    private RecyclerView fileRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_detail);
        title = (TextView) findViewById(R.id.title);
        img = (ImageView) findViewById(R.id.img);
        intro = (TextView) findViewById(R.id.intro);
        fileRecyc = (RecyclerView) findViewById(R.id.file_recyc);

        AreaBean.DataDTO data = (AreaBean.DataDTO) getIntent().getSerializableExtra("data");
        title.setText(data.getName()+"详情");
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);

        fileRecyc.setLayoutManager(new LinearLayoutManager(this));

        RetrofitUtil.get("/prod-api/api/youth-inn/talent-policy-area/"+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                AreaDetailBean.DataDTO detail = new Gson().fromJson(json, AreaDetailBean.class).getData();
                intro.setText(detail.getIntroduce());
            }
        });
        RetrofitUtil.get("/prod-api/api/youth-inn/talent-policy/list?areaId="+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<AreaFileBean.DataDTO> list = new Gson().fromJson(json, AreaFileBean.class).getData();
                fileRecyc.setAdapter(new AreaFileAdapter(AreaDetailActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}