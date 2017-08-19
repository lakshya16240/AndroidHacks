package com.cb.android.changetext;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static java.lang.System.currentTimeMillis;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_change);
        ((Button) findViewById(R.id.bv_press)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler h =new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("changed!!");
                    }
                };
                h.postDelayed(r,5000);
            }
        });
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("world");
                Intent i =new Intent(MainActivity.this,MyService.class);
                i.putExtra("hello", "started from MainActivity");
                startService(i);
            }
        });
    }
}
