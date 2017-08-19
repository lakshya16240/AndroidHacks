package com.cb.android.jsonholdertypicode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cb.android.jsonholdertypicode.Adapters.AlbumsAdapter;
import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.Album;
import com.cb.android.jsonholdertypicode.api.AlbumsApi;
import com.cb.android.jsonholdertypicode.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumsActivity extends AppCompatActivity {

    RecyclerView rvAlbums;
    AlbumsAdapter albumsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        rvAlbums =(RecyclerView) findViewById(R.id.rv_Albums);
        rvAlbums.setLayoutManager(new LinearLayoutManager(this));
        albumsAdapter = new AlbumsAdapter(this,new ArrayList<Album>());
        rvAlbums.setAdapter(albumsAdapter);
        albumsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                startActivity((new Intent(AlbumsActivity.this,PhotosActivity.class)).putExtra("albumId",itemId));
            }

            @Override
            public void onTodosClick(int userId) {

            }
        });

        Api.getApiInstance().getAlbumsApi().getTitle().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumsAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });


    }
}
