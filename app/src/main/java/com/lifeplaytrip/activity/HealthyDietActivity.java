package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lifeplaytrip.R;
import com.lifeplaytrip.adapter.HealthyDietViewPager_Adapter;

public class HealthyDietActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HealthyDietViewPager_Adapter healthyDietViewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_diet);

        viewPager = (ViewPager) findViewById(R.id.healthypager);
        healthyDietViewPager_adapter = new HealthyDietViewPager_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(healthyDietViewPager_adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void healthyWeight(View view) {
       finish();
    }
}
