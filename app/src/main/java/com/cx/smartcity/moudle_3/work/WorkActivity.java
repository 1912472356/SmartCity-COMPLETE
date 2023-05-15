package com.cx.smartcity.moudle_3.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.DeliverBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.bean.WorkBean;
import com.cx.smartcity.bean.WorkTypeBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.home.SearchActivity;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.ListAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class WorkActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ScrollView workPage;
    private Banner banner;
    private EditText searchEt;
    private RecyclerView typeRecyc;
    private RecyclerView workRecyc;
    private RecyclerView deliverRecyc;
    private LinearLayout userPage;
    private TextView userMsg;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        initView();

        initWork();
        initDeliver();
        initUser();
    }

    private void initUser() {
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                UserBean.UserDTO user = new Gson().fromJson(json, UserBean.class).getUser();
                userMsg.setText(user.getUserName()+"  "+(user.getSex().equals("0") ? "男":"女")+" \n邮件："+user.getEmail()+"\n电话号码："+user.getPhonenumber());
            }
        });
    }

    private void initDeliver() {
        deliverRecyc.setLayoutManager(new LinearLayoutManager(this));
        RetrofitUtil.get("/prod-api/api/job/deliver/list?companyId=2", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<DeliverBean.RowsDTO> list = new Gson().fromJson(json, DeliverBean.class).getRows().subList(0, 20);

                List<String> titles = new ArrayList<>();
                List<String> arr = new ArrayList<>();
                for (DeliverBean.RowsDTO row : list) {
                    titles.add(row.getPostName());
                    arr.add("公司名称："+row.getCompanyName()
                            +"\n薪资："+row.getMoney()+"元/月"
                            +"\n投递简历时间："+row.getSatrTime());
                }
                deliverRecyc.setAdapter(new CommonAdapter(WorkActivity.this, arr, titles));
            }
        });
    }

    private void initWork() {
        initBanner();
        initType();
        workRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadWork("");
    }

    private void initType() {
        RetrofitUtil.get("/prod-api/api/job/profession/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<WorkTypeBean.RowsDTO> list = new Gson().fromJson(json, WorkTypeBean.class).getRows().subList(0, 9);
                List<String> arr = new ArrayList<>();
                for (WorkTypeBean.RowsDTO row : list) {
                    arr.add(row.getProfessionName());
                }
                typeRecyc.setLayoutManager(new GridLayoutManager(WorkActivity.this, 3));
                typeRecyc.setAdapter(new ListAdapter(WorkActivity.this, arr, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        id = list.get(Integer.parseInt(json)).getId() + "";
                        loadWork(searchEt.getText().toString());
                    }
                }));
            }
        });

    }

    private void initBanner() {
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

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                int targetId = list[0].get(i).getTargetId();
                Intent intent = new Intent(WorkActivity.this, NewsDetailActivity.class);
                intent.putExtra("id", targetId);
                startActivity(intent);
            }
        });
    }


    private void initView() {

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        workPage = (ScrollView) findViewById(R.id.work_page);
        banner = (Banner) findViewById(R.id.banner);
        searchEt = (EditText) findViewById(R.id.search_et);
        typeRecyc = (RecyclerView) findViewById(R.id.type_recyc);
        workRecyc = (RecyclerView) findViewById(R.id.work_recyc);
        deliverRecyc = (RecyclerView) findViewById(R.id.deliver_recyc);
        userPage = (LinearLayout) findViewById(R.id.user_page);
        userMsg = (TextView) findViewById(R.id.user_msg);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    workPage.setVisibility(View.VISIBLE);
                    deliverRecyc.setVisibility(View.GONE);
                    userPage.setVisibility(View.GONE);
                }else if (tab.getPosition() == 1){
                    workPage.setVisibility(View.GONE);
                    deliverRecyc.setVisibility(View.VISIBLE);
                    userPage.setVisibility(View.GONE);
                }else {
                    workPage.setVisibility(View.GONE);
                    deliverRecyc.setVisibility(View.GONE);
                    userPage.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void search(View view) {
        loadWork(searchEt.getText().toString());
    }

    private void loadWork(String toString) {
        RetrofitUtil.get("/prod-api/api/job/post/list?name="+toString+"&professionId="+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<WorkBean.RowsDTO> list = new Gson().fromJson(json, WorkBean.class).getRows();
                List<String> titles = new ArrayList<>();
                List<String> arr = new ArrayList<>();
                for (WorkBean.RowsDTO row : list) {
                    titles.add(row.getName());
                    arr.add("岗位职责："+row.getObligation()
                            +"\n公司地点："+row.getAddress()
                            +"\n薪资待遇："+row.getSalary()+"元/月"
                            +"");
                }
                workRecyc.setAdapter(new CommonAdapter(WorkActivity.this, arr, titles, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        Intent intent = new Intent(WorkActivity.this, WorkDetaActivity.class);
                        intent.putExtra("data", list.get(Integer.parseInt(json)));
                        startActivity(intent);
                    }
                }));
            }
        });
    }

    public void profile(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }
}