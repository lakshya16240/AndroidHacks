package com.cb.android.jsonholdertypicode.api;


import com.cb.android.jsonholdertypicode.Models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public interface CommentsApi {

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId(
            @Query("postId") int postId
    );

}