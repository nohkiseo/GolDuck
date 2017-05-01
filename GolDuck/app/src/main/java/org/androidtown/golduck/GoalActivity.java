package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.NumberPicker;

public class GoalActivity extends AppCompatActivity {
    ImageButton btn4Back;
    ImageButton btn1;
    NumberPicker numberPicker1;
    NumberPicker numberPicker2;
    NumberPicker numberPicker3;
    NumberPicker numberPicker4;
    NumberPicker numberPicker5;
    NumberPicker numberPicker6;
    int left1=60, left2=60, left3=60;
    int right1=60,right2=60,right3=60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        init();
    }

        public void init(){
            btn1 = (ImageButton)findViewById(R.id.btn1);
            btn4Back = (ImageButton) findViewById(R.id.btn4Back);
            btn4Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GoalActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            numberPicker1 = (NumberPicker)findViewById(R.id.numberPicker1);
            numberPicker2 = (NumberPicker)findViewById(R.id.numberPicker2);
            numberPicker3 = (NumberPicker)findViewById(R.id.numberPicker3);
            numberPicker4 = (NumberPicker)findViewById(R.id.numberPicker4);
            numberPicker5 = (NumberPicker)findViewById(R.id.numberPicker5);
            numberPicker6 = (NumberPicker)findViewById(R.id.numberPicker6);

            numberPicker1.setMaxValue(70);
            numberPicker2.setMaxValue(70);
            numberPicker3.setMaxValue(70);
            numberPicker4.setMaxValue(70);
            numberPicker5.setMaxValue(70);
            numberPicker6.setMaxValue(70);
            numberPicker1.setMinValue(50);
            numberPicker2.setMinValue(50);
            numberPicker3.setMinValue(50);
            numberPicker4.setMinValue(50);
            numberPicker5.setMinValue(50);
            numberPicker6.setMinValue(50);
            numberPicker1.setValue(60);
            numberPicker2.setValue(60);
            numberPicker3.setValue(60);
            numberPicker4.setValue(60);
            numberPicker5.setValue(60);
            numberPicker6.setValue(60);
            numberPicker1.setWrapSelectorWheel(true);
            numberPicker2.setWrapSelectorWheel(true);
            numberPicker3.setWrapSelectorWheel(true);
            numberPicker4.setWrapSelectorWheel(true);
            numberPicker5.setWrapSelectorWheel(true);
            numberPicker6.setWrapSelectorWheel(true);

            numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    left1 = newVal;
                }
            });

            numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    left2 = newVal;
                }
            });

            numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    left3 = newVal;
                }
            });

            numberPicker4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    right1 = newVal;
                }
            });

            numberPicker5.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    right2 = newVal;
                }
            });

            numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    right3 = newVal;
                }
            });
        }

    public void btnclick(View view)
    {
        Intent intent = new Intent(GoalActivity.this,PracticeActivity2.class);
        intent.putExtra("left1",left1);
        intent.putExtra("left2",left2);
        intent.putExtra("left3",left3);
        intent.putExtra("right1",right1);
        intent.putExtra("right2",right2);
        intent.putExtra("right3",right3);
        startActivity(intent);
    }
}


