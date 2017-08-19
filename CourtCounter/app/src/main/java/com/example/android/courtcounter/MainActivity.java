package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int p=0,q=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);
    }
    /**
     * Displays the given score for Team A.
     */
    public void three(View v){
        p=p+3;
        displayForTeamA(p);
    }
    public void two(View v){
        p=p+2;
        displayForTeamA(p);
    }
    public void one(View v){
        p=p+1;
        displayForTeamA(p);
    }
    public void threeB(View v){
        q=q+3;
        displayForTeamB(q);
    }
    public void twoB(View v){
        q=q+2;
        displayForTeamB(q);
    }
    public void oneB(View v){
        q=q+1;
        displayForTeamB(q);
    }
    public  void reset(View v){
        p=0;
        q=0;
        displayForTeamA(p);
        displayForTeamB(q);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
