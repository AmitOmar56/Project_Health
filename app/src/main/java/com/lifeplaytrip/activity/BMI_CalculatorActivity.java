package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.lifeplaytrip.R;

import java.util.ArrayList;
import java.util.List;

public class BMI_CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText weight;
    private String weightString;
    private String hightString;
    private String item;
    private Spinner spinner;
    private TextView result;
    private TextView bmiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calculator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        result = (TextView) findViewById(R.id.bmiresult);
        weight = (EditText) findViewById(R.id.weight);
        bmiText = (TextView) findViewById(R.id.bmitext);
        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setPrompt("Hight");
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

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
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void bmicalculaor(View view) {
        boolean isExecuteNext = true;
        weightString = weight.getText().toString();
        hightString = item.substring(item.indexOf("/") + 1).trim().replace("cm", "");


        if (weightString.isEmpty()) {
            Log.d("weightString", weightString);
            weight.setError(getResources().getString(R.string.weight_error));
            isExecuteNext = false;
        }
        if (item.isEmpty()) {
            Log.d("hightString", item);
            Toast.makeText(this, "Please Enter hight", Toast.LENGTH_SHORT).show();
            isExecuteNext = false;
        }
        if (!isExecuteNext) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_fill_all_required_field), Toast.LENGTH_SHORT).show();
            return;
        } else {

            int high = Integer.parseInt(hightString) * Integer.parseInt(hightString);
            int weigh = Integer.parseInt(weightString) * 100 * 100;

            float bMi = weigh / high;

            result.setText("Your BMI is :" + bMi + "");

            if (bMi < 18.5) {
                bmiText.setText(" Your BMI is below normal, its suggested to consult a Nutritionist");
            }
            if (bMi > 18.5 && bMi < 24.9) {
                bmiText.setText("Wow! Your weight is ideal for your height. You have maintained yourself nicely. Stay that way.\n");
            }
            if (bMi > 25 && bMi < 29.9) {
                bmiText.setText("It is more than normal. You are overweight.\n");
            }
            if (bMi > 30 && bMi < 34.5) {
                bmiText.setText("You are in obese weight range. You are suggested to take nutritional consultation.");
            }
            if (bMi > 35 && bMi < 39.9) {
                bmiText.setText(" You are in obese weight range. You are suggested to take nutritional consultation.\n");
            }
            if (bMi > 40) {
                bmiText.setText(" You are morbidly obese. You should rush to a doctor.\n");
            }
            Toast.makeText(this, "Succesfully Calculate bMi" + bMi, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
