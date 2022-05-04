package com.example.menguita_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainMenu extends AppCompatActivity {

    EditText personName, hours;
    Spinner jobType;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        //EditText
        personName = findViewById(R.id.personName);
        hours = findViewById(R.id.hours);

        //Spinner
        jobType = findViewById(R.id.jobType);

        //Button
        calculate = findViewById(R.id.calculate);

        //Assign array to spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.job_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobType.setAdapter(adapter);

        //Onclick
        calculate.setOnClickListener(v -> {
            Intent input = new Intent(this, Output.class);
            try{
                input.putExtra("name", String.valueOf(personName.getText()));
                input.putExtra("hours", Integer.parseInt(String.valueOf(hours.getText())));
                input.putExtra("type", String.valueOf(jobType.getSelectedItem()));
                startActivity(input);
            }catch (Exception e) {
                personName.setText("");
                hours.setText("");
            }
        });
    }

}