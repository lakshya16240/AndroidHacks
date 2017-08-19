package com.cb.android.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.button;
import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="Main Activity";
    EditText num1;
    EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: =========");
        num1 = (EditText) findViewById(R.id.et_num1);
        num2 = (EditText) findViewById(R.id.et_num2);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i = new Intent(MainActivity.this,OtherActivity.class);
//
//                int data1 = Integer.parseInt(num1.getText().toString());
//                int data2 = Integer.parseInt(num2.getText().toString());
//                i.putExtra("data1",data1);
//                i.putExtra("data2",data2);
//                startActivity(i);
                Intent i = new Intent(MainActivity.this,NewIntentActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ======");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: =======");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: =========");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: =======");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: =========");
        super.onDestroy();
    }
}
