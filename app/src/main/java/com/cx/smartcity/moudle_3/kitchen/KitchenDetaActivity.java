package com.cx.smartcity.moudle_3.kitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.KitchenBean;
import com.cx.smartcity.bean.KitchenDetailBean;
import com.cx.smartcity.moudle_3.kitchen.KitchenDetaActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class KitchenDetaActivity extends AppCompatActivity {
    private ImageView collectBtn;
    private ImageView img;
    private TextView name;
    private TextView intro;
    private TextView likeCollect;
    private RecyclerView stepRecyc;


    private KitchenDetailBean.DataDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_deta);
        KitchenBean.RowsDTO aa = (KitchenBean.RowsDTO) getIntent().getSerializableExtra("data");

        collectBtn = (ImageView) findViewById(R.id.collect_btn);
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        intro = (TextView) findViewById(R.id.intro);
        likeCollect = (TextView) findViewById(R.id.like_collect);
        stepRecyc = (RecyclerView) findViewById(R.id.step_recyc);


        RetrofitUtil.get("/prod-api/api/kitchen-helper/dishes/"+aa.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                data = new Gson().fromJson(json, KitchenDetailBean.class).getData();
                initMsg();
                initCollect();
                initStep();
            }
        });
    }

    private void initStep() {
        stepRecyc.setLayoutManager(new LinearLayoutManager(this));
        stepRecyc.setAdapter(new KitchenStepAdapter(this, data.getStepList()));
    }

    private void initCollect() {
        loadCollect();

        collectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("dishesId", data.getId());
                map.put("newState", !data.isMyCollectionState());
                RetrofitUtil.post("/prod-api/api/kitchen-helper/dishes-collection", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(KitchenDetaActivity.this, (data.isMyCollectionState()?"取消收藏":"收藏")+"成功", Toast.LENGTH_SHORT).show();
                                data.setMyCollectionState(!data.isMyCollectionState());

                                int idx = data.isMyCollectionState() ? 1 :-1;
                                data.setLikeCount(data.getCollectionCount() + idx);
                                loadCollect();
                            }else {
                                Toast.makeText(KitchenDetaActivity.this, (data.isMyCollectionState()?"取消收藏":"收藏")+"失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void loadCollect() {
        if (data.isMyCollectionState()) {
            collectBtn.setImageResource(R.drawable.ic_baseline_star_fill);
        }else {
            collectBtn.setImageResource(R.drawable.ic_baseline_star_border_24);
        }
        likeCollect.setText(data.getLikeCount()+"人点赞，"+data.getCollectionCount()+"人收藏");
    }

    private void initMsg() {
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(img);
        name.setText(data.getName());
        intro.setText("原料："+data.getIngredients());
        likeCollect.setText(data.getLikeCount()+"人点赞，"+data.getCollectionCount()+"人收藏");

    }

    public void back(View view) {
        finish();
    }
}