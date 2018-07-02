package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lifeplaytrip.R;
import com.lifeplaytrip.adapter.GainWeightViewPager_Adapter;

public class GainWeightActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GainWeightViewPager_Adapter gainWeightViewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight);

        viewPager = (ViewPager) findViewById(R.id.gainPager);
        gainWeightViewPager_adapter = new GainWeightViewPager_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(gainWeightViewPager_adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void gainWeight(View view){
        finish();
    }
}
