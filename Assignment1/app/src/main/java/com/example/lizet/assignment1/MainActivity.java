package com.example.lizet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText powerFor2 = (EditText) findViewById(R.id.powerFor2);
        powerFor2.setText("0");
        final Button buttonEqual2 = (Button) findViewById(R.id.buttonEqual2);
        final TextView answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText("1.00");

        final EditText powerFor3 = (EditText) findViewById(R.id.powerFor3);
        powerFor3.setText("0");
        final Button buttonEqual3 = (Button) findViewById(R.id.buttonEqual3);
        final TextView answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText("1.00");

        final EditText powerFor4 = (EditText) findViewById(R.id.powerFor4);
        powerFor4.setText("0");
        final Button buttonEqual4 = (Button) findViewById(R.id.buttonEqual4);
        final TextView answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText("1.00");

        final EditText powerFor5 = (EditText) findViewById(R.id.powerFor5);
        powerFor5.setText("0");
        final Button buttonEqual5 = (Button) findViewById(R.id.buttonEqual5);
        final TextView answer5 = (TextView) findViewById(R.id.answer5);
        answer5.setText("1.00");


        buttonEqual2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String x = powerFor2.getText().toString();
                double y = Double.parseDouble(x);
                double ans = Math.pow(2, y);
                String z = String.format("%.2f",ans);
                answer2.setText(z);
            }
        });

        buttonEqual3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String x = powerFor3.getText().toString();
                double y = Double.parseDouble(x);
                double ans = Math.pow(3, y);
                String z = String.format("%.2f",ans);
                answer3.setText(z);
            }
        });

        buttonEqual4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String x = powerFor4.getText().toString();
                double y = Double.parseDouble(x);
                double ans = Math.pow(4, y);
                String z = String.format("%.2f",ans);
                answer4.setText(z);
            }
        });

        buttonEqual5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String x = powerFor5.getText().toString();
                double y = Double.parseDouble(x);
                double ans = Math.pow(5, y);
                String z = String.format("%.2f",ans);
                answer5.setText(z);
            }
        });


    }
}