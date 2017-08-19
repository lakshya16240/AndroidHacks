package com.cb.android.jsonholdertypicode.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.Post;
import com.cb.android.jsonholdertypicode.R;

import java.util.ArrayList;


/**
 * Created by GhanshamBansal on 30/06/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private Context context;
    private ArrayList<Post> posts;
    private OnItemClickListener onItemClickListener;


    public PostsAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    public void updatePosts (ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_posts,parent,false);

        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        final Post thisPost= posts.get(position);
        holder.tvPostTitle.setText(thisPost.getTitle());
        holder.tvPostBody.setText(thisPost.getBody());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(thisPost.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{
        TextView tvPostBody,tvPostTitle;
        View thisView;

        public PostsViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvPostBody = (TextView) itemView.findViewById(R.id.tv_PostBody);
            tvPostTitle = (TextView) itemView.findViewById(R.id.tv_PostTitle);
        }
    }

}
