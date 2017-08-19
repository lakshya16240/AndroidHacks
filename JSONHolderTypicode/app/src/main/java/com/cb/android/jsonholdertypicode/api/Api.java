package com.cb.android.jsonholdertypicode.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GhanshamBansal on 02/07/17.
 */

public class Api {

    private static Api apiInstance;
    private AlbumsApi albumsApi;
    private CommentsApi commentsApi;
    private PhotosApi photosApi;
    private PicApi picApi;
    private  PostsApi postsApi;
    private TodosApi todosApi;
    private UsersApi usersApi;

    public static Api getApiInstance() {
        if(apiInstance==null)
            apiInstance = new Api();
        return apiInstance;
    }

    public AlbumsApi getAlbumsApi() {
        return albumsApi;
    }

    public CommentsApi getCommentsApi() {
        return commentsApi;
    }

    public PhotosApi getPhotosApi() {
        return photosApi;
    }

    public PicApi getPicApi() {
        return picApi;
    }

    public PostsApi getPostsApi() {
        return postsApi;
    }

    public TodosApi getTodosApi() {
        return todosApi;
    }

    public UsersApi getUsersApi() {
        return usersApi;
    }

    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        albumsApi = retrofit.create(AlbumsApi.class);
        commentsApi = retrofit.create(CommentsApi.class);
        photosApi = retrofit.create(PhotosApi.class);
        picApi = retrofit.create(PicApi.class);
        postsApi = retrofit.create(PostsApi.class);
        todosApi = retrofit.create(TodosApi.class);
        usersApi = retrofit.create(UsersApi.class);

    }
}
