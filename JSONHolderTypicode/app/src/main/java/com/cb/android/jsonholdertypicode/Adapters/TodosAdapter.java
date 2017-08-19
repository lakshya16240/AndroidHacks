package com.cb.android.jsonholdertypicode.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cb.android.jsonholdertypicode.Models.Todo;
import com.cb.android.jsonholdertypicode.R;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 01/07/17.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    private Context context;
    private ArrayList<Todo> todos;

    public TodosAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public TodosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_todos,parent,false);
        return new TodosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodosViewHolder holder, int position) {
        Todo thisTodo = todos.get(position);
        holder.tvTitle.setText(thisTodo.getTitle());
        holder.checkBox.setChecked(thisTodo.getCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodosViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        CheckBox checkBox;
        public TodosViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_Todos);
            checkBox =(CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}
