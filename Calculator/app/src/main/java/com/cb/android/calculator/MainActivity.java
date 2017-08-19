package com.cb.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.onClick;


public class MainActivity extends AppCompatActivity  {

    /*Button plus = (Button) findViewById(R.id.plus);
    Button minus = (Button) findViewById(R.id.minus);
    Button multiply = (Button) findViewById(R.id.mul);
    Button divide = (Button) findViewById(R.id.divide);*/
    TextView scoreView;

    public static double n=0,temp=0;
    public static char dot,sym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView= (TextView) findViewById(R.id.answer);
        scoreView.setText("0");
        /*plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);*/

//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//

//        });


    }

    /*@Override
    public void onClick(View v){
        if (v == multiply){
            //
        }
        else if (v == plus){
            //
        }
        else if (v == divide){
            //
        }
        else if (v == minus){
            //
        }
    }*/
    public void one(View v)
    {
        if(dot=='.')
            n=(n*10+1)/10;
        else
            n=n*10+1;
        display();
    }
    public void two(View v)
    {
        if(dot=='.')
            n=(n*10+2)/10;
        else
            n=n*10+2;
        display();
    }
    public void three(View v)
    {
        if(dot=='.')
            n=(n*10+3)/10;
        else
            n=n*10+3;
        display();
    }
    public void four(View v)
    {
        if(dot=='.')
            n=(n*10+4)/10;
        else
            n=n*10+4;
        display();
    }
    public void five(View v)
    {
        if(dot=='.')
            n=(n*10+5)/10;
        else
            n=n*10+5;
        display();
    }
    public void six(View v)
    {
        if(dot=='.')
            n=(n*10+6)/10;
        else
            n=n*10+6;
        display();
    }
    public void seven(View v)
    {
        if(dot=='.')
            n=(n*10+7)/10;
        else
            n=n*10+7;
        display();
    }
    public void eight(View v)
    {
        if(dot=='.')
            n=(n*10+8)/10;
        else
            n=n*10+8;
        display();
    }
    public void nine(View v)
    {
        if(dot=='.')
            n=(n*10+9)/10;
        else
            n=n*10+9;
        display();

    }
    public void dot(View v)
    {
        dot = '.';
    }

    public void display()
    {
        scoreView= (TextView) findViewById(R.id.answer);
        scoreView.setText(String .valueOf(n));
    }
    public void plus(View v)
    {
        answer(findViewById(R.id.ans));
        sym='+';
        temp=n;
        n=0;
    }
    public void multiply(View v)
    {
        answer(findViewById(R.id.ans));
        sym='*';
        temp=n;
        n=0;
    }
    public void divide(View v)
    {
        answer(findViewById(R.id.ans));
        sym='/';
        temp=n;
        n=0;

    }
    public void minus(View v)
    {
        answer(findViewById(R.id.ans));
        sym='-';
        temp=n;
        n=0;
    }

    public void clear(View v)
    {
        n=temp=0;
        display();
    }
    public void answer(View v)
    {
        scoreView= (TextView) findViewById(R.id.answer);
        if(sym=='+')
        {
            n=n+temp;
            scoreView.setText(String.valueOf(n));
        }

        else if(sym=='*') {
            n=n*temp;
            scoreView.setText(String.valueOf(n));
        }
        else if(sym=='/') {
            n=temp/n;
            scoreView.setText(String.valueOf(n));
        }
        else if(sym=='-') {
            n = temp-n;
            scoreView.setText(String.valueOf(n));
        }



    }
}
