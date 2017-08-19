package com.cb.android.fragments2;

/**
 * Created by GhanshamBansal on 20/06/17.
 */

public class Course {

    String name;
    String course;
    String language;

    public Course(String name, String course, String language) {
        this.name = name;
        this.course = course;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
