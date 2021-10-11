package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    TextView zero;
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView ca;
    TextView plus;
    TextView minus;
    TextView multiply;
    TextView division;
    TextView equal;
    TextView result;


    // int의 경우, 1 + 2 = 3
    // String의 경우, "1" + "2" = "12"
    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initData();
        addEventListener();
    }

    private void initData() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);

    }

    // 1. 이벤트 리스너 달기 (모든 버튼에 대한 이벤트 리스너 필요)
    private void addEventListener() {
        zero.setOnClickListener(view -> {
            Log.d("TAG", zero.getText().toString());
            newValue = newValue + "0";
            result.setText(newValue);
        });
        one.setOnClickListener(view -> {
            Log.d("TAG", one.getText().toString());
            newValue = newValue + "1";
            result.setText(newValue);
        });
        two.setOnClickListener(view -> {
            Log.d("TAG", two.getText().toString());
            newValue = newValue + "2";
            result.setText(newValue);
        });
        three.setOnClickListener(view -> {
            Log.d("TAG", three.getText().toString());
            newValue = newValue + "3";
            result.setText(newValue);
        });
        four.setOnClickListener(view -> {
            Log.d("TAG", four.getText().toString());
            newValue = newValue + "4";
            result.setText(newValue);
        });
        five.setOnClickListener(view -> {
            Log.d("TAG", five.getText().toString());
            newValue = newValue + "5";
            result.setText(newValue);
        });
        six.setOnClickListener(view -> {
            Log.d("TAG", six.getText().toString());
            newValue = newValue + "6";
            result.setText(newValue);
        });
        seven.setOnClickListener(view -> {
            Log.d("TAG", seven.getText().toString());
            newValue = newValue + "7";
            result.setText(newValue);
        });
        eight.setOnClickListener(view -> {
            Log.d("TAG", eight.getText().toString());
            newValue = newValue + "8";
            result.setText(newValue);
        });
        nine.setOnClickListener(view -> {
            Log.d("TAG", nine.getText().toString());
            newValue = newValue + "9";
            result.setText(newValue);
        });
        ca.setOnClickListener(view -> {
            Log.d("TAG", ca.getText().toString());
            newValue = "0";
            result.setText("0");
        });
        plus.setOnClickListener(view -> {
            int ov = Integer.parseInt(oldValue);
            int nv = Integer.parseInt(newValue);
            int sum = ov + nv;
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
        });
        minus.setOnClickListener(view -> {
            int n1 = 0;
            int n2 = 0;

            if(!oldValue.equals("0")){
                n1 = Integer.parseInt(oldValue);
                n2 = Integer.parseInt(newValue);

                int sum = n1 - n2;
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
            } else {
                oldValue = newValue;
                newValue = "0";
            }
        });
        multiply.setOnClickListener(view -> {
            Log.d("TAG", multiply.getText().toString());
        });
        division.setOnClickListener(view -> {
            Log.d("TAG", division.getText().toString());
        });
        equal.setOnClickListener(view -> {
            Log.d("TAG", equal.getText().toString());
        });
        result.setOnClickListener(view -> {
            Log.d("TAG", result.getText().toString());
        });

        // 2. t.result.setText(넘겨 받은 값을 세팅)


        // 3. 계산기 로직에 핵심을 생각해내야 한다. 변수 필요함.


    }


}