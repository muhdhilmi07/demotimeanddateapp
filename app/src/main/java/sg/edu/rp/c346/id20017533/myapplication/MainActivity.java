package sg.edu.rp.c346.id20017533.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        reset = findViewById(R.id.btnReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Time is ";
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                msg = msg + hour + ":" + min;
                tvDisplay.setText(msg);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Date is ";
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                msg = msg + day + "/" + month + "/" + year;
                tvDisplay.setText(msg);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            tp.setCurrentHour(0);
            tp.setCurrentMinute(0);
            dp.updateDate(2020, 0,1);
            }
        });
    }
}

