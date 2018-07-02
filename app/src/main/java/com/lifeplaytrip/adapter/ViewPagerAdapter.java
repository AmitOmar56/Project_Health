package com.lifeplaytrip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lifeplaytrip.fragment.FridayFragment;
import com.lifeplaytrip.fragment.MondayFragment;
import com.lifeplaytrip.fragment.SaturdayFragment;
import com.lifeplaytrip.fragment.SundayFragment;
import com.lifeplaytrip.fragment.ThursdayFragment;
import com.lifeplaytrip.fragment.TuesdayFragment;
import com.lifeplaytrip.fragment.WednesdayFragment;

/**
 * Created by user on 10/24/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new MondayFragment();
        } else if (position == 1) {
            fragment = new TuesdayFragment();
        } else if (position == 2) {
            fragment = new WednesdayFragment();
        } else if (position == 3) {
            fragment = new ThursdayFragment();
        } else if (position == 4) {
            fragment = new FridayFragment();
        } else if (position == 5) {
            fragment = new SaturdayFragment();
        } else if (position == 6) {
            fragment = new SundayFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Monday";
        } else if (position == 1) {
            title = "Tuesday";
        } else if (position == 2) {
            title = "Wednesday";
        } else if (position == 3) {
            title = "Thursday";
        } else if (position == 4) {
            title = "Friday";
        } else if (position == 5) {
            title = "Saturday";
        } else if (position == 6) {
            title = "Sunday";
        }


        return title;
    }
}