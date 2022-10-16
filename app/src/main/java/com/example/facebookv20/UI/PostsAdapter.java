package com.example.facebookv20.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.facebookv20.R;
import com.example.facebookv20.pojo.PostsModel;
import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    ArrayList<PostsModel> posts = new ArrayList<>();

    public void setPosts(ArrayList<PostsModel> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.titleTv.setText(String.format("Title: %s", posts.get(position).getTitle()));
        holder.useridTV.setText(String.format("UserId: %s", String.valueOf(posts.get(position).getUserId())));
        holder.bodyTv.setText(String.format("Body %s", posts.get(position).getBody()));
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv , bodyTv , useridTV;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title);
            useridTV = itemView.findViewById(R.id.tv_userId);
            bodyTv = itemView.findViewById(R.id.tv_body);
        }

        
    }
}
