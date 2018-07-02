package com.lifeplaytrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.lifeplaytrip.R;


public class HealthfiyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthfiy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void bmiCal(View view) {
        startActivity(new Intent(this, BMI_CalculatorActivity.class));
    }

    public void heartCal(View view) {
        startActivity(new Intent(this, HeartRateActivity.class));
    }

    public void calorieCal(View view) {
        startActivity(new Intent(this, Calorie_CalculatorActivity.class));
    }

    public void pregnancy(View view) {
        startActivity(new Intent(this, DueDateCalculatorActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
