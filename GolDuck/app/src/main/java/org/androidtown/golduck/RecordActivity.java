package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecordActivity extends AppCompatActivity {
    ImageButton btn2Back;
    TextView Year;
    TextView Month;
    TextView Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        init();
    }
    public void init(){
        btn2Back = (ImageButton) findViewById(R.id.btn2Back);
        btn2Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Year = (TextView)findViewById(R.id.Year);
        Month = (TextView)findViewById(R.id.Month);
        Day = (TextView)findViewById(R.id.Day);

        Intent intent = getIntent();
        int mYear = intent.getIntExtra("Year",0);
        int mMonth = intent.getIntExtra("Month",0);
        int mDate = intent.getIntExtra("Date",0);

        String year = String.valueOf(mYear);
        String month = String.valueOf(mMonth);
        String date = String.valueOf(mDate);

        Year.setText(year+". ");
        Month.setText(month+". ");
        Day.setText(date);
    }
}
