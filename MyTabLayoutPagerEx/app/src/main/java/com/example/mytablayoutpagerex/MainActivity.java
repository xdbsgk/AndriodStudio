package com.example.mytablayoutpagerex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 탭 레이아웃 생성하기
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("one"));
        tabLayout.addTab(tabLayout.newTab().setText("two"));
        tabLayout.addTab(tabLayout.newTab().setText("three"));


        // 뷰 페이저 생성하기
        ViewPager viewPager = findViewById(R.id.view_pager);
        // 어댑터 만들어주기
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), 3);
        // 뷰 페이저에 어댑터 연결해주기
        viewPager.setAdapter(adapter);


        // 뷰 페이저와 탭 레이아웃을 연결하기

        // 1. 탭 레이아웃 이벤트 리스너에 뷰 페이저 동작을 연결한다.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // 2. 뷰 페이저 이벤트 리스너에 탭 레이아웃을 연결한다.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}


// 어댑터 클래스를 따로 만들어주기
class MyAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public MyAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 2) {
            return new FragmentThree();
        } else if (position == 1) {
            return new FragmentTwo();
        } else {
            return new FragmentOne();
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}


// Pager 를 사용하기 위해서 Adapter 를 만들어야 한다.






