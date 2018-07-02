package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.lifeplaytrip.R;

import java.util.ArrayList;
import java.util.List;

public class Calorie_CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String gender = "";
    private Spinner spinnerHight;
    private Spinner spinnerActiveness;
    private String hightPosition;
    private String activePosition;
    private EditText age_Cal;
    private EditText weight_Cal;
    private String calorieAge;
    private String calorieWeight;
    private int calorieResult;
    private int weightInPound;
    private int hightInInch;
    private int calAge;
    private TextView resultTextView;
    private TextView calText;
    private TextView fatResult;
    private TextView proteinResult;
    private TextView carbohydrateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie__calculator);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getId();
        hight_spinnerActivity();
        active_spinnerActivity();
    }

    private void active_spinnerActivity() {
        spinnerActiveness.setPrompt("Hight");
        // Spinner click listener
        spinnerActiveness.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> active = new ArrayList<String>();
        active.add("");
        active.add("Sedentary");
        active.add("Light Active");
        active.add("Moderately Active");
        active.add("Very Active");
        active.add("Extra  Active");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterActive = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, active);

        // Drop down layout style - list view with radio button
        dataAdapterActive.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerActiveness.setAdapter(dataAdapterActive);
    }

    private void hight_spinnerActivity() {
        spinnerHight.setPrompt("Hight");
        // Spinner click listener
        spinnerHight.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> hight = new ArrayList<String>();
        hight.add("");
        hight.add("4ft 0in / 122cm");
        hight.add("4ft 1in / 124cm");
        hight.add("4ft 2in / 127cm");
        hight.add("4ft 3in / 130cm");
        hight.add("4ft 4in/ 132cm");
        hight.add("4ft 5in / 135cm");
        hight.add("4ft 6in / 137cm");
        hight.add("4ft 7in / 140cm");
        hight.add("4ft 8in / 142cm");
        hight.add("4ft 9in / 145cm");
        hight.add("4ft 10in / 147cm");
        hight.add("4ft 11in / 150cm");
        hight.add("5ft 0in / 152cm");
        hight.add("5ft 1in / 155cm");
        hight.add("5ft 2in / 157cm");
        hight.add("5ft 3in / 160cm");
        hight.add("5ft 4in / 163cm");
        hight.add("5ft 5in / 165cm");
        hight.add("5ft 6in / 168cm");
        hight.add("5ft 7in / 170cm");
        hight.add("5ft 8in / 173cm");
        hight.add("5ft 9in / 175cm");
        hight.add("5ft 10in / 178cm");
        hight.add("5ft 11in / 180cm");
        hight.add("6ft 0in / 183cm");
        hight.add("6ft 1in / 185cm");
        hight.add("6ft 2in / 188cm");
        hight.add("6ft 3in / 191cm");
        hight.add("6ft 4in / 193cm");
        hight.add("6ft 5in / 196cm");
        hight.add("6ft 6in / 198cm");
        hight.add("6ft 6in / 198cm");
        hight.add("6ft 7in / 201cm");
        hight.add("6ft 8in / 203cm");
        hight.add("6ft 9in / 206cm");
        hight.add("6ft 10in / 208cm");
        hight.add("6ft 11in / 211cm");
        hight.add("7ft 0in / 213cm");
        hight.add("7ft 1in / 216cm");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hight);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerHight.setAdapter(dataAdapter);

    }

    private void getId() {
        spinnerHight = (Spinner) findViewById(R.id.hightSpinner);
        spinnerActiveness = (Spinner) findViewById(R.id.activenessSpinner);
        age_Cal = (EditText) findViewById(R.id.age);
        weight_Cal = (EditText) findViewById(R.id.cal_Weight);
        resultTextView = (TextView) findViewById(R.id.calorieResult);
        calText = (TextView) findViewById(R.id.calText);
        fatResult = (TextView) findViewById(R.id.fatResult);
        proteinResult = (TextView) findViewById(R.id.proteinResult);
        carbohydrateResult = (TextView) findViewById(R.id.carbohydrateResult);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        if (parent == spinnerHight) {

            hightPosition = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), "HightSelected: " + hightPosition, Toast.LENGTH_LONG).show();

        }
        if (parent == spinnerActiveness) {
            activePosition = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), "ActiveSelected: " + hightPosition, Toast.LENGTH_LONG).show();

        }

        // Showing selected spinner item
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.cal_radio0:
                if (checked)
                    Log.d("Male_CLick", "male click");
                gender = "male";

                break;
            case R.id.cal_radio1:
                if (checked)
                    Log.d("feMale_CLick", "female click");
                gender = "female";
                break;
        }
    }

    public void caloriecalculaor(View view) {
        boolean isExecuteNext = true;
        calorieAge = age_Cal.getText().toString();
        calorieWeight = weight_Cal.getText().toString();

        if (calorieAge.isEmpty()) {
            Log.d("hightString", calorieAge);
            age_Cal.setError(getResources().getString(R.string.age_error));
            isExecuteNext = false;
        }
        if (gender.isEmpty()) {
            Log.d("gender", gender);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.gender_error), Toast.LENGTH_SHORT).show();
            isExecuteNext = false;
        }
        if (hightPosition.isEmpty()) {
            Log.d("hightString", hightPosition);
            Toast.makeText(this, "Please Enter hight", Toast.LENGTH_SHORT).show();
            isExecuteNext = false;
        }
        if (calorieWeight.isEmpty()) {
            Log.d("hightString", calorieWeight);
            weight_Cal.setError(getResources().getString(R.string.weight_error));
            isExecuteNext = false;
        }
        if (activePosition.isEmpty()) {
            Log.d("hightString", activePosition);
            Toast.makeText(this, "Please Enter Activeness", Toast.LENGTH_SHORT).show();
            isExecuteNext = false;
        }

        if (!isExecuteNext) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_fill_all_required_field), Toast.LENGTH_SHORT).show();
            return;
        } else {

            hightPosition = hightPosition.substring(hightPosition.indexOf("/") + 1).trim().replace("cm", "");
            hightInInch = Integer.parseInt(hightPosition);
            weightInPound = Integer.parseInt(calorieWeight);
            calAge = Integer.parseInt(calorieAge);

            Log.d("hightPosition", hightPosition);
            Log.d("hightInInch", hightInInch + "");
            Log.d("calorieWeight", calorieWeight);
            Log.d("weightInPound", weightInPound + "");
            Log.d("calorieAge", calorieAge);
            Log.d("calAge", calAge + "");


            if (gender == "male") {
                Log.d("male", "male");

                calorieResult = (int) (66 + (13.7 * weightInPound) + (5 * hightInInch) - (6.8 * calAge));

            }
            if (gender == "female") {
                Log.d("female", "female");

                calorieResult = (int) (655 + (9.6 * weightInPound) + (1.8 * hightInInch) - (4.7 * calAge));

            }


            if (activePosition == "Sedentary") {
                calorieResult = (int) (calorieResult * 1.2);
            }
            if (activePosition == "Light Active") {
                calorieResult = (int) (calorieResult * 1.375);

            }

            if (activePosition == "Moderately Active") {
                calorieResult = (int) (calorieResult * 1.53);

            }
            if (activePosition == "Very Active") {
                calorieResult = (int) (calorieResult * 1.725);

            }
            if (activePosition == "Extra  Active") {
                calorieResult = (int) (calorieResult * 1.9);

            }
            int fat = (int) (calorieResult * 0.25 / 9);
            int protein = (int) (calorieResult * 0.25 / 4);
            int carbohydrate = (int) (calorieResult * 0.25 / 4);

            calText.setText("Calorie Need By You\t\n");
            resultTextView.setText(calorieResult + "  " + "grams per day");
            fatResult.setText(fat + "  " + "grams per day");
            proteinResult.setText(protein + "  " + "grams per day");
            carbohydrateResult.setText(carbohydrate + "  " + "grams per day");

            Log.d("calorieResult", calorieResult + "");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


}
