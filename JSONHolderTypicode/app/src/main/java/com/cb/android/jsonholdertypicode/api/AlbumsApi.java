package com.cb.android.jsonholdertypicode.api;

import com.cb.android.jsonholdertypicode.Models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public interface AlbumsApi {

    @GET("/albums")
    Call<ArrayList<Album>> getTitle();
}
