package com.cb.android.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        text = (TextView) findViewById(R.id.tv_other);

        int data1 = getIntent().getIntExtra("data1",0);
        int data2 = getIntent().getIntExtra("data2",0);
        text.setText(String.valueOf(data1+data2));


    }
}
