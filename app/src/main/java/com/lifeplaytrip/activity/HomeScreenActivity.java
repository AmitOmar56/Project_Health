package com.lifeplaytrip.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.lifeplaytrip.R;

import java.io.File;

public class HomeScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
/********************code for view pager************************/
//    private Viewpager_Adapter viewpager_adapter;
//    private ViewPager viewPager;
//    int images[] = {R.drawable.d_banner_1, R.drawable.d_banner_2, R.drawable.d_banner_3, R.drawable.d_banner_1, R.drawable.d_banner_5, R.drawable.d_banner_6, R.drawable.d_banner_2, R.drawable.d_banner_8};
//    private Handler handler;
//    private int delay = 1200; //milliseconds
//    private int page = 0;
//    Runnable runnable = new Runnable() {
//        public void run() {
//            if (viewpager_adapter.getCount() == page) {
//                page = 0;
//            } else {
//                page++;
//            }
//            viewPager.setCurrentItem(page, true);
//            handler.postDelayed(this, delay);
//        }
//    };

    /********************code for view pager************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /********************code for view pager************************/

//        handler = new Handler();
//        viewPager = (ViewPager) findViewById(R.id.bannerViewpager);
//        viewpager_adapter = new Viewpager_Adapter(this, images);
//        viewPager.setAdapter(viewpager_adapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                page = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
/********************code for view pager************************/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    /********************code for view pager************************/
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(runnable, delay);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        handler.removeCallbacks(runnable);
//    }

    /********************code for view pager************************/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            startActivity(new Intent(this, Profile.class));
        } else if (id == R.id.nav_send) {
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filePath = app.sourceDir;

            Intent intent = new Intent(Intent.ACTION_SEND);

            // MIME of .apk is "application/vnd.android.package-archive".
            // but Bluetooth does not accept this. Let's use "*/*" instead.
            intent.setType("*/*");
            // Append file and send Intent
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            startActivity(Intent.createChooser(intent, "Share app via"));
        } else if (id == R.id.nav_logout) {
            insert();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            this.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void healthfiy(View view) {
        startActivity(new Intent(this, HealthfiyActivity.class));
    }

    public void dietPlan(View view) {
        startActivity(new Intent(this, DietPlanActivity.class));
    }

    public void clickOnyoga(View view) {
        startActivity(new Intent(this, Yoga_OptionActivity.class));

    }

    public void meditation(View view) {
        startActivity(new Intent(this, MeditationActivity.class));
    }

    public void walk(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void helpline(View view) {
        startActivity(new Intent(this, HelpLineActivity.class));
    }

    public void insert() {
        SharedPreferences pref = getSharedPreferences("ActivityPREF", 0);
        SharedPreferences.Editor edt = pref.edit();
        edt.putBoolean("activity_executed", false);
        edt.commit();
    }
}

