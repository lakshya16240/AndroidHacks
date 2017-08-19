package com.cb.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 15/06/17.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder> {

    Context context;
    ArrayList<Student> studentArrayList;

    public StudentRecyclerAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.context = context;
        this.studentArrayList=studentArrayList;
    }

    @Override


    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.student_layout,parent,false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student thisStudent = studentArrayList.get(position);
        holder.tv_name.setText(thisStudent.getName());
        holder.tv_course.setText(thisStudent.getCourse());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_course;

        public StudentViewHolder(View itemView) {
            super(itemView);
            tv_name=(TextView) itemView.findViewById(R.id.tv_name);
            tv_course=(TextView) itemView.findViewById(R.id.tv_course);
        }
    }

}
