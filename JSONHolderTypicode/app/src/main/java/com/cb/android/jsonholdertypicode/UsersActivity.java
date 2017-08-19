package com.cb.android.jsonholdertypicode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cb.android.jsonholdertypicode.Adapters.UsersAdapter;
import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.User;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.UsersApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UsersActivity extends AppCompatActivity {

    RecyclerView rvUsers;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        rvUsers = (RecyclerView) findViewById(R.id.rv_Users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter= new UsersAdapter(this,new ArrayList<User>());
        rvUsers.setAdapter(usersAdapter);
        usersAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                startActivity((new Intent(UsersActivity.this,PostsActivity.class)).putExtra("userId",itemId));
            }

            @Override
            public void onTodosClick(int userId) {
                startActivity((new Intent(UsersActivity.this,TodosActivity.class)).putExtra("userId",userId));
            }
        });


        Api.getApiInstance().getUsersApi().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                usersAdapter.updateUsers(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });


    }
}
