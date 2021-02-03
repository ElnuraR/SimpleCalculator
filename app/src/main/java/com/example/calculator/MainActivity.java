package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double first;
    double second;
    double result;

    String selectedOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // show result of operation in new Activity
    public void showResult(View view) {
        if (submitFirstNumber() && submitSecondNumber()) {
            calculate(view);

            Intent intent = new Intent(this, OutputActivity.class);
            intent.putExtra("result", result);
            intent.putExtra("first", first);
            intent.putExtra("second", second);
            intent.putExtra("operation", selectedOperation);
            startActivity(intent);
        }
    }

    // initialize first number
    public boolean submitFirstNumber() {
        EditText firstNumberText = findViewById(R.id.number_one);
        String firstNumber = firstNumberText.getText().toString();

        if(!firstNumber.isEmpty()) {
            try {
                first = Double.parseDouble(firstNumber);
                // it means it is double
                return true;
            } catch (Exception ex) {
                // this means it is not double
                ex.printStackTrace();
            }
        }
        else {
            Toast.makeText(this, "Field can not be empty", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    // initialize second number
    public boolean submitSecondNumber() {
        EditText secondNumberText = findViewById(R.id.number_two);
        String secondNumber = secondNumberText.getText().toString();

        if(!secondNumber.isEmpty()) {
            try {
                second = Double.parseDouble(secondNumber);
                // it means it is double
                return true;
            } catch (Exception ex) {
                // this means it is not double
                ex.printStackTrace();
            }
        }
        else {
            Toast.makeText(this, "Field can not be empty", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void add(View view) {
        result = first + second;
        selectedOperation = "+";
    }

    public void substract(View view) {
        result = first - second;
        selectedOperation = "-";
    }

    public void divide(View view) {
        result = first / second;
        selectedOperation = "÷";
    }

    public void multiply(View view) {
        result = first * second;
        selectedOperation = "×";
    }

    public void calculate(View view) {
        switch (selectedOperation) {
            case "+":
                add(view);
                break;
            case "-":
                substract(view);
                break;
            case "÷":
                divide(view);
                break;
            case "×":
                multiply(view);
                break;

            default:
                Toast.makeText(this, "Choose the operation", Toast.LENGTH_SHORT).show();
        }
    }
}