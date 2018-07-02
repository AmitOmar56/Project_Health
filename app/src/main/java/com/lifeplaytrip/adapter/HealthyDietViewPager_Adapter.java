package com.lifeplaytrip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lifeplaytrip.fragment.Non_vegetarianFragment;
import com.lifeplaytrip.fragment.VegetarianFragment;

/**
 * Created by user on 11/13/2017.
 */

public class HealthyDietViewPager_Adapter  extends FragmentPagerAdapter {

    public HealthyDietViewPager_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new VegetarianFragment();
        } else if (position == 1) {
            fragment = new Non_vegetarianFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Vegetarian";
        } else if (position == 1) {
            title = "Non-vegetarian";
        }


        return title;
    }

}
