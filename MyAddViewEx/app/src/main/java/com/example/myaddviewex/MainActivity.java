package com.example.myaddviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 아이템 리스트를 준비
        // 변수는 하나만
        // 자료구조 - 하나의 변수에 관련된 데이터 타입을 통으로 관리하기 위해서 자료구조 or 배열을 사용한다.

        ArrayList<Car> carArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            carArrayList.add(new Car(i + "번째 자동차", i + "번째 엔진"));
        }

        LinearLayout container = findViewById(R.id.addViewContainer);

        // xml 파일을 들고 올려면 LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        for (int i = 0; i < carArrayList.size(); i++) {

            View itemView = layoutInflater.inflate(R.layout.item_view, null);
            TextView carTv = itemView.findViewById(R.id.carNameTextView);
            TextView engineTv = itemView.findViewById(R.id.engineTextView);
            carTv.setText(carArrayList.get(i).name);
            engineTv.setText(carArrayList.get(i).engine);

            container.addView(itemView);

        }


    }
}