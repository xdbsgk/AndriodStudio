package com.example.secretdiaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        // Todo 입력한 다이어리 내용 저장하는 기능 --> SharedPreferences

        // 파일에 있는 값을 화면 뷰에 찍어줘야 한다.
        SharedPreferences detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        // 값이 없으면 기본값을 세팅하라. "" (빈값)
        diaryEditText.setText(detailPreferences.getString("detail", ""));


        // thread 기능 구현 (익명 클래스를 runnable 이라는 변수에 담음.)
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("detail", diaryEditText.getText().toString());
                editor.apply();
            }
        };



        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 회원가입 아이디가 10자 이상
                // 한 글자씩 저장 기능  (0.5초마다 저장하시오. 500 mSec)
                // 0.5초 앞에 저장한 글자들은 앞에 저장했으니까 저장하지 않아도 되고,
                // 그 이후 0.5초간 쓴 글자만을 저장한다.
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);           }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 글자 가져오기
        String data = diaryEditText.getText().toString();
    }
}