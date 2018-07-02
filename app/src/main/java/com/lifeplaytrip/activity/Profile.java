package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.lifeplaytrip.R;

import static com.lifeplaytrip.activity.LoginActivity.name;
import static com.lifeplaytrip.activity.LoginActivity.phone;


public class Profile extends AppCompatActivity {
    private TextView pname, pphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pname = (TextView) findViewById(R.id.pname);
        pphone = (TextView) findViewById(R.id.pphone);
        pname.setText(name);
        pphone.setText(phone);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
