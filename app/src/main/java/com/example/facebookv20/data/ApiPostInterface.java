package com.example.facebookv20.data;

import com.example.facebookv20.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPostInterface {

    @GET("posts")
    public Call<List<PostsModel>> getPosts();
}
