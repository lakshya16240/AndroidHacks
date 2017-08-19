package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.Photo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public interface PicApi {
    @GET("/photos/{id}")
    Call<Photo> getPicById (
            @Path("id") int id
    );
}
