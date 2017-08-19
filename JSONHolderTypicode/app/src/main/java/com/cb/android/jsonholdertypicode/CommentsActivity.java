package com.cb.android.jsonholdertypicode;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cb.android.jsonholdertypicode.Adapters.CommentsAdapter;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.CommentsApi;

import org.w3c.dom.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {

    CommentsAdapter commentsAdapter;
    RecyclerView rvComments;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        rvComments = (RecyclerView) findViewById(R.id.rv_comments);
        rvComments.setLayoutManager(new LinearLayoutManager(this));

        Api.getApiInstance().getCommentsApi().getCommentsByPostId((getIntent().getIntExtra("postsId",-1))).enqueue(new Callback<ArrayList<com.cb.android.jsonholdertypicode.Models.Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<com.cb.android.jsonholdertypicode.Models.Comment>> call, Response<ArrayList<com.cb.android.jsonholdertypicode.Models.Comment>> response) {
                commentsAdapter = new CommentsAdapter(context,response.body());
                rvComments.setAdapter(commentsAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<com.cb.android.jsonholdertypicode.Models.Comment>> call, Throwable t) {

            }
        });


    }
}
