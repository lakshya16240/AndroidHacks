package com.cb.android.recyclerview;

/**
 * Created by GhanshamBansal on 15/06/17.
 */

public class Student {

    String name;
    String course;

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(String section, String course) {
        this.name = section;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
