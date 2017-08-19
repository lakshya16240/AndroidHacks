package com.cb.android.jsonholdertypicode.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Models.Comment;
import com.cb.android.jsonholdertypicode.R;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private Context context;
    private ArrayList<Comment> comments;

    public CommentsAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }




    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_comments,parent,false);
        return new CommentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comment thisComment = comments.get(position);
        holder.tvCommentBody.setText(thisComment.getBody());
        holder.tvCommentEmail.setText(thisComment.getEmail());
        holder.tvCommentName.setText(thisComment.getName());


    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder{
        TextView tvCommentBody, tvCommentName, tvCommentEmail;
        public CommentsViewHolder(View itemView) {
            super(itemView);
            tvCommentBody = (TextView) itemView.findViewById(R.id.tvCommentBody);
            tvCommentEmail = (TextView) itemView.findViewById(R.id.tvCommentEmail);
            tvCommentName = (TextView) itemView.findViewById(R.id.tvCommentName);

        }
    }
}
