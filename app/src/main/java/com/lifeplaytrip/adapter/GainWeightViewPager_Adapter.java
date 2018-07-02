package com.lifeplaytrip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lifeplaytrip.gainfragment.GainFridayFragment;
import com.lifeplaytrip.gainfragment.GainMondayFragment;
import com.lifeplaytrip.gainfragment.GainSaturdayFragment;
import com.lifeplaytrip.gainfragment.GainSundayFragment;
import com.lifeplaytrip.gainfragment.GainThursdayFragment;
import com.lifeplaytrip.gainfragment.GainTuesdayFragment;
import com.lifeplaytrip.gainfragment.GainWednesdayFragment;

/**
 * Created by user on 11/13/2017.
 */

public class GainWeightViewPager_Adapter extends FragmentPagerAdapter {

    public GainWeightViewPager_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new GainMondayFragment();
        } else if (position == 1) {
            fragment = new GainTuesdayFragment();
        } else if (position == 2) {
            fragment = new GainWednesdayFragment();
        } else if (position == 3) {
            fragment = new GainThursdayFragment();
        } else if (position == 4) {
            fragment = new GainFridayFragment();
        } else if (position == 5) {
            fragment = new GainSaturdayFragment();
        } else if (position == 6) {
            fragment = new GainSundayFragment();
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
