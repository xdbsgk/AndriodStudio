package com.example.myviewpager1ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 페이지 수 지정해주기
    private static final int NUM_PAGES = 5;
    private ViewPager mViewPager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.pager);
        // 어댑터 만들기
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        // Viewpager 와 Adapter 연결하기
        mViewPager.setAdapter(pagerAdapter);

    }

    // *** 뒤로가기 메서드 (콜백 들어옴. 재정의 가능) ***
    @Override
    public void onBackPressed() {
        // page 가 0 번째이면 앱 종료해라
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            // 아니면 앞의 view 로 이동하기 (4 ->3, 3->2, 2->1 ...)
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}