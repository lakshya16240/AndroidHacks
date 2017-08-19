package com.cb.android.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.cb.android.qrcode.OpenActivity.usersList;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    ArrayList<User> userList;
    public static int exit=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        userList = getIntent().getParcelableArrayListExtra("Users");
        //Log.d("MAIN ============ ", "onCreate: " + userList.size());

        ((Button) findViewById(R.id.bv_authenticate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(usersList!=null) {
                    for (int i = 0; i < usersList.size(); i++) {

                        if (userName.getText().toString().equals(usersList.get(i).getUsername()) &&
                                password.getText().toString().equals(usersList.get(i).getPassword())) {

                            exit = 1;
                            userName.setText("");
                            password.setText("");
                            Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                            startActivity(intent);
                        }
                    }
                    if(exit ==0) {
                        Toast.makeText(MainActivity.this, "WARNING : Username Invalid !!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                    }
                }
                else{

                    Toast.makeText(MainActivity.this, "WARNING : Username Invalid !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                }



//                if (userName.getText().toString().equals("lakshya") &&
//                        password.getText().toString().equals("lakshya")) {
//
//                    Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
//                    userName.setText("");
//                    password.setText("");
//                    startActivity(intent);
//
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "WARNING!! Invalid Login Credentials", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, SignUpActivity.class));
//                }
            }

        });

//    public void updateUserList(ArrayList<User> userList){
//
//        this.userList=userList;
//    }
    }
}
