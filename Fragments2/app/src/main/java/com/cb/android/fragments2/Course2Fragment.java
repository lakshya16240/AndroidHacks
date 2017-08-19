package com.cb.android.fragments2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course2Fragment extends Fragment {

    public static final String ARG_NAME = "name";
    public static final String ARG_TEACHER = "teacher";
    public static final String ARG_LANGUAGE = "laguage";

    // TODO: Rename and change types of parameters
    private String courseName;
    private String courseTeacher;
    private String courseLanguage;

    TextView tvName, tvTeacher, tvLang;



    public Course2Fragment() {
        // Required empty public constructor
    }

    /*
    * *
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param teacher Parameter 2.
     * @param language Parameter 3.
     * @return A new instance of fragment Course2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Course2Fragment newInstance(Course c) {
        Course2Fragment fragment = new Course2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_LANGUAGE, c.getLanguage());
        args.putString(ARG_NAME, c.getName());
        args.putString(ARG_TEACHER, c.getName());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            courseName = getArguments().getString(ARG_NAME);
            courseLanguage = getArguments().getString(ARG_LANGUAGE);
            courseTeacher = getArguments().getString(ARG_TEACHER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);
        tvName = (TextView) rootView.findViewById(R.id.tvCourseName);
        tvTeacher = (TextView) rootView.findViewById(R.id.tvCourseTeacher);
        tvLang = (TextView) rootView.findViewById(R.id.tvCourseLanguage);

        tvName.setText(courseName);
        tvTeacher.setText(courseTeacher);
        tvLang.setText(courseLanguage);
        return rootView;
    }

}
