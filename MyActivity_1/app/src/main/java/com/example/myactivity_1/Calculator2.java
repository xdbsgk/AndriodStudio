package com.example.myactivity_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator2 extends AppCompatActivity {

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
    TextView divide;
    TextView equals;
    TextView result;
    // new --> old (newValue + oldValue)
    String newValue = "0";
    String oldValue = "0";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);

        initData();
        addEventListener();

    }


    private String removeZero() {
        /* "ABCDEFG" => 0, 1, 2, 3, 4, 5 번째 각 인덱스 가짐. substring -> 문자열을 자를 때 사용한다.*/
        if (newValue.length() > 15) {
            newValue = newValue.substring(0, 15);   /* 0번째부터 15째까지 자리 이후에는 잘라라. 화면 표시 x. */
        }
        return Long.parseLong(newValue) + "";
    }

    private void checkDataType() {
        // 5.0 이라는 값이 oldvalue 일 경우 마지막을 버린다 !
        String checkType = oldValue.substring(oldValue.length() - 2);
        if (checkType.equals(".0")) {
            oldValue = oldValue.substring(0, oldValue.length() - 2);
        }
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
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        result = findViewById(R.id.result);
    }

    private void addEventListener() {
        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(newValue);
        });
        one.setOnClickListener(view -> {
            newValue = newValue + "1";
            result.setText(removeZero());
        });
        two.setOnClickListener(view -> {
            newValue = newValue + "2";
            result.setText(removeZero());
        });
        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(removeZero());
        });
        four.setOnClickListener(view -> {
            newValue = newValue + "4";
            result.setText(removeZero());
        });
        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(removeZero());
        });
        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(removeZero());
        });
        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(removeZero());
        });
        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(removeZero());
        });
        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(removeZero());
        });
        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            operator = "";
            result.setText(removeZero());
        });
        plus.setOnClickListener(view -> {
            calPlus();
        });
        minus.setOnClickListener(view -> {
            calMinus();
        });
        multiply.setOnClickListener(view -> {
            calMultiply();
        });
        divide.setOnClickListener(view -> {
            calDivide();
        });
        equals.setOnClickListener(view -> {
            if (operator.equals("+")) {
                calPlus();
            } else if (operator.equals("-")) {
                calMinus();
            } else if (operator.equals("*")) {
                calMultiply();
            } else if (operator.equals("/")) {
                calDivide();
            }
        });
    }

    // 메서드 만들기 (ctrl + alt + m)
    // shift + F6 -> 이름바꾸기

    private void calDivide() {
        operator = "/";
        if (oldValue.equals("0")) {
            oldValue = newValue;
            newValue = "0";
        } else if (newValue.equals("00")) {
            result.setText("0으로 나눌 수 없습니다.");
            oldValue = "0";
            newValue = "0";
            return;
        } else if (!newValue.equals("0")) {
            double number1 = Double.parseDouble(oldValue);
            double number2 = Double.parseDouble(newValue);
            Double sum = (number1 / number2);
            oldValue = String.valueOf(sum);

            checkDataType();
            result.setText(oldValue);
        }
    }

    private void calMultiply() {
        operator = "*";
        if (oldValue.equals("0")) {
            oldValue = newValue;
            newValue = "0";
        } else {
            double number1 = Double.parseDouble(oldValue);
            double number2 = Double.parseDouble(newValue);
            double sum = (number1 * number2);
            oldValue = String.valueOf(sum);
            result.setText(oldValue);
        }
    }

    private void calMinus() {
        operator = "-";
        if (oldValue.equals("0")) {
            oldValue = newValue;
            newValue = "0";
        } else {
            double number1 = Double.parseDouble(oldValue);
            double number2 = Double.parseDouble(newValue);
            double sum = (number1 - number2);
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
        }
    }

    private void calPlus() {
        operator = "+";
        double number1 = Double.parseDouble(oldValue);
        double number2 = Double.parseDouble(newValue);
        double sum = (number1 + number2);
        oldValue = String.valueOf(sum);
        newValue = "0";

        checkDataType();
        result.setText(oldValue);
    }
}