package com.cx.smartcity.moudle_2.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;

public class BusDateActivity extends AppCompatActivity {
    private TextView date;
    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_date);
        date = (TextView) findViewById(R.id.date);
        calendar = (CalendarView) findViewById(R.id.calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date.setText(i+"-"+(i1+1) + "-" + i2);
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent intent = new Intent(this, BusEntryOutActivity.class);
        intent.putExtra("date", date.getText().toString());
        startActivity(intent);
    }
}