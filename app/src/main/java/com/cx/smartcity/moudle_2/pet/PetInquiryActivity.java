package com.cx.smartcity.moudle_2.pet;

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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.PetInquiryBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.person.PersonMsgActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PetInquiryActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private EditText question;
    private ImageView upImg;
    private String path;
    private PetInquiryBean.RowsDTO.DoctorDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_inquiry);

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        question = (EditText) findViewById(R.id.question);
        upImg = (ImageView) findViewById(R.id.up_img);

        String json = getIntent().getStringExtra("data");
        data = new Gson().fromJson(json, PetInquiryBean.RowsDTO.DoctorDTO.class);
        if (data == null) {
            Toast.makeText(this, "医生信息不存在", Toast.LENGTH_SHORT).show();
            finish();
        }
        name.setText(data.getName()+"（"+data.getJobName()+"）");
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getAvatar())
                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(img);
        content.setText("执业编号："+data.getPracticeNo());

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
            Glide.with(PetInquiryActivity.this).load(BitmapFactory.decodeFile(path))
                    .error(R.mipmap.user_head).transform(new CenterCrop()).into(upImg);

        }
    }


    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("doctorId", data.getId());
        map.put("question", question.getText().toString());
        map.put("imageUrls", path);
        RetrofitUtil.post("/prod-api/api/pet-hospital/inquiry", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(PetInquiryActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(PetInquiryActivity.this, "提交失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}