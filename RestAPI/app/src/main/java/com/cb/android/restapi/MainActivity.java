package com.cb.android.restapi;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "REST";

    Button btnDownload;
    RecyclerView rvListPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.button);
        rvListPost = (RecyclerView) findViewById(R.id.rcv);
        rvListPost.setLayoutManager(new LinearLayoutManager(this));
        final PostAdapter postsAdapter = new PostAdapter(
                new ArrayList<Post>(),
                MainActivity.this
        );
        rvListPost.setAdapter(postsAdapter);
        postsAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                Intent i = new Intent(MainActivity.this, PostCommentActivity.class);
                i.putExtra("postId", pos);
                startActivity(i);
            }
        });


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask dTask = new DownloadTask(new DownloadTask.OnDownloadListener() {
                    @Override
                    public void onDownloaded(ArrayList<Post> posts) {
                        Toast.makeText(MainActivity.this,
                                "posts downloaded = " + posts.size(),
                                Toast.LENGTH_SHORT).show();

                        postsAdapter.updatePostList(posts);
                    }
                });

                dTask.execute("http://jsonplaceholder.typicode.com/posts");
            }
        });

    }

}
