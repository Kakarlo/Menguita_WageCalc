package com.example.menguita_wagecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Output extends AppCompatActivity {

    TextView nameWage, regularHours, regularWage, overtimeHours, overtimeWage, total;
    int regular, overtime, totalWage, maxReg = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        //TextView
        nameWage = findViewById(R.id.nameWage);
        regularHours = findViewById(R.id.regularHours);
        regularWage = findViewById(R.id.regularWage);
        overtimeHours = findViewById(R.id.overtimeHours);
        overtimeWage = findViewById(R.id.overtimeWage);
        total = findViewById(R.id.total);

        //getting the data from the activity
        Intent intent= getIntent();
        String name=intent.getStringExtra("name");
        int hours=intent.getIntExtra("hours",0);
        String type=intent.getStringExtra("type");

        solve(name, hours, type);
    }

    private void solve(String name, int hours, String type){
        nameWage.setText(name + "'s Wage");
        if(hours <= maxReg){
            //Regular Hours
            switch (type){
                case "Regular":
                    regular = hours * 100;
                    break;
                case "Probationary":
                    regular = hours * 90;
                    break;
                case "Part-time":
                    regular = hours * 75;
                    break;
            }
            regularHours.setText(String.valueOf(hours));
            regularWage.setText(String.valueOf(regular));
            total.setText(String.valueOf(regular));
        } else {
            //With Overtime
            regularHours.setText(String.valueOf(maxReg));
            switch (type){
                case "Regular":
                    regular = maxReg * 100;
                    overtime = (hours - maxReg) * 115;
                    totalWage = regular + overtime;
                    break;
                case "Probationary":
                    regular = maxReg * 90;
                    overtime = (hours - maxReg) * 100;
                    totalWage = regular + overtime;
                    break;
                case "Part-time":
                    regular = maxReg * 75;
                    overtime = (hours - maxReg) * 90;
                    totalWage = regular + overtime;
                    break;
            }
            regularWage.setText(String.valueOf(regular));
            overtimeHours.setText(String.valueOf(hours - maxReg));
            overtimeWage.setText(String.valueOf(overtime));
            total.setText(String.valueOf(totalWage));
        }
    }
}
