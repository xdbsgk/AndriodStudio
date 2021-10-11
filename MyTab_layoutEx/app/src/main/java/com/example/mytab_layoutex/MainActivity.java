package com.example.mytab_layoutex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // 프래그먼트와 탭스 이어주기 !!
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.container, fragment1)
//                .commit();

        tabLayout = findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setText("friends"));
        tabLayout.addTab(tabLayout.newTab().setText("chatting"));
        tabLayout.addTab(tabLayout.newTab().setText("more"));


        // 프래그먼트와 탭 레이아웃 이어주기 (넘겼을 떄 옆으로)
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 선택되었을 때
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                // 변수에 프래그먼트 담기
                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, selected)
                        .commit();
            }

            // 선택 취소되었을 때
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            // 다시 선택되었을 때
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}