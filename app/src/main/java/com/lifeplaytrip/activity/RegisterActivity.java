package com.lifeplaytrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lifeplaytrip.R;
import com.lifeplaytrip.adapter.MyProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class RegisterActivity extends AppCompatActivity {

    private EditText rName;
    private EditText rPhone;
    private EditText rPass;
    private EditText last_name;
    private String name, l_name, phone, pass;
    private TextView incorrectid;
    private LinearLayout succussLay, regLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rName = (EditText) findViewById(R.id.input_name);
        rPhone = (EditText) findViewById(R.id.phone);
        rPass = (EditText) findViewById(R.id.input_password);
        incorrectid = (TextView) findViewById(R.id.incorrectid);
        last_name = (EditText) findViewById(R.id.last_name);
        regLay = (LinearLayout) findViewById(R.id.regLay);
        succussLay = (LinearLayout) findViewById(R.id.succussLay);

    }

    public void createAccount(View view) {
//        startActivity(new Intent(this, HomeScreenActivity.class));
        boolean isExecuteNext = true;
        name = rName.getText().toString().trim();
        pass = rPass.getText().toString().trim();
        phone = rPhone.getText().toString().trim();
        l_name = last_name.getText().toString().trim();
        Log.d("name", name);
        Log.d("pass", pass);
        Log.d("phone", phone);
        Log.d("l_name", l_name);


        if (name.isEmpty()) {
            Log.d("name", name + "");
            rName.setError(getResources().getString(R.string.name_error));
            isExecuteNext = false;
        }
        if (l_name.isEmpty()) {
            Log.d("name", l_name + "");
            last_name.setError(getResources().getString(R.string.name_error));
            isExecuteNext = false;
        }

        if (phone.isEmpty()) {
            rPhone.setError(getResources().getString(R.string.Phone_error));
            isExecuteNext = false;
        } else if (phone.length() < 10) {
            rPhone.setError(getResources().getString(R.string.Phone_length_validation));
            isExecuteNext = false;
        }
        if (pass.isEmpty()) {
            Log.d("password", pass + "");
            rPass.setError(getResources().getString(R.string.password_error));
            isExecuteNext = false;
        }

        if (!isExecuteNext) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_fill_all_required_field), Toast.LENGTH_SHORT).show();
            return;
        } else {
            MyProgressDialog.showPDialog(this);
            signupRequest(name, phone, pass, l_name);

        }


    }

    private void signupRequest(String name, final String phone, final String pass, final String l_name) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, "http://g1go.in/ApiG1GORegn.ashx?" + "fname=" + name + "&" + "lname=" + l_name + "&" + "mob=" + phone + "&" + "pwd=" + pass,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("amit", response);
                        Object json = null;
                        try {
                            json = new JSONTokener(response).nextValue();
                            JSONArray jsonArray = (JSONArray) json;
                            JSONObject profile = jsonArray.getJSONObject(0);
                            String status = profile.getString("Msg");

                            Log.d("status", status + "");
                            Log.d("profile", profile + "");

                            if (status.equals("Registered Successfully")) {
                                incorrectid.setText("");
                                rName.setText("");
                                rPass.setText("");
                                rPhone.setText("");
                                last_name.setText("");
                                succussLay.setVisibility(View.VISIBLE);
                                regLay.setVisibility(View.GONE);
                                Snackbar snackbar = Snackbar.make(RegisterActivity.this.getWindow().getDecorView().getRootView(), "Successfully Registered", Snackbar.LENGTH_LONG);
                                snackbar.show();
                                MyProgressDialog.hidePDialog();

                            } else {
                                rPhone.setError(status);
                                incorrectid.setText(status);
                                MyProgressDialog.hidePDialog();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error + "", Toast.LENGTH_LONG).show();
                        MyProgressDialog.hidePDialog();
                    }
                }
        );
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }

    public void gotologin(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

    }

}
