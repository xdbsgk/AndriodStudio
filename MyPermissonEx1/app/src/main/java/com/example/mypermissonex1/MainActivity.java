package com.example.mypermissonex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Person Code 공부해보기
        // 필요한 것만 세팅 가능. 만약 age 안넣고싶다면 안넣어도 됨.
        Person person = new Person.Builder().name("kim").age(22).build();



        Button button = findViewById(R.id.ask);
        button.setOnClickListener(view -> {
            //권한이 있으면 PackageManager.PERMISSION_GRANTED(= 0) 반환
            //권한이 없으면 PackageManager.PERMISSION_DENIED(= -1) 반환
            int permissionCheck = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CAMERA);
            // 권한이 없을 경우만 실행하는 if문
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {
                } else {
                    // 안드로이드 시스템에게 권한 요청.
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSION_REQUEST_CAMERA
                    );

                }
            }
        });
    }   // End Of onCreate

    // Callback 메서드 만들기
    //권한에 대한 사용자 응답이 있을 때 작동하는 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CAMERA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "카메라 접근 권한 승인", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, "카메라 접근 권한 거부", Toast.LENGTH_LONG).show();
                }
            }
        }
    }   // End Of onRequestPermissionsResult


}