package com.cx.smartcity.moudle_1.post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.PostDetaBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

public class PostDetailActivity extends AppCompatActivity {
    private Banner banner;
    private TextView address;
    private TextView call;
    private TextView time;
    private TextView bed;
    private TextView intro;
    private TextView internalFacilities;
    private TextView surroundingFacilities;
    private TextView specialService;
    private PostDetaBean.DataDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        int id = getIntent().getIntExtra("id", 11);


        banner = (Banner) findViewById(R.id.banner);
        address = (TextView) findViewById(R.id.address);
        call = (TextView) findViewById(R.id.call);
        time = (TextView) findViewById(R.id.time);
        bed = (TextView) findViewById(R.id.bed);
        intro = (TextView) findViewById(R.id.intro);
        internalFacilities = (TextView) findViewById(R.id.internalFacilities);
        surroundingFacilities = (TextView) findViewById(R.id.surroundingFacilities);
        specialService = (TextView) findViewById(R.id.specialService);

        RetrofitUtil.get("/prod-api/api/youth-inn/youth-inn/"+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                data = new Gson().fromJson(json, PostDetaBean.class).getData();
                initBanner();
                address.setText(data.getAddress());
                call.setText(data.getPhone());
                time.setText("办理入住时间段："+data.getWorkTime());
                bed.setText("剩余床位：男|"+data.getBedsCountBoy()+"  女|"+data.getBedsCountGirl());
                intro.setText(data.getIntroduce());
                internalFacilities.setText(data.getInternalFacilities());
                surroundingFacilities.setText(data.getSurroundingFacilities());
                specialService.setText(data.getSpecialService());

            }
        });
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + o)
                                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
            }
        });
        banner.setImages(data.getImageUrlList());
        banner.start();
    }

    public void back(View view) {
        finish();
    }
}