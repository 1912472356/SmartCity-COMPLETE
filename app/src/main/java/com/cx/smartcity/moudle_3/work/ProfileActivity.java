package com.cx.smartcity.moudle_3.work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.bean.WorkProfileBean;
import com.cx.smartcity.bean.WorkTypeBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private EditText exprice;
    private EditText most;
    private EditText address;
    private Spinner job;
    private EditText salara;
    private EditText edu;
    private EditText profile;

    private List<WorkTypeBean.RowsDTO> workTypeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        exprice = (EditText) findViewById(R.id.exprice);
        most = (EditText) findViewById(R.id.most);
        address = (EditText) findViewById(R.id.address);
        job = (Spinner) findViewById(R.id.job_et);
        salara = (EditText) findViewById(R.id.salara);
        edu = (EditText) findViewById(R.id.edu);
        profile = (EditText) findViewById(R.id.profile);


        RetrofitUtil.get("/prod-api/api/job/profession/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                workTypeList = new Gson().fromJson(json, WorkTypeBean.class).getRows();
                List<String> arr = new ArrayList<>();
                for (WorkTypeBean.RowsDTO row : workTypeList) {
                    arr.add(row.getProfessionName());
                }
                job.setAdapter(new ArrayAdapter<String>(ProfileActivity.this,R.layout.support_simple_spinner_dropdown_item, arr));
                initMsg();
            }
        });

    }

    private void initMsg() {
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                int userId = new Gson().fromJson(json, UserBean.class).getUser().getUserId();
                RetrofitUtil.get("/prod-api/api/job/resume/queryResumeByUserId/"+userId, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        WorkProfileBean.DataDTO data = new Gson().fromJson(json, WorkProfileBean.class).getData();
                        if (data != null) {
                            exprice.setText(data.getExperience());
                            most.setText(data.getMostEducation());
                            address.setText(data.getAddress());
                            for (int i = 0; i < workTypeList.size(); i++) {
                                if (workTypeList.get(i).getId() == data.getPositionId()) {
                                    job.setSelection(i);
                                }
                            }
                            salara.setText(data.getMoney());
                            edu.setText(data.getEducation());
                            profile.setText(data.getIndividualResume());
                        }
                    }
                });
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                int userId = new Gson().fromJson(json, UserBean.class).getUser().getUserId();
                RetrofitUtil.get("/prod-api/api/job/resume/queryResumeByUserId/"+userId, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        WorkProfileBean.DataDTO profileData = new Gson().fromJson(json, WorkProfileBean.class).getData();
                        HashMap<Object, Object> map = new HashMap<>();
                        map.put("mostEducation", most.getText().toString());
                        map.put("education", edu.getText().toString());
                        map.put("address", address.getText().toString());
                        map.put("experience", exprice.getText().toString());
                        map.put("individualResume", profile.getText().toString());
                        map.put("money", salara.getText().toString());
                        map.put("positionId", workTypeList.get(job.getSelectedItemPosition()).getId());
                        if (profileData == null) {
                            RetrofitUtil.post("/prod-api/api/job/resume", map, new RetrofitUtil.OnRequest() {
                                @Override
                                public void onRequest(String json) {
                                    response(json);
                                }
                            });
                        }else {
                            map.put("id", profileData.getId());
                            RetrofitUtil.put("/prod-api/api/job/resume", map, new RetrofitUtil.OnRequest() {
                                @Override
                                public void onRequest(String json) {
                                    response(json);
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    private void response(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            if (obj.getInt("code") == 200) {
                Toast.makeText(ProfileActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(ProfileActivity.this, "保存失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}