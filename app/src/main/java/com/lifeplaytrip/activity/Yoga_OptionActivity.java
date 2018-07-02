package com.lifeplaytrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.lifeplaytrip.R;


public class Yoga_OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga__option);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void yHindi(View view){
        startActivity(new Intent(this,Yoga_HindiActivity.class));
    }
    public void yEnglish(View view){
        startActivity(new Intent(this,YogaActivity.class));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
