package com.example.myframgmentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 1. text 값 변경해보기
        // 2. 색상 변경하기기

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            FragmentTwo fragment2 = FragmentTwo.newInstance("프래그먼트", "프래그먼트2");
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.fragmentContainer, fragment2);
            transaction.commit();

            // 코드에서 리소스 안의 내용 가져오기 (strings 에 저장되어있는 내용)
            int hello = R.string.hello;

            // 1. 자동으로 int 에서 string 으로 반환해주는 것 사용하기
            // button1.setText(hello);

            // 2.
            String hello2 = getString(R.string.hello);
            button1.setText("두 번쨰 : " + hello2);

            // 색상 변경하기 (리소스에 접근하기)
            LinearLayout linearLayout = findViewById(R.id.fragmentContainer);
            linearLayout.setBackgroundColor(getColor(R.color.purple_200));


        });


    }
}