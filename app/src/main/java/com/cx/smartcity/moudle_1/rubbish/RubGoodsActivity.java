package com.cx.smartcity.moudle_1.rubbish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.RubTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class RubGoodsActivity extends AppCompatActivity {

    private TextView name;
    private ImageView img;
    private TextView content;
    private TextView guideTv;
    private String rubname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub_goods);
        rubname = getIntent().getStringExtra("name");
        if (rubname == null) {
            rubname = "*(@*&#&*@#..adcy";
        }
        final int id = getIntent().getIntExtra("id", -1);

        name = (TextView) findViewById(R.id.name);
        img = (ImageView) findViewById(R.id.img);
        content = (TextView) findViewById(R.id.content);
        guideTv = (TextView) findViewById(R.id.guide_tv);


        RetrofitUtil.get("/prod-api/api/garbage-classification/garbage-classification/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<RubTypeBean.RowsDTO> typeList = new Gson().fromJson(json, RubTypeBean.class).getRows();
                for (RubTypeBean.RowsDTO row : typeList) {
                    if (row.getName().equals(rubname) || row.getId() == id) {
                        load(row);
                    }
                }
            }
        });

    }


    private void load(RubTypeBean.RowsDTO row) {
        Glide.with(RubGoodsActivity.this).load(SPUtil.get(SPUtil.HTTP) + row.getImgUrl())
                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(5)).into(img);
        name.setText(row.getName());
        content.setText(row.getIntroduce());
        guideTv.setText(row.getGuide());
    }
    public void back(View view) {
        finish();
    }
}