package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityListener extends AppCompatActivity {

    public final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        TextView tvHello = findViewById(R.id.tvHello);

        // 이벤트 리스너 등록 -> 운영체제 요청: 클릭하는 동작을 듣고 있겠다.
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "클릭되었습니다.");
                Log.d(TAG, view.getId() + "클릭되었습니다.");
                Log.d(TAG, view.getTag() + "클릭되었습니다.");
            }
        });

        // 람다 표현식 -> 소스코드가 간편해진다.
        tvHello.setOnClickListener(view -> {
            Log.d(TAG, "xxxx.");
        });

        // 이벤트 리스너 종류 -> 많다.
        //tvHello.set

        // 한 줄만 간단하게 작성 시 중괄호 필요 X.
        tvHello.setOnClickListener(view -> Log.d("TAG","헬로원"));

        // 문제 1 -> 이벤트 리스너 생성
        TextView tvHello2 = findViewById(R.id.tvHello2);

        tvHello2.setOnClickListener(view -> {
            Log.d(TAG,"헬로투");
        });

        // 문제 2 -> 이벤트 리스너 생성
        TextView tvHello3 = findViewById(R.id.tvHello3);

        tvHello3.setOnClickListener(view -> {
            Log.d(TAG,"헬로쓰리");
        });


    }   // end of onCreate

}