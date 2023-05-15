package com.cx.smartcity.moudle_3.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.CompanyDetailBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.bean.WorkBean;
import com.cx.smartcity.bean.WorkProfileBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class WorkDetaActivity extends AppCompatActivity {
    private TextView employMsg;
    private TextView companyMsg;
    private WorkBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_deta);
        employMsg = (TextView) findViewById(R.id.employ_msg);
        companyMsg = (TextView) findViewById(R.id.company_msg);

        data = (WorkBean.RowsDTO) getIntent().getSerializableExtra("data");
        employMsg.setText("职位名称："+data.getName()
                +"\n岗位职责："+data.getObligation()
                +"\n公司地点："+data.getAddress()
                +"\n薪资待遇："+data.getSalary()+"元/月"
                +"\n联系人："+data.getContacts()
                +"\n职位描述："+data.getProfessionName()
                +"\n职位需求："+data.getNeed());
        RetrofitUtil.get("/prod-api/api/job/company/"+data.getCompanyId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                CompanyDetailBean.DataDTO companyData = new Gson().fromJson(json, CompanyDetailBean.class).getData();

                companyMsg.setText("公司名称："+companyData.getCompanyName()+"\n公司简介："+companyData.getIntroductory()+"");
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void deliver(View view) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                int userId = new Gson().fromJson(json, UserBean.class).getUser().getUserId();
                RetrofitUtil.get("/prod-api/api/job/resume/queryResumeByUserId/"+userId, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        WorkProfileBean.DataDTO profile = new Gson().fromJson(json, WorkProfileBean.class).getData();
                        if (TextUtils.isEmpty(profile.getEducation()) || TextUtils.isEmpty(profile.getExperience()) ) {
                            startActivity(new Intent(WorkDetaActivity.this, ProfileActivity.class));
                        }else {
                            HashMap<Object, Object> map = new HashMap<>();
                            map.put("companyId", data.getCompanyId());
                            map.put("satrTime", sdf.format(new Date()));
                            map.put("postId", data.getId());
                            map.put("postName", data.getName());
                            map.put("money", data.getSalary());
                            RetrofitUtil.post("/prod-api/api/job/deliver", map, new RetrofitUtil.OnRequest() {
                                @Override
                                public void onRequest(String json) {
                                    try {
                                        JSONObject obj = new JSONObject(json);
                                        if (obj.getInt("code") == 200) {
                                            Toast.makeText(WorkDetaActivity.this, "投递成功", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }else {
                                            Toast.makeText(WorkDetaActivity.this, "投递失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}