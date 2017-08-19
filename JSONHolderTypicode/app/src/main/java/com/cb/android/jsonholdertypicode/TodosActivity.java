package com.cb.android.jsonholdertypicode;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cb.android.jsonholdertypicode.Adapters.TodosAdapter;
import com.cb.android.jsonholdertypicode.Models.Todo;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.TodosApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodosActivity extends AppCompatActivity {

    RecyclerView rvTodos;
    TodosAdapter todosAdapter;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodos = (RecyclerView) findViewById(R.id.rv_Todos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));


        Callback<ArrayList<Todo>> callback = new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("todos", "onResponse: ");
                todosAdapter = new TodosAdapter(context,response.body());
                rvTodos.setAdapter(todosAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        };
        int idReceived = getIntent().getIntExtra("userId",-1);
        if(idReceived==-1)
        {
            Api.getApiInstance().getTodosApi().getTodos().enqueue(callback);
        }
        else
        {
            Api.getApiInstance().getTodosApi().getTodosByUserId(idReceived).enqueue(callback);
        }
    }
}
