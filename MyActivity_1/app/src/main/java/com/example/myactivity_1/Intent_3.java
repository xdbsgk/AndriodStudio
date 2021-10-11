package com.example.myactivity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class Intent_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);

        EditText editText = findViewById(R.id.inputUri);
        Button button = findViewById(R.id.btnUri1);

        button.setOnClickListener(view -> {
            // 사용자가 입력한 값을 가지고 올려면 코딩을 어떻게 해야 할까요?
            String uri = editText.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });


    }
}