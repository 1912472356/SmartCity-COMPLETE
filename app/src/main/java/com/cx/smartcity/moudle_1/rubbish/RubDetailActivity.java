package com.cx.smartcity.moudle_1.rubbish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.RubTypeBean;
import com.cx.smartcity.bean.RubbishBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class RubDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private RecyclerView goodsRecyc;
    private TextView guideTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub_detail);

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        goodsRecyc = (RecyclerView) findViewById(R.id.goods_recyc);
        guideTv = (TextView) findViewById(R.id.guide_tv);

        final String tyname = getIntent().getStringExtra("name");
        RetrofitUtil.get("/prod-api/api/garbage-classification/garbage-classification/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<RubTypeBean.RowsDTO> typeList = new Gson().fromJson(json, RubTypeBean.class).getRows();
                for (RubTypeBean.RowsDTO row : typeList) {
                    if (row.getName().contains(tyname)) {
                        load(row);
                        return;
                    }
                }
                Toast.makeText(RubDetailActivity.this, "未搜索到相关分类", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void load(RubTypeBean.RowsDTO row) {
        Glide.with(RubDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + row.getImgUrl())
                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(5)).into(img);
        name.setText(row.getName());
        content.setText(row.getIntroduce());
        guideTv.setText(row.getGuide());
        goodsRecyc.setLayoutManager(new GridLayoutManager(RubDetailActivity.this, 4));


        RetrofitUtil.get("/prod-api/api/garbage-classification/garbage-example/list?type="+row.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<RubbishBean.RowsDTO> list = new Gson().fromJson(json, RubbishBean.class).getRows();
                list = list.subList(0, Math.min(list.size(), 16));
                goodsRecyc.setAdapter(new RubGoodsAdapter(RubDetailActivity.this, list));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}