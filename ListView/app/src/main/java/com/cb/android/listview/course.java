package com.cb.android.listview;

/**
 * Created by GhanshamBansal on 11/06/17.
 */

public class course {

    String name;
    String teacher;
    int batches;
    String center;

    public course(String name, String teacher, int batches, String center) {
        this.name = name;
        this.teacher = teacher;
        this.batches = batches;
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getBatches() {
        return batches;
    }

    public String getCenter() {
        return center;
    }

}
