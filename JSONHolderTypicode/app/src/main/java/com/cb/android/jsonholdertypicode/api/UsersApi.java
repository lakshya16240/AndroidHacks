package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GhanshamBansal on 30/06/17.
 */

public interface UsersApi {

    @GET("/users")
    Call<ArrayList<User>> getUsers ();
}

