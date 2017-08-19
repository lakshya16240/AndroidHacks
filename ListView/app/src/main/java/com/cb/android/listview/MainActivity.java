package com.cb.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


//    String[] cbCourses = {
//            "Pandora","Elixir","Launchpad","Crux","Algo++"
//    };
    ArrayList<course> cbcourses=generateCourses();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView courseListView = (ListView) findViewById(R.id.lv_courses);
//        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                cbCourses
//        );
//        courseListView.setAdapter(courseAdapter);

        CourseAdapter courseAdapter = new CourseAdapter();
        courseListView.setAdapter(courseAdapter);
    }

    static ArrayList<course> generateCourses() {
        ArrayList<course> courses=new ArrayList<>();

        courses.add(new course("Pandora","Arnav",1,"Pitampura"));
        courses.add(new course("elixir","Ayush",1,"Pitampura"));
        courses.add(new course("Pandora","Harshit",1,"Pitampura"));
        courses.add(new course("Elixir","Arnav",1,"Pitampura"));
        courses.add(new course("Launchpad","Prateek",1,"Pitampura"));
        courses.add(new course("Crux","Sumit",3,"Pitampura"));
        courses.add(new course("Algo++","Prateek",1,"Pitampura"));
        return courses;

    }

    class CourseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return cbcourses.size();
        }

        @Override
        public course getItem(int i) {
            return cbcourses.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = getLayoutInflater();
            course thisCourse=getItem(i);

            if(view == null)
                view = li.inflate(R.layout.list_item_course, null);

            ((TextView)view.findViewById(R.id.tv_courseName))
                    .setText(thisCourse.getName());
            ((TextView)view.findViewById(R.id.tv_centerName))
                    .setText(thisCourse.getCenter());
            ((TextView)view.findViewById(R.id.tv_courseBatches))
                    .setText(String.valueOf(thisCourse.getBatches()));
            ((TextView)view.findViewById(R.id.tv_teacherName))
                    .setText(String.valueOf(thisCourse.getTeacher()));


            return view;
        }
    }
}

