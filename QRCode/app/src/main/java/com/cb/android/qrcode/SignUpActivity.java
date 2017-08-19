package com.cb.android.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

import static com.cb.android.qrcode.OpenActivity.usersList;

public class SignUpActivity extends AppCompatActivity {

    EditText et_fname;
    EditText et_sname;
    EditText et_email;
    EditText et_password;
    EditText et_username;
    ArrayList<User> users;
    MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        users = new ArrayList<User>();
        et_fname = (EditText) findViewById(R.id.et_fname);
        et_sname = (EditText) findViewById(R.id.et_sname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_username = (EditText) findViewById(R.id.et_username);

        ((Button)findViewById(R.id.bv_signup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usersList.add(new User(et_fname.getText().toString(),
                        et_sname.getText().toString(),
                        et_username.getText().toString(),
                        et_email.getText().toString(),
                        et_password.getText().toString()));

                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                intent.putParcelableArrayListExtra("Users", users);
                startActivity(intent);
            }
        });


    }
}
