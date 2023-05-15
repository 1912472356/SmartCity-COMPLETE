package com.cx.smartcity.moudle_3.illegal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.cx.smartcity.R;

public class IllegalActivity extends AppCompatActivity {
    private Spinner type;
    private Spinner area;
    private EditText plate;
    private EditText engin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegal);
        type = (Spinner) findViewById(R.id.type);
        area = (Spinner) findViewById(R.id.area);
        plate = (EditText) findViewById(R.id.plate);
        engin = (EditText) findViewById(R.id.engin);


    }

    public void back(View view) {
        finish();
    }

    public void query(View view) {
        Intent intent = new Intent(this, IllegalListActivity.class);
        intent.putExtra("name", "/prod-api/api/traffic/illegal/list?catType="+type.getSelectedItem().toString()
                +"&licencePlate="+area.getSelectedItem().toString() + plate.getText().toString());
        startActivity(intent);
    }
}