package com.cb.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList studentArrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArrayList=generate();
        recyclerView=(RecyclerView) findViewById(R.id.rv_Student);
        StudentRecyclerAdapter studentRecyclerAdapter =new StudentRecyclerAdapter(studentArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentRecyclerAdapter);

    }


    static ArrayList<Student> generate()
    {
        ArrayList<Student> courses=new ArrayList<>();

        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        courses.add(new Student("A","Pandora"));
        courses.add(new Student("B","elixir"));
        courses.add(new Student("C","Pandora"));
        courses.add(new Student("D","Elixir"));
        courses.add(new Student("E","Launchpad"));
        courses.add(new Student("F","Crux"));
        courses.add(new Student("G","Algo++"));
        return courses;
    }
}
