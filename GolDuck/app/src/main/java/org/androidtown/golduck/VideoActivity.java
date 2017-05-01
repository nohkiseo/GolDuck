package org.androidtown.golduck;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    ImageButton graphback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btnClick();

        final VideoView ProVideo = (VideoView) findViewById(R.id.ProVideo);
        final VideoView UserVideo = (VideoView) findViewById(R.id.UserVideo);

        ProVideo.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video1);
        UserVideo.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video2);

        ProVideo.setMediaController(new MediaController(this));
        UserVideo.setMediaController(new MediaController(this));

        ProVideo.requestFocus();
        UserVideo.requestFocus();

        Thread view1Thrad = new Thread(new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
                ProVideo.start();
            }
        });
        Thread view2Thrad = new Thread(new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_DISPLAY);
                UserVideo.start();
            }
        });
        view1Thrad.start();
        view2Thrad.start();
    }
    public void btnClick(){
       graphback = (ImageButton)findViewById(R.id.graphBack);

        graphback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoActivity.this,CompareGraphActivity.class);
                startActivity(intent);
            }
        });

    }

}
