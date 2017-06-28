package com.example.imanshu.levler;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Imanshu on 6/20/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    // Tab Titles
    private String tabtitles[] = new String[] { "My-Review", "All-Review"};
    Context context;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open FragmentTab1.java
            case 0:
                My_Invites_Review fragmenttab1 = new My_Invites_Review();
                return fragmenttab1;


            // Open FragmentTab2.java
            case 1:
                All_Reviews fragmenttab2 = new All_Reviews();
                return fragmenttab2;

            // Open FragmentTab3.java

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}