package com.cx.smartcity.moudle_2.consult;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.LawBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.moudle_2.law.LawTypeDialog;
import com.cx.smartcity.person.PersonMsgActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ConsultActivity extends AppCompatActivity {
    private ImageView img;
    private TextView haoping;
    private TextView name;
    private TextView content;
    private TextView lawType;
    private EditText type;
    private EditText question;
    private ImageView upImg;
    private EditText phone;

    private LawBean.RowsDTO data;
    private String id;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        initView();
        data = (LawBean.RowsDTO) getIntent().getSerializableExtra("data");
        initLaw();
        initType();
        initImg();
    }

    private void initImg() {
        upImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    }else  startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
                }else startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
        }else Toast.makeText(this, "暂无权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);
            cursor.moveToFirst();
            path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            Glide.with(ConsultActivity.this).load(BitmapFactory.decodeFile(path))
                    .error(R.mipmap.user_head).transform(new CircleCrop()).into(upImg);

        }
    }

    private void initType() {
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LawTypeDialog(ConsultActivity.this, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        id = json;
                    }
                }, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        type.setText(json);
                    }
                }).show();
            }
        });
    }

    private void initLaw() {

        haoping.setText(data.getFavorableRate()+"%好评");
        name.setText(data.getName());
        int year = Math.min("2022".compareTo(data.getWorkStartAt()),1);
        content.setText("从业"+year+"年，"+data.getServiceTimes()+"人咨询过");
        lawType.setText(data.getLegalExpertiseName());
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getAvatarUrl())
                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        haoping = (TextView) findViewById(R.id.haoping);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        lawType = (TextView) findViewById(R.id.law_type);
        type = (EditText) findViewById(R.id.type);
        question = (EditText) findViewById(R.id.question);
        upImg = (ImageView) findViewById(R.id.up_img);
        phone = (EditText) findViewById(R.id.phone);

    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("lawyerId", data.getId());
        map.put("legalExpertiseId", id == null ? data.getLegalExpertiseId() : id);
        map.put("content", question.getText().toString());
        map.put("imageUrls", path);
        map.put("phone", phone.getText().toString());
        RetrofitUtil.post("/prod-api/api/lawyer-consultation/legal-advice", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(ConsultActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(ConsultActivity.this, "提交失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}