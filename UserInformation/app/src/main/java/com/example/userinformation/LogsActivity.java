package com.example.userinformation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class LogsActivity extends AppCompatActivity {


    private EditText etEmail;

    private TextView tvEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        tvEmail = findViewById(R.id.tvResult);
        readFromPreferencesFile();
    }

    private void readFromPreferencesFile(){
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        tvEmail.setText(email); //setting email value in tvEmail
    }
}
