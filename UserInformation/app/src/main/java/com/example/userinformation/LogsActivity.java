package com.example.userinformation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class LogsActivity extends AppCompatActivity {


    private TextView tvName;
    private TextView tvAge;
    private TextView tvEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvEmail = findViewById(R.id.tvEmail);


        tvName.setText(readFilesFromLog()); //for Name
        tvAge.setText(readAgeFromPreferences());
        readFromPreferencesFile(); //for Email
    }

    private void readFromPreferencesFile(){
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        tvEmail.setText(email); //setting email value in tvEmail
    }

    private String readFilesFromLog(){
        File file = new File(getFilesDir(), "NameLogs.txt");
        int size =(int) file.length();
        byte[] contents = new byte[size];


        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(contents);
        } catch (IOException e) {
            e.printStackTrace();
        } ;

        return new String (contents);
    }// readFilesFromLog

    private String readAgeFromPreferences(){

        Intent intent = getIntent();
        String age = getIntent().getStringExtra("Age");

        return age;
    }
}
