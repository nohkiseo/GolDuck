package org.androidtown.golduck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class CompareGraphActivity extends AppCompatActivity {
    ImageButton graphBack;
    ImageButton start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        btnClick();


        GraphView graph1 = (GraphView) findViewById(R.id.LeftPro);
        GraphView graph2 = (GraphView) findViewById(R.id.LeftUser);
        GraphView graph3 = (GraphView) findViewById(R.id.RightPro);
        GraphView graph4 = (GraphView) findViewById(R.id.RightUser);

        // 왼발 오른발의 가중치?
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 53),
                new DataPoint(1, 57),
                new DataPoint(2, 54),
                new DataPoint(3, 63),
                new DataPoint(4, 65)
        });

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 54),
                new DataPoint(1, 60),
                new DataPoint(2, 63),
                new DataPoint(3, 57),
                new DataPoint(4, 60)
        });

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 61),
                new DataPoint(1, 58),
                new DataPoint(2, 63),
                new DataPoint(3, 65),
                new DataPoint(4, 62)
        });

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 57),
                new DataPoint(1, 55),
                new DataPoint(2, 60),
                new DataPoint(3, 65),
                new DataPoint(4, 70)
        });

        // 유저데이터의 색은 빨갛게
        series2.setColor(Color.parseColor("#ff0000"));
        series4.setColor(Color.parseColor("#ff0000"));

        //화면에 뿌려줍니다.
        graph1.addSeries(series1);
        graph2.addSeries(series2);
        graph3.addSeries(series3);
        graph4.addSeries(series4);


        //프로데이터를 앞에 보이게
        graph1.bringToFront();
        graph3.bringToFront();

    }

    public void btnClick(){
        graphBack = (ImageButton)findViewById(R.id.graphBack);
        start = (ImageButton)findViewById(R.id.start);

        graphBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareGraphActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareGraphActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });


    }
}