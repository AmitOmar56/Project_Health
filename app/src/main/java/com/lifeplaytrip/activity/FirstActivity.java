package com.lifeplaytrip.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lifeplaytrip.R;

import static com.lifeplaytrip.activity.LoginActivity.name;
import static com.lifeplaytrip.activity.LoginActivity.phone;


public class FirstActivity extends AppCompatActivity {

    private String fname;
    private String fphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", 0);
        if (pref.getBoolean("activity_executed", false)) {
            name = pref.getString("name", null);
            phone = pref.getString("phone", null);
            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
