package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;

public class PingguActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinggu);
    }

    public void back(View view) {
        finish();
    }

    public void pinggu(View view) {
        Dialog dialog = new Dialog(this);
        TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.notice_content, null);
        tv.setText("《评估结果》\n"+"1. 对藁城市区及周边地区老人入住免费车接\n" +
                "2. 残疾老人、无儿女老人、智障人员入住,享受相应优惠政策\n" +
                "3. 为老人建立健康档案，配备专业资格医生进行诊断，护理人员持证上岗\n" +
                "4. 专业厨师根据季节及老人身体情况进行营养配餐\n");
        dialog.setContentView(tv);
        dialog.show();
    }
}