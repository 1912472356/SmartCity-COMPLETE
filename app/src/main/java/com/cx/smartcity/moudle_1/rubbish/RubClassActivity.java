package com.cx.smartcity.moudle_1.rubbish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.RubbishBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RubClassActivity extends AppCompatActivity {
    private RecyclerView goodsRecyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub_class);
        goodsRecyc = (RecyclerView) findViewById(R.id.goods_recyc);

        goodsRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/garbage-classification/garbage-example/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<RubbishBean.RowsDTO> list = new Gson().fromJson(json, RubbishBean.class).getRows().subList(0, 20);
                List<String> titles= new ArrayList<>();
                for (RubbishBean.RowsDTO row : list) {
                    titles.add(row.getName());
                }
                goodsRecyc.setAdapter(new CommonAdapter(RubClassActivity.this, null, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        RubbishBean.RowsDTO rowsDTO = list.get(Integer.parseInt(json));
                        int type = rowsDTO.getType();
                        Intent intent = new Intent(RubClassActivity.this, RubGoodsActivity.class);
                        intent.putExtra("id", type);
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void detail(View view) {
        Intent intent = new Intent(this, RubGoodsActivity.class);
        switch (view.getId()) {
            case R.id.type1:
                intent.putExtra("name", "可回收物");
                break;
            case R.id.type2:
                intent.putExtra("name", "有害垃圾");
                break;
            case R.id.type3:
                intent.putExtra("name", "厨余垃圾");
                break;
            case R.id.type4:
                intent.putExtra("name", "其他垃圾");
                break;
        }
        startActivity(intent);
    }
}