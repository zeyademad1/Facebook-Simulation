package com.example.facebookv20.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.facebookv20.R;
import com.example.facebookv20.databinding.ActivityMainBinding;
import com.example.facebookv20.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView posts_rv;
    PostsAdapter adapter;
    PostsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posts_rv = findViewById(R.id.posts_rv);

        viewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        viewModel.getPost();
        PopulateData();
        viewModel.mutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                adapter.setPosts((ArrayList<PostsModel>) postsModels);
            }
        });
        viewModel.ErrorDetails.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.uwp2605540)
                        .setMessage(s)
                        .setTitle("An Error Occurred")
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                              }
                        })
                        .create();
                dialog.show();
            }
        });

    }

    public void PopulateData() {
        adapter = new PostsAdapter();
        posts_rv.setAdapter(adapter);
        posts_rv.setLayoutManager(new LinearLayoutManager(this));
        posts_rv.setHasFixedSize(true);
    }
}