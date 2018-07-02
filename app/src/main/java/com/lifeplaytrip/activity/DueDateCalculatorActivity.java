package com.lifeplaytrip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.lifeplaytrip.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DueDateCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerDay;
    private Spinner spinnerMonth;
    private Spinner spinnerYear;
    private String dayposition;
    private String monthposition;
    private String yearposition;
    private TextView duedate;
    private TextView firsttridate;
    private TextView secondtridate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due_date_calculator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIds();
        day_spinnerActivity();
        month_spinnerActivity();
        year_spinnerActivity();
    }

    private void getIds() {
        spinnerDay = (Spinner) findViewById(R.id.daySpinner);
        spinnerMonth = (Spinner) findViewById(R.id.monthSpinner);
        spinnerYear = (Spinner) findViewById(R.id.yearSpinner);
        duedate = (TextView) findViewById(R.id.duedate);
        firsttridate = (TextView) findViewById(R.id.firsttridate);
        secondtridate = (TextView) findViewById(R.id.secondtridate);
    }


    private void day_spinnerActivity() {
        spinnerDay.setPrompt("Day");
        // Spinner click listener
        spinnerDay.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> day = new ArrayList<String>();
        day.add("01");
        day.add("02");
        day.add("03");
        day.add("04");
        day.add("05");
        day.add("06");
        day.add("07");
        day.add("08");
        day.add("09");
        day.add("10");
        day.add("11");
        day.add("12");
        day.add("13");
        day.add("14");
        day.add("15");
        day.add("16");
        day.add("17");
        day.add("18");
        day.add("19");
        day.add("20");
        day.add("21");
        day.add("22");
        day.add("23");
        day.add("24");
        day.add("25");
        day.add("26");
        day.add("27");
        day.add("28");
        day.add("29");
        day.add("30");
        day.add("31");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterActive = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, day);

        // Drop down layout style - list view with radio button
        dataAdapterActive.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerDay.setAdapter(dataAdapterActive);
    }

    private void month_spinnerActivity() {
        spinnerMonth.setPrompt("Day");
        // Spinner click listener
        spinnerMonth.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> month = new ArrayList<String>();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdaptermonth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, month);

        // Drop down layout style - list view with radio button
        dataAdaptermonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerMonth.setAdapter(dataAdaptermonth);
    }

    private void year_spinnerActivity() {
        spinnerYear.setPrompt("Day");
        // Spinner click listener
        spinnerYear.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> year = new ArrayList<String>();
        year.add("1999");
        year.add("2000");
        year.add("2001");
        year.add("2002");
        year.add("2003");
        year.add("2004");
        year.add("2005");
        year.add("2006");
        year.add("2007");
        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");
        year.add("2018");
        year.add("2019");
        year.add("2010");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapteryear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year);

        // Drop down layout style - list view with radio button
        dataAdapteryear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerYear.setAdapter(dataAdapteryear);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == spinnerDay) {

            dayposition = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), "HightSelected: " + dayposition, Toast.LENGTH_LONG).show();

        }
        if (parent == spinnerMonth) {
            monthposition = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), "ActiveSelected: " + monthposition, Toast.LENGTH_LONG).show();

        }
        if (parent == spinnerYear) {
            yearposition = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), "ActiveSelected: " + yearposition, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void dueDate(View view) {

        if (monthposition == "January") {
            monthposition = "01";
        }
        if (monthposition == "February") {
            monthposition = "02";
        }
        if (monthposition == "March") {
            monthposition = "03";
        }
        if (monthposition == "April") {
            monthposition = "04";
        }
        if (monthposition == "May") {
            monthposition = "05";
        }
        if (monthposition == "June") {
            monthposition = "06";
        }
        if (monthposition == "July") {
            monthposition = "07";
        }
        if (monthposition == "August") {
            monthposition = "08";
        }
        if (monthposition == "September") {
            monthposition = "09";
        }
        if (monthposition == "October") {
            monthposition = "10";
        }
        if (monthposition == "November") {
            monthposition = "11";
        }
        if (monthposition == "December") {
            monthposition = "12";
        }

        String givenDate = dayposition + "/" + monthposition + "/" + yearposition;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // here set the pattern as you date in string was containing like date/month/year
        try {
            Date d = sdf.parse(givenDate);
            c.setTime(d);
            c.add(Calendar.DATE, 280);
            String output = sdf.format(c.getTime());
            c.setTime(d);
            c.add(Calendar.DATE, 84);
            String output2 = sdf.format(c.getTime());
            c.setTime(d);
            c.add(Calendar.DATE, 189);
            String output3 = sdf.format(c.getTime());

            duedate.setText(output);
            firsttridate.setText(output2);
            secondtridate.setText(output3);

//            Toast.makeText(this, output, Toast.LENGTH_LONG).show();
            Log.d("date", output);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
