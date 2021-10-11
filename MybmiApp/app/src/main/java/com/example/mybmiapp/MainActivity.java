 package com.example.mybmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText heightEt = findViewById(R.id.heightEt);
        EditText weightEt = findViewById(R.id.weightEt);
        Button isOk = findViewById(R.id.isOk);

        isOk.setOnClickListener(view -> {
            if (heightEt.getText().length() < 1 || weightEt.getText().length() < 1){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            int height = Integer.parseInt(heightEt.getText().toString());
            int weight = Integer.parseInt(weightEt.getText().toString());

            Intent intent = new Intent(this, MainActivity2.class);

            // 인텐트에 값 보내는 방법
            // key 값 이용하기
            intent.putExtra("height", height);
            intent.putExtra("weight", weight);

            startActivity(intent);


        });





    }
}