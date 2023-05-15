package com.cx.smartcity.moudle_2.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BusBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.HashMap;

public class BusEntryOutActivity extends AppCompatActivity {
    private TextView start;
    private TextView end;
    private EditText name;
    private EditText tel;
    private EditText entry;
    private EditText out;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_entry_out);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        name = (EditText) findViewById(R.id.name);
        tel = (EditText) findViewById(R.id.tel);
        entry = (EditText) findViewById(R.id.entry);
        out = (EditText) findViewById(R.id.out);

        BusBean.RowsDTO data = new Gson().fromJson(SPUtil.get(SPUtil.BUS_MSG), BusBean.RowsDTO.class);
        start.setText(data.getFirst());
        end.setText(data.getEnd());
        date = getIntent().getStringExtra("date");
    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("tel", tel.getText().toString());
        map.put("name", name.getText().toString());
        map.put("entry", entry.getText().toString());
        map.put("out", out.getText().toString());
        map.put("date", date);
        Intent intent = new Intent(this, BusSubActivity.class);
        intent.putExtra("data", map);
        startActivity(intent);
    }
}