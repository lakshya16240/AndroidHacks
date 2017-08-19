package com.cb.android.farecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText distance, time;
    TextView fare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distance = (EditText) findViewById(R.id.et_kms);
        time = (EditText) findViewById(R.id.et_time);
        fare = (TextView) findViewById(R.id.tv_fare);
        ((Button) findViewById(R.id.bv_calculate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float km = Float.valueOf(distance.getText().toString());
                float min = Float.valueOf(time.getText().toString());
                float fare = calcFare(km,min);

            }
        });
    }

    static float calcFare(float km , float min) {
        return 25 + ((km > 2) ? ((km -2) * 8)  : (0))  + ((min > 15) ? (min - 15):0);
    }
}
