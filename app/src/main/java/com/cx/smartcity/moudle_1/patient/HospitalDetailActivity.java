package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.HospitalBean;
import com.cx.smartcity.bean.LoveBannerBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class HospitalDetailActivity extends AppCompatActivity {
    private Banner banner;
    private LinearLayout starList;
    private TextView name;
    private TextView desc;
    private HospitalBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_detail);
        starList = (LinearLayout) findViewById(R.id.star_list);
        banner = (Banner) findViewById(R.id.banner);
        name = (TextView) findViewById(R.id.name);
        desc = (TextView) findViewById(R.id.desc);
        data = (HospitalBean.RowsDTO) getIntent().getSerializableExtra("data");

        name.setText(data.getHospitalName());
        starList.removeAllViews();
        desc.setText(Html.fromHtml(data.getBrief()));
        for (int i = 0; i < data.getLevel(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_baseline_star_border_24);
            imageView.setColorFilter(Color.YELLOW);
            starList.addView(imageView);
        }
        initBanner();
    }


    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                String advImg = ((LoveBannerBean.DataDTO) o).getImgUrl();
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
            }
        });
        final List<LoveBannerBean.DataDTO>[] list = new List[1];
        RetrofitUtil.get("/prod-api/api/hospital/banner/list?hospitalId="+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list[0] = new Gson().fromJson(json, LoveBannerBean.class).getData();
                banner.setImages(list[0]);
                banner.start();
            }
        });

    }

    public void back(View view) {
        finish();
    }

    public void to(View view) {
        startActivity(new Intent(this, PatientCardActivity.class));
    }
}