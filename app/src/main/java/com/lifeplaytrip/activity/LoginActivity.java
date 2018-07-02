package com.lifeplaytrip.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {
    private TextView textView;
    private EditText userPass, userName;
    private String uName, uPass;
    private TextView incorrectid;
    static String name;
    static String phone;
    private String lname;
    private String lphone;
    private String p_name;
    private String p_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        textView = (TextView) this.findViewById(R.id.welcome_note);
        userName = (EditText) findViewById(R.id.userName);
        userPass = (EditText) findViewById(R.id.userPass);
        incorrectid = (TextView) findViewById(R.id.lincorrectid);
        name = p_name;
        phone = p_phone;

    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void login(View view) {
        boolean isExecuteNext = true;
        uName = userName.getText().toString();
        uPass = userPass.getText().toString();

        if (uName.isEmpty()) {
            Log.d("name", uName + "");
            userName.setError(getResources().getString(R.string.name_error));
            isExecuteNext = false;
        }

        if (uPass.isEmpty()) {
            Log.d("password", uPass + "");
            userPass.setError(getResources().getString(R.string.password_error));
            isExecuteNext = false;
        }
        if (!isExecuteNext) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_fill_all_required_field), Toast.LENGTH_SHORT).show();
            return;
        } else {
            MyProgressDialog.showPDialog(this);
            Log.d("uName", uName);
            Log.d("uPass", uPass);
            signupRequest(uName, uPass);

        }

//        startActivity(new Intent(this, HomeScreenActivity.class));

    }

    private void signupRequest(String uName, final String uPass) {
        Log.d("uName", uName);
        Log.d("uPass", uPass);
        RequestQueue queue = Volley.newRequestQueue(this);
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, "http://g1go.in/ApiG1GoPro.ashx?" + "uid=" + uName + "&" + "pwd=" + uPass + "&" + "utype=M",
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("amit", response);
                        Object json = null;
                        try {
                            json = new JSONTokener(response).nextValue();
                            Log.d("json", json + "");
                            JSONArray jsonArray = (JSONArray) json;
                            Log.d("jsonArray", jsonArray + "");

                            if (jsonArray.length() == 0) {
                                MyProgressDialog.hidePDialog();
                                incorrectid.setText("IncorrectId or Password");
                                Log.d("incorrect", "incurrect");
                            } else {

                                JSONObject profile = jsonArray.getJSONObject(0);
                                lname = profile.getString("fname");
                                lphone = profile.getString("mob");
                                name = lname;
                                phone = lphone;
                                insert();
                                MyProgressDialog.hidePDialog();
                                startActivity(new Intent(LoginActivity.this, HomeScreenActivity.class));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        MyProgressDialog.hidePDialog();
                    }
                }
        );
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }

    public void insert() {
        SharedPreferences pref = getSharedPreferences("ActivityPREF", 0);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("name", lname);
        edt.putString("phone", lphone);
        edt.putBoolean("activity_executed", true);
        edt.commit();
    }
}
