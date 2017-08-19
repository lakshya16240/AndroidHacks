package com.cb.android.jsonholdertypicode.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Interface.OnItemClickListener;
import com.cb.android.jsonholdertypicode.Models.User;
import com.cb.android.jsonholdertypicode.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by GhanshamBansal on 30/06/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context context;
    private ArrayList<User> users;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    public UsersAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    public void updateUsers(ArrayList<User> newUserList) {
        this.users = newUserList;
        notifyDataSetChanged();
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("User", "onCreateViewHolder: ");
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_users,parent,false);
        return new UsersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        final User thisUser = users.get(position);
        holder.tvUserEmail.setText(thisUser.getEmail());
        holder.tvUserName.setText(thisUser.getName());
        holder.tvUserPhone.setText(thisUser.getPhone());
        holder.tvUserUsername.setText(thisUser.getUsername());
        holder.posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null)
                {
                    onItemClickListener.onItemClick(thisUser.getId());
                }
            }

        });
       holder.todos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(onItemClickListener!=null)
               {
                   onItemClickListener.onTodosClick(thisUser.getId());
               }
           }
       });




    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends  RecyclerView.ViewHolder{

        TextView tvUserUsername, tvUserName, tvUserPhone, tvUserEmail;
        Button posts,todos;
        public UsersViewHolder(View itemView) {
            super(itemView);
            posts = (Button) itemView.findViewById(R.id.bv_userPosts);
            todos = (Button) itemView.findViewById(R.id.bv_Todos);
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserPhone = (TextView) itemView.findViewById(R.id.tvUserPhone);
            tvUserUsername = (TextView) itemView.findViewById(R.id.tvUserUsername);
        }
    }
}
