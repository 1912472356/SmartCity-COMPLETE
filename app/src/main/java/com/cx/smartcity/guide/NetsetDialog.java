package com.cx.smartcity.guide;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cx.smartcity.R;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;

public class NetsetDialog extends Dialog {
    private EditText ipEt;
    private Button btn;

    public NetsetDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_netset);

        ipEt = (EditText) findViewById(R.id.ip_et);
        btn = (Button) findViewById(R.id.btn);

        ipEt.setInputType(InputType.TYPE_CLASS_NUMBER);
        ipEt.setKeyListener(DigitsKeyListener.getInstance("0123456789:."));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "IP端口设置成功", Toast.LENGTH_SHORT).show();
                SPUtil.put(SPUtil.HTTP, "http://"+ipEt.getText().toString());
                RetrofitUtil.init(getContext());
                cancel();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams attr = window.getAttributes();
        attr.width = (int) (attr.width*0.7);
        attr.gravity = Gravity.CENTER;
        window.setAttributes(attr);
    }
}
