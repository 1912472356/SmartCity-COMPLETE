package com.cx.smartcity.moudle_1.love;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cx.smartcity.R;
import com.cx.smartcity.util.RetrofitUtil;

public class DonateDialog extends android.app.Dialog implements View.OnClickListener {
    private EditText content;
    private Button cancle;
    private Button confirm;
    RetrofitUtil.OnRequest onRequest;

    public DonateDialog(@NonNull Context context, RetrofitUtil.OnRequest onRequest) {
        super(context);
        this.onRequest = onRequest;
    }

    public DonateDialog(@NonNull Context context, int themeResId, RetrofitUtil.OnRequest onRequest) {
        super(context, themeResId);
        this.onRequest = onRequest;
    }

    public DonateDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, RetrofitUtil.OnRequest onRequest) {
        super(context, cancelable, cancelListener);
        this.onRequest = onRequest;
    }

    public DonateDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_donate);

        content = (EditText) findViewById(R.id.content);
        cancle = (Button) findViewById(R.id.cancle);
        confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(this);
        cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.confirm) {
            Toast.makeText(getContext(), "捐助成功", Toast.LENGTH_SHORT).show();
            onRequest.onRequest(content.getText().toString());
        }
        cancel();
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams attr = window.getAttributes();
        attr.width = (int) (attr.width * 0.7);
        attr.gravity = Gravity.CENTER;
        window.setAttributes(attr);
    }
}
