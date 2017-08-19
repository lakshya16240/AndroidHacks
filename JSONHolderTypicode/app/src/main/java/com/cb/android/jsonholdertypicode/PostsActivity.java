package com.cb.android.jsonholdertypicode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cb.android.jsonholdertypicode.Adapters.PostsAdapter;
import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.Post;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.PostsApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPosts;
    PostsAdapter postsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPosts = (RecyclerView) findViewById(R.id.rv_Posts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter =new PostsAdapter(this,new ArrayList<Post>());
        rvPosts.setAdapter(postsAdapter);
        postsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Log.d("posts", "onPostsClick: " + itemId);
                startActivity((new Intent(PostsActivity.this,CommentsActivity.class)).putExtra("postsId",itemId));
            }

            @Override
            public void onTodosClick(int userId) {

            }
        });

        Callback<ArrayList<Post>> postCallback = new Callback<ArrayList<Post>>(){
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {

                postsAdapter.updatePosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        };

        int userIdReceived = getIntent().getIntExtra("userId",-1);
        if(userIdReceived == -1)
        {
            Api.getApiInstance().getPostsApi().getPosts().enqueue(postCallback);
        }
        else
        {
            Api.getApiInstance().getPostsApi().getPostsByUserId(userIdReceived).enqueue(postCallback);
        }


    }
}
