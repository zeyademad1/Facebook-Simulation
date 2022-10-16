package com.example.facebookv20.UI;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv20.data.PostClient;
import com.example.facebookv20.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostsModel>> mutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> ErrorDetails = new MutableLiveData<>();
    public void getPost(){
        new PostClient().getInstance().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                Log.d("fail" , t.getMessage());
                ErrorDetails.setValue(t.getMessage());
            }
        });
    }
}
