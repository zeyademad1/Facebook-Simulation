package com.example.facebookv20.data;

import com.example.facebookv20.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// This Class is to avoid retyping the same sample
public class PostClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private final ApiPostInterface apiPostInterface;
    private PostClient instance;

    public PostClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // retrofit will fill the data automatically
        apiPostInterface = retrofit.create(ApiPostInterface.class);
    }

    public PostClient getInstance() {
        // to be sure that the instance is already taken!!
        if (instance == null)
            instance = new PostClient();
        return instance;
    }

    public Call<List<PostsModel>> getPosts(){
        return apiPostInterface.getPosts();
    }
}
