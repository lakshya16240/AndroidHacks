package com.cb.android.jsonholdertypicode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.bv_posts)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,PostsActivity.class);
                startActivity(i);
            }
        });
        ((Button) findViewById(R.id.bv_users)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,UsersActivity.class);
                startActivity(i);
            }
        });
        ((Button) findViewById(R.id.bv_albums)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,AlbumsActivity.class);
                startActivity(i);
            }
        });
        ((Button) findViewById(R.id.bv_todos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,TodosActivity.class);
                startActivity(i);
            }
        });

    }
}
