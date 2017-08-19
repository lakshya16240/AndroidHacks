package com.cb.android.fragments3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GhanshamBansal on 22/06/17.
 */

public class MyFagmentPagerAdapter extends FragmentPagerAdapter {

    int fragCount= 0 ;
    List<Fragment> fragmentList;
    public MyFagmentPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.fragCount=count;
        this.fragmentList = new ArrayList<>(getCount());
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        try{
            fragment = fragmentList.get(position);
        } catch(IndexOutOfBoundsException ioobe)
        {
            fragment = BlankFragment.newInstance(
                    "Fragment : " + position,
                    "Another Fragment");
            fragmentList.add(position,fragment);
        }
        if(fragment == null)
        {
            fragment = BlankFragment.newInstance(
                    "Fragment : " + position,
                    "Another Fragment");
            fragmentList.add(position,fragment);
        }
                return  fragment;
    }

    @Override
    public int getCount() {
        return fragCount;
    }
}
