package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public interface PhotosApi {
    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getPhotoByAlbumId(
            @Path("id") int id
    );
}
