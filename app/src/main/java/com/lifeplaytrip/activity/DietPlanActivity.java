package com.lifeplaytrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.lifeplaytrip.R;


public class DietPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void looseWeight(View view){
        startActivity(new Intent(this,LooseWeightActivity.class));
    }
    public void gainWeight(View view){
        startActivity(new Intent(this,GainWeightActivity.class));
    }
    public void healthyDiet(View view){
        startActivity(new Intent(this,HealthyDietActivity.class));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
