package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTimeToSaveForRobot();
            }
        });
    }

    private void calculateTimeToSaveForRobot() {
        int costOfRobot = 35000;
        int savings = 700;
        int monthlyAllowance = 1700;
        double annualInterestRate = 0.09;

        double totalSavings = savings;
        int months = 0;

        while (totalSavings < costOfRobot) {
            totalSavings += monthlyAllowance;
            totalSavings *= (1 + annualInterestRate / 12); // Учитываем проценты за месяц
            months++;
        }

        int years = months / 12;
        int remainingMonths = months % 12;

        String result = "Для накопления на робота потребуется " + years + " лет и " + remainingMonths + " месяцев";
        textViewResult.setText(result);
    }
}
