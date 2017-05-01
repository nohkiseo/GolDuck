package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;

import java.util.Calendar;

public class CaladerActivity extends AppCompatActivity {
    ImageButton btn5Back;
    DatePicker datePicker;
    int m_year;
    int m_month;
    int m_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calader);
        init();
    }
    public void init(){
        final Calendar calendar = Calendar.getInstance();
        btn5Back = (ImageButton) findViewById(R.id.btn5Back);
        btn5Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaladerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        m_year = calendar.get(Calendar.YEAR);
        m_month = calendar.get(Calendar.MONTH);
        m_date = calendar.get(Calendar.DATE);
        datePicker.init(m_year, m_month, m_date, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                m_year = datePicker.getYear();
                m_month = datePicker.getMonth();
                m_date = datePicker.getDayOfMonth();
            }
        });
    }

    public void btnclick(View view) {
        Intent intent = new Intent(CaladerActivity.this,RecordActivity.class);
        intent.putExtra("Year",m_year);
        intent.putExtra("Month",m_month+1);
        intent.putExtra("Date",m_date);
        startActivity(intent);
    }

}
