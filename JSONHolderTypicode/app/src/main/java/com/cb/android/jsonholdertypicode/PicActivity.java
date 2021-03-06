package com.cb.android.jsonholdertypicode;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Models.Photo;
import com.cb.android.jsonholdertypicode.api.Api;
import com.cb.android.jsonholdertypicode.api.PicApi;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicActivity extends AppCompatActivity {

    Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        Api.getApiInstance().getPicApi().getPicById(getIntent().getIntExtra("photoId",-1)).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                Picasso.with(context).load(response.body().getUrl()).into((ImageView) findViewById(R.id.imv_Pic));
                ((TextView) findViewById(R.id.tv_Pic)).setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });

    }
}
