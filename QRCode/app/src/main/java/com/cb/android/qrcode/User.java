package com.cb.android.qrcode;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GhanshamBansal on 10/07/17.
 */

public class User implements Parcelable {

    String fname;
    String sname;
    String username;
    String email;
    String password;

    public User(String fname, String sname, String username, String email, String password) {
        this.fname = fname;
        this.sname = sname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public String getSname() {
        return sname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    private User(Parcel in){

        fname = in.readString();
        sname = in.readString();
        username = in.readString();
        email = in.readString();
        password = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeString(sname);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(password);

    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
