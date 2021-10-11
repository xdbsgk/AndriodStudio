package com.example.secretdiaryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private Button openButton;
    private Button changePasswordButton;

    private Boolean changePasswordMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);

        openButton = findViewById(R.id.openButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);

    }

    private void addEventListener() {

        // open 버튼 눌렀을 때 화면 이동하기
        openButton.setOnClickListener(view -> {

            if (changePasswordMode) {
                Toast.makeText(this, "비밀번호 변경중입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            // 앱을 종료해도 비밀번호를 저장하는 기능 추가하기
            // SharedPreferences 는 안드로이드 프레임워크에 저장되어있는 클래스 파일
            // name : 파일에 이름
            // mode : 파일을 다른 앱과 공유하게 만들 수 있다.
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);

            // numberpicker 의 value 가져오기 (String 값)
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();

            // 값을 세팅하지 않았을 경우 초기값 세팅
            if (passwordPreferences.getString("password", "000").equals(passwordForUser)) {
                // 패스워드 성공
                // ToDo 다이어리 패키지 작성 후에 화면 전환시키기
                // intent
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            } else {
                // 실패
                showErrorAlertDialog();
            }
        });

        changePasswordButton.setOnClickListener(view -> {
            // ToDo 기존 비밀번호 가져오기
            // passwordPreferences 는 기존의 비밀번호가 저장되어있는 위치
            // MODE_PRIVATE -> 다른 앱과 비밀번호를 공유하지 않겠다.
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();

            if (changePasswordMode) {
                // 비밀번호를 저장하는 기능
                // SharedPreferences 파일에 수정 모드를 킨다.
                SharedPreferences.Editor editor = passwordPreferences.edit();
                editor.putString("password", passwordForUser);
                // [방식 1] 비동기 방식. 등록하기
                editor.apply();
                // [방식 2] commit -> 사용 시 UI 그리기를 멈추고 기다리는 방식.
                // editor.commit();
                changePasswordMode = false;
                changePasswordButton.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                // 비밀번호가 맞는지 체크
                if (passwordPreferences.getString("password", "000").equals(passwordForUser)) {
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    changePasswordButton.setBackgroundColor(Color.RED);
                } else {
                    showErrorAlertDialog();
                }
            }


        });

    }

    // 패스워드 실패 시 팝업창을 올리는 기능
    // 생성자 (매개변수 매우 많을 경우) = new 생성자(매개변수들)
    private void showErrorAlertDialog() {
        // builder 패턴은 메모리에 창을 올림.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다.")
                .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 동작 정의 X
                    }
                });
        // 화면에 띄우기
        builder.show();
    }


}