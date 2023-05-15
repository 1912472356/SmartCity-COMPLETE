package com.cx.smartcity.moudle_2.move;

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
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.WuliuDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class WuliuDetailActivity extends AppCompatActivity {
    private Banner banner;
    private TextView desc;
    private TextView moveMethod;
    private TextView moveMoney;
    private WuliuDetailBean.DataDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuliu_detail);
        banner = (Banner) findViewById(R.id.banner);
        desc = (TextView) findViewById(R.id.desc);
        moveMethod = (TextView) findViewById(R.id.move_method);
        moveMoney = (TextView) findViewById(R.id.move_money);

        int id = getIntent().getIntExtra("id", 11);
        RetrofitUtil.get("/prod-api/api/logistics-inquiry/logistics_company/" + id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                data = new Gson().fromJson(json, WuliuDetailBean.class).getData();
                desc.setText(data.getIntroduce());
                moveMethod.setText(data.getShippingMethod());


                initBanner();
                initMoney();
            }
        });
    }

    private void initMoney() {
        moveMoney.setText("");
        if (data.getPriceList() == null || data.getPriceList().size() == 0) {
            moveMoney.setText("暂无价格信息");
        }else {
            for (WuliuDetailBean.DataDTO.PriceListDTO row : data.getPriceList()) {
                moveMoney.setText(row.getAreaName()+"首重"+row.getObjStart()+"元，续重"+row.getObjStep()+"元"+"\n"+moveMethod.getText().toString());
            }
        }
    }

    private void initBanner() {
        if (data.getNewsList() == null || data.getNewsList().size() == 0) {
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    String advImg = ((BannerBean.RowsDTO) o).getAdvImg();
                    Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                            .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
                }
            });
            final List<BannerBean.RowsDTO>[] list = new List[1];
            RetrofitUtil.get("/prod-api/api/rotation/list?type=2", new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    list[0] = new Gson().fromJson(json, BannerBean.class).getRows();
                    banner.setImages(list[0]);
                    banner.start();
                }
            });

        } else {
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    String advImg = ((WuliuDetailBean.DataDTO.NewsListDTO) o).getImgUrl();
                    Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + advImg)
                            .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(imageView);
                }
            });
            banner.setImages(data.getNewsList());
            banner.start();
        }
    }

    public void back(View view) {
        finish();
    }
}