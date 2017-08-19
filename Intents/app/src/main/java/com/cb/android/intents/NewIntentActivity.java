package com.cb.android.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by GhanshamBansal on 18/06/17.
 */

public class NewIntentActivity extends AppCompatActivity {

    EditText etAddress;
    Button btOpen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intent);

        etAddress = (EditText) findViewById(R.id.et_link);
        btOpen = (Button) findViewById(R.id.bv_open);

        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkToGo = etAddress.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(linkToGo));
                startActivity(i);
            }
        });


    }
}
