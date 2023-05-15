package com.cx.smartcity.moudle_2.sub_car;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.cx.smartcity.R;

public class CheckAddressDialog extends Dialog {
    public CheckAddressDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_check_address);
        super.onCreate(savedInstanceState);
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
