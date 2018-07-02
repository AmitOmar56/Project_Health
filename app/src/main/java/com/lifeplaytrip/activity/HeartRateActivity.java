package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lifeplaytrip.R;


public class HeartRateActivity extends AppCompatActivity {

    private EditText heart_Age;
    RadioGroup radioGroup;
    private String gender = "";
    private String heartAge;
    private int heartResult;
    private TextView maxHeart;
    private TextView recommHeart;
    private int targetRange_min;
    private int getTargetRange_max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        heart_Age = (EditText) findViewById(R.id.heart_age);
        maxHeart = (TextView) findViewById(R.id.maxHeartRate);
        recommHeart = (TextView) findViewById(R.id.recommHeartRate);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio0:
                if (checked)
                    Log.d("Male_CLick", "male click");
                gender = "male";

                break;
            case R.id.radio1:
                if (checked)
                    Log.d("feMale_CLick", "female click");
                gender = "female";
                break;
        }
    }

    public void heartButton(View view) {
        boolean isExecuteNext = true;
        heartAge = heart_Age.getText().toString();

        if (heartAge.isEmpty()) {
            Log.d("hightString", heartAge);
            heart_Age.setError(getResources().getString(R.string.age_error));
            isExecuteNext = false;
        }
        if (gender.isEmpty()) {
            Log.d("gender", gender);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.gender_error), Toast.LENGTH_SHORT).show();
            isExecuteNext = false;
        }
        if (!isExecuteNext) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_fill_all_required_field), Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (gender == "male") {
                heartResult = 220 - Integer.parseInt(heartAge);
                Log.d("heartResult", heartResult + "");
//                Toast.makeText(getApplicationContext(),heartResult, Toast.LENGTH_SHORT).show();

            }
            if (gender == "female") {
                heartResult = 226 - Integer.parseInt(heartAge);
                Log.d("heartResult", heartResult + "");
            }
            targetRange_min= (int) (heartResult*.6);
            getTargetRange_max= (int) (heartResult*.9);

            maxHeart.setText(heartResult + "(beats per minute)");
            recommHeart.setText(targetRange_min+" "+"to"+getTargetRange_max+"(beats per minute)");
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
