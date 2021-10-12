package com.example.mybottomnaviex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();

        // 첫 프래그먼트 설정해주기
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.linearLayout, fragment1)
                .commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            // true --> 아이콘 누를 시 선택한 아이콘 색 변경.
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("TAG", "item: " + item.getItemId());

                // 바텀 네비게이션 클릭 때마다 프래그먼트 바꾸어주기
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.menu_item1:
                        fragment = fragment1;
                        break;
                    case R.id.menu_item2:
                        fragment = fragment2;
                        break;
                    case R.id.menu_item3:
                        fragment = fragment3;
                        break;
                }

                // 바꾼 프래그먼트 그려주기
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.linearLayout, fragment)
                        .commit();

                return true;
            }

        });


    }


}
