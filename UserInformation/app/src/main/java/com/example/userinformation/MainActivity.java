package com.example.userinformation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCounter;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etAge;
    private EditText etEmail;

    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

    }//oncreate



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                showUserInformation();
                handleSetEmail();
                inputToFile();
                break;
        }
    }

    private void showUserInformation(){
        Intent intent = new Intent(this, LogsActivity.class);
        String age = etAge.getText().toString();
        intent.putExtra("Age", age);
        startActivity(intent);



    }//showUserInformation


    private void handleSetEmail(){

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE); //getting instance of SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit(); //interface used for modifying values in a SharedPreferences object.

        editor.putString("email", etEmail.getText().toString()); //sets string value in the Preferences folder/editor
        editor.apply(); //apply allows the code to be executed when the system is finished with whatever it is doing.

        //String email = sharedPreferences.getString("email", "");

    }// created an instance of sharedPreferences, and gets

    private void inputToFile(){
        File file = new File(getFilesDir(), "NameLogs.txt"); // creates a new file directory

        try(FileOutputStream fileOutputStream = openFileOutput("NameLogs.txt", Context.MODE_PRIVATE);){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(etFirstName.getText());
            stringBuilder.append(" ");
            stringBuilder.append(etLastName.getText());

            fileOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }//inputToFile
}//MainActivity
