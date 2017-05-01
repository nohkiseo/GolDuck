package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RepeatActivity extends AppCompatActivity {
    ImageButton btn3Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);
        init();
    }

    public void init(){
        btn3Back = (ImageButton) findViewById(R.id.btn3Back);
        btn3Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RepeatActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
