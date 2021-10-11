package com.example.myactivity_1;


// 기본적으로 가져다 쓸 것들을 가지고 온다.
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Tag","onCreate 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Tag","onStart 호출");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Tag","onResume 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Tag","onPause 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Tag","onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Tag","onDestroy 호출");
    }

}