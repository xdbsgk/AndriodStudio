package com.example.mytoolbarex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        // actionbar 영역에 우리가 만든 툴바로 지정한다.
        setSupportActionBar(toolbar);
    }

    // menu 올릴 때 사용하기. 리턴 -> true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    // 위 메뉴 클릭 할 때 옵션 추가하기. 리턴 -> true
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItem1:
                Log.d("TAG", "menu1 selected");
                break;
            case R.id.menuItem2:
                Log.d("TAG", "menu2 selected");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "menu3 selected");
                break;
        }

        return true;
    }
}