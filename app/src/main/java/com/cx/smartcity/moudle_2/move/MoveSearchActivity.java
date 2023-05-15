package com.cx.smartcity.moudle_2.move;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.MoveBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class MoveSearchActivity extends AppCompatActivity {
    private SearchView searchEt;
    private ImageView logo;
    private TextView name;
    private TextView call;
    private RecyclerView moveRecyc;
    private MoveBean.DataDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_search);

        searchEt = (SearchView) findViewById(R.id.search_et);
        logo = (ImageView) findViewById(R.id.logo);
        name = (TextView) findViewById(R.id.name);
        call = (TextView) findViewById(R.id.call);
        moveRecyc = (RecyclerView) findViewById(R.id.move_recyc);

        String name = getIntent().getStringExtra("name");
        searchEt.setQuery(name, false);

        initSearch();
        initData();
        initMsg();
    }

    private void initMsg() {
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getCompany().getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(logo);
        name.setText(data.getCompany().getName());
        call.setText(data.getCompany().getPhone());

        moveRecyc.setLayoutManager(new LinearLayoutManager(this));
        moveRecyc.setAdapter(new MoveAdapter(this, data.getStepList()));
    }

    private void initSearch() {
        searchEt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MoveSearchActivity.this, MoveSearchActivity.class);
                intent.putExtra("name", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initData() {
        String json = "{\n" +
                "\"msg\": \"操作成功\",\n" +
                "\"code\": 200,\n" +
                "\"data\": {\n" +
                "\"createTime\": \"2022-03-07 11:32:51\",\n" +
                "\"id\": 6,\n" +
                "\"companyId\": 6,\n" +
                "\"infoNo\": \"ST0000001\",\n" +
                "\"company\": {\n" +
                "\"id\": 6,\n" +
                "\"name\": \"申通物流\",\n" +
                "\"sort\": 1,\n" +
                "\"imgUrl\": \"/prod-api/profile/upload/image/2022/03/14/cce0fba6-ad2c-4b12-a9a2-a860ad6f7cad.jpeg\",\n" +
                "\"introduce\": \"申通快递品牌初创于 1993 年，公司致力于民族品牌的建设和发展，不断完善终端网络、中转运输网络和信息网络三网一体的立体运行体系，立足传统快递业务，全面进入电子商务领域，以专业的服务和严格的质量管。\",\n" +
                "\"shippingMethod\": \"空运,陆运,海运,大件慢速物流\",\n" +
                "\"phone\": \"18842424242\",\n" +
                "\"priceList\": null,\n" +
                "\"newsList\": null\n" +
                "},\n" +
                "\"stepList\": [\n" +
                "{\n" +
                "\"id\": 7,\n" +
                "\"infoId\": 6,\n" +
                "\"eventAt\": \"2022-03-02\",\n" +
                "\"stateName\": \"快递发出\",\n" +
                "\"addressAt\": \"辽宁省大连市甘井子区中转站\"\n" +
                "},\n" +
                "{\n" +
                "\"id\": 6,\n" +
                "\"infoId\": 6,\n" +
                "\"eventAt\": \"2022-03-01\",\n" +
                "\"stateName\": \"快递被揽收\",\n" +
                "\"addressAt\": \"辽宁省大连市中转场\"\n" +
                "},\n" +
                "{\n" +
                "\"id\": 5,\n" +
                "\"infoId\": 6,\n" +
                "\"eventAt\": \"2022-02-27\",\n" +
                "\"stateName\": \"快递已收件\",\n" +
                "\"addressAt\": \"辽宁省大连市城西妈妈驿站\"\n" +
                "}\n"+
                "]\n" +
                "}\n" +
                "}";
        data = new Gson().fromJson(json, MoveBean.class).getData();
    }

    public void back(View view) {
        finish();
    }

    public void tousu(View view) {
        startActivity(new Intent(this, TousuActivity.class));
    }
}