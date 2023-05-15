package com.cx.smartcity.smart.old;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cx.smartcity.R;

public class YanglaoCommentDialog extends Dialog implements View.OnClickListener {
    private Button cancel;
    private Button confirm;

    public YanglaoCommentDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_yanglao_comment);
        cancel = (Button) findViewById(R.id.cancel);
        confirm = (Button) findViewById(R.id.confirm);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.confirm){
            Toast.makeText(getContext(), "评价成功", Toast.LENGTH_SHORT).show();
        }
        cancel();
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (attributes.width * 0.7);
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
    }
}
