package com.example.mycallbackex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity implements OnMyButtonCallback {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        createFragmentOne();
//        createFragmentTwo();
//
//    }
//
//    private void createFragmentOne() {
//        FragmentOne fragmentOne = new FragmentOne(this);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.fragmentContainer, fragmentOne);
//        transaction.commit();
//    }
//
//    private void createFragmentTwo() {
//        FragmentTwo fragmentTwo = new FragmentTwo();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.fragmentContainer2, fragmentTwo);
//        transaction.commit();
//
//        // 메서드로 사용하는 방식
//        fragmentTwo.setOnMyButtonCallback(this);
//    }
//
//
//    // 콜백(응답자)
//    @Override
//    public void onMyClicked() {
//        // 이 메서드로 콜백 되어 온다! 여기의 소스 코드가 동작된다.
//        Log.d("TAG", "콜백 됨 !!!");
//    }
//}



public class MainActivity extends AppCompatActivity {

    TextView emptyTextView;

    // 내부 클래스 중 익명 내부 구현 객체 --> 변수에 담기
    OnMyButtonCallback onMyButtonCallback = new OnMyButtonCallback() {
        @Override
        public void onMyClicked() {
            Log.d("TAG", "콜백 됨  2 !!!!");
        }

        @Override
        public void onMyTouch() {
            Log.d("TAG", "두 번째 실행 메서드");
        }

        @Override
        public void onMyPassValue(String str) {
            Log.d("TAG", "str : " + str);
            emptyTextView.setText(str);
//            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emptyTextView = findViewById(R.id.emptyTextView);
        createFragmentOne();
        createFragmentTwo();
    }

    private void createFragmentOne() {
        FragmentOne fragmentOne = new FragmentOne(onMyButtonCallback);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragmentOne);
        transaction.commit();
    }

    private void createFragmentTwo() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer2, fragmentTwo);
        transaction.commit();

        // 메서드로 사용하는 방식
        fragmentTwo.setOnMyButtonCallback(onMyButtonCallback);
    }
}