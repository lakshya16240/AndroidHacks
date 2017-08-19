package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GhanshamBansal on 30/06/17.
 */

public interface PostsApi {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts ();

    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId (
            @Query("userId") int userId
    );
}
