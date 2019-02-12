package com.example.arrayexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] names = {"Ben","Tom","Gabe","Matt","Vivian","MC-Devanir","Fissy","Tushanstan"};
    TextView tvNames, tvAmt;
    Button btnLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNames = findViewById(R.id.tvNames);
        tvAmt = (TextView) findViewById(R.id.tvAmt);
        btnLength = findViewById(R.id.btnLength);

        btnLength.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        tvNames.setText(getLongestStringInArray(names));
        tvAmt.setText(String.valueOf(getLongestStringAmt(names)));
    }

    private static String getLongestStringInArray(String[] names){
        int maxLength = 0;

        String longestString = null;
        for(String name : names){
            if (name.length() > maxLength){
                maxLength = name.length();
                longestString = name;
            }
        }
        return longestString;
    }//getLongestStringInArray

    private static int getLongestStringAmt(String[] names){
        int maxLength = 0;

        String longestString = null;
        for(String name : names){
            if (name.length() > maxLength){
                maxLength = name.length();
                longestString = name;
            }
        }

        return maxLength;
    }

}//class
