package com.example.myframgmentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("life_cycle", "A : onCreate");
        setContentView(R.layout.activity_main);

        // 선언을 전체 onCreate 에 해야 프래그먼트를 삭제할 때도 호출해 삭제 가능.
        Fragment fragment1 = new FragmentOne();
        // Fragment 에 데이터를 넣어주는 방법
        // Bundle 이란 것을 만들어서 끼워 넣어 사용한다.
        Bundle bundle = new Bundle();
        bundle.putString("keyHello", "안녕하세요");
        fragment1.setArguments(bundle);



        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            // 1. 코드로 프래그먼트를 만들기 위해서는 프래그먼트 매니저가 필요하다.
            FragmentManager fragmentManager = getSupportFragmentManager();
            // 2. Transaction 이 필요하다. : FragmentTransaction
            // 작업의 단위 -> 시작과 끝이 있다.
            // 일을 시작
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // 할 일
            // Fragment fragment1 = new FragmentOne(); (위에다 생성하기)
            transaction.replace(R.id.fragContainer, fragment1);
            // commit 호출하기
            transaction.commit();           // 시간이 될 때 만들어라 (좀 더 안정적인 방식, 주로 사용할 방법)
            // transaction.commitNow();     // 코드가 왔을 때 바로 만들어라
            // transaction.commitAllowingStateLoss(); // 위험하다. commit 이 실행되지 않을 수 있다.
        });


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // 할 일
            // detach -> 한 번 실행한 것을 다시 사용하지 않을 때
            // remove -> 다시 사용할 일이 있는 화면일 때
            // 상황에 맞춰 사용하기.
            // transaction.detach(fragment1);  // detach 사용시 메모리 상에서 완전히 사라지게 된다.
            transaction.remove(fragment1);     // container 에서 지움.
            // 끝
            transaction.commit();

        });


    }

    @Override
    protected void onStart() {
        Log.d("life_cycle", "A : onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("life_cycle", "A : onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("life_cycle", "A : onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("life_cycle", "A : onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("life_cycle", "A : onDestroy");
        super.onDestroy();
    }
}