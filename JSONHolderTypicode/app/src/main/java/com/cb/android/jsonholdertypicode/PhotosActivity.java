package com.cb.android.jsonholdertypicode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cb.android.jsonholdertypicode.Adapters.PhotosAdapter;
import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.Photo;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.PhotosApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotosActivity extends AppCompatActivity {

    RecyclerView rvPhotos;
    PhotosAdapter photosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        rvPhotos = (RecyclerView) findViewById(R.id.rv_Photos);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));
        photosAdapter = new PhotosAdapter(this,new ArrayList<Photo>());
        rvPhotos.setAdapter(photosAdapter);
        photosAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                startActivity((new Intent(PhotosActivity.this,PicActivity.class)).putExtra("photoId",itemId));
            }

            @Override
            public void onTodosClick(int userId) {

            }
        });

        Api.getApiInstance().getPhotosApi().getPhotoByAlbumId(getIntent().getIntExtra("albumId",-1)).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photosAdapter.updatePhotos(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });

    }
}
