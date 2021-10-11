package com.example.myactivity_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class Intent_1 extends AppCompatActivity {

    final static String TAG = Intent_1.class.getName(); // "Intent_1" 값이 담긴다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);


        Button button1 = findViewById(R.id.btnUri);

//        button1.setOnClickListener(view -> {
//            // 방법 1 : 인텐트 만들어주기 (명시적 인텐트)
//            //  packageContext: 이 클래스의 주변 정보, 환경, 문맥
//            Intent intent = new Intent(this, Intent_2.class);
//            startActivity(intent);
//
//        });


        // 결과값을 다시 돌려 받을 때 사용하는 방법
        //        button1.setOnClickListener(view -> {
//            // key, value 방식 쌍으로 만들어서 전달한다.
//            intent.putExtra("number1", 1);
//            intent.putExtra("number2", 2);
//            startActivityForResult(intent, 1001);
//
//        });

        // 암시적 인텐트 만들기
        button1.setOnClickListener(view -> {
            // 방법 3
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
            startActivity(intent);
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "요청 종류 확인");
        Log.d(TAG, requestCode + " : requestCode");
        Log.d(TAG, resultCode + " : resultCode");
        Log.d(TAG, data + " : data");

        if (data != null) {
            if (requestCode == RESULT_OK) {
                int resultSum = data.getIntExtra("result", 0);
                Log.d(TAG, "result value : " + resultSum);
            }
        }
    }
}