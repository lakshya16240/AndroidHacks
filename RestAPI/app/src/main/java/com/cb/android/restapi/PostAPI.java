package com.cb.android.restapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by GhanshamBansal on 28/06/17.
 */

public interface PostAPI {

    @GET("/posts/{id}/comments")
    Call<ArrayList<PostComment>> getPostComments(
            @Path("id") int postId
    );

    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId(
            @Query("userId") int userId
    );

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();


    @GET("/posts/{id}")
    Call<Post> getPost (
            @Path("id") int postId
    );

    @GET("/users/{id}")
    Call<User> getUser (
            @Path("id") int userId
    );
}