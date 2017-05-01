package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PracticeActivity2 extends AppCompatActivity {
    ImageButton btn1Back;
    ImageView btn1Play;
    public Handler handler = new Handler();
    CountDownTimer timer = null;
    int tmp = 0;
    int left1;
    int left2;
    int left3;
    int right1;
    int right2;
    int right3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);
        init();
        BtnListen();
    }
    public void init() {
        btn1Back = (ImageButton) findViewById(R.id.btn1Back);
        btn1Play = (ImageView) findViewById(R.id.btn1Play);
        Intent intent = getIntent();
        left1 = intent.getIntExtra("left1",0);
        left2 = intent.getIntExtra("left2",0);
        left3 = intent.getIntExtra("left3",0);
        right1 = intent.getIntExtra("right1",0);
        right2 = intent.getIntExtra("right2",0);
        right3 = intent.getIntExtra("right3",0);
    }

    public void BtnListen() {
        btn1Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //화면 바꿈
                Intent intent = new Intent(PracticeActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btn1Play.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    timer = new CountDownTimer(4000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            switch (tmp)
                            {
                                case 0:
                                    btn1Play.setImageResource(R.drawable.num3);
                                    tmp++;
                                    break;
                                case 1:
                                    btn1Play.setImageResource(R.drawable.num2);
                                    tmp++;
                                    break;
                                case 2:
                                    btn1Play.setImageResource(R.drawable.num1);
                                    tmp++;
                                    break;
                            }
                        }

                        @Override
                        public void onFinish() {
                            Intent intent = new Intent(PracticeActivity2.this,CompareGraphActivity2.class);
                            intent.putExtra("left1",left1);
                            intent.putExtra("left2",left2);
                            intent.putExtra("left3",left3);
                            intent.putExtra("right1",right1);
                            intent.putExtra("right2",right2);
                            intent.putExtra("right3",right3);
                            startActivity(intent);
                        }
                    };
                    timer.start();
                }
                return true;
            }
        });
    }

    public void UpDate() {

        Runnable updater = new Runnable() {
            @Override
            public void run() {
                btn1Play.setImageResource(R.drawable.menu_practice);
            }
        };
        handler.post(updater);
    }

}
