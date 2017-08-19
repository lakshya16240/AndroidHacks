package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public interface TodosApi {

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos ();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodosByUserId (
            @Query("userId") int userId
    );
}
