package org.androidtown.golduck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class CompareGraphActivity2 extends AppCompatActivity {

    ImageButton graphBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_graph2);
        btnClick();
        GraphView graph1 = (GraphView) findViewById(R.id.LeftGoal);
        GraphView graph2 = (GraphView) findViewById(R.id.RightGoal);
        GraphView graph3 = (GraphView) findViewById(R.id.LeftRecord);
        GraphView graph4 = (GraphView) findViewById(R.id.RightRecord);

        Intent intent = getIntent();
        int left1 = intent.getIntExtra("left1",0);
        int left2 = intent.getIntExtra("left2",0);
        int left3 = intent.getIntExtra("left3",0);
        int right1 = intent.getIntExtra("right1",0);
        int right2 = intent.getIntExtra("right2",0);
        int right3 = intent.getIntExtra("right3",0);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, left1),
                new DataPoint(1, left2),
                new DataPoint(2, left3)
        });

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, right1),
                new DataPoint(1, right2),
                new DataPoint(2, right3)
        });

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 65),
                new DataPoint(1, 57),
                new DataPoint(2, 68)
        });

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 52),
                new DataPoint(1, 68),
                new DataPoint(2, 65)
        });

        series3.setColor(Color.parseColor("#ff0000"));
        series4.setColor(Color.parseColor("#ff0000"));

        graph1.addSeries(series1);
        graph2.addSeries(series2);
        graph3.addSeries(series3);
        graph4.addSeries(series4);

        graph1.bringToFront();
        graph2.bringToFront();
    }

    public void btnClick() {
        graphBack = (ImageButton) findViewById(R.id.graphBack);
        graphBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareGraphActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
