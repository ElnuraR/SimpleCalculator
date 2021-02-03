package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        // Get the Intent that started this activity and extract the string
        Intent intent = this.getIntent();

        Double result = intent.getDoubleExtra("result", 0);
        String showResult = result.toString();

        Double firstNumber = intent.getDoubleExtra("first", 0);
        String first = firstNumber.toString();

        Double secondNumber = intent.getDoubleExtra("second", 0);
        String second = secondNumber.toString();

        String operation = intent.getStringExtra("operation");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(first + " " + operation + " " + second + " = " + showResult);
    }
}
