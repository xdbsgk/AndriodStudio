package com.example.myviewpager2ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

/**
 * 중첩된 fragment 를 만들 때 사용한다.
 *
 * ViewPager2 는 ViewPager 의 개선된 버전으로,
 * 향상된 기능을 제공하며, ViewPager 사용 시 발생하는 일반적인 문제가 해결됐다.
 *
 * 세로 방향 지원
 * 오른쪽에서 왼쪽으로도 지원한다.
 *
 */

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager2;
    // 어댑터
    private FragmentStateAdapter stateAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연결
        viewPager2 = findViewById(R.id.pager);
        stateAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(stateAdapter);

        // 페이지가 바뀌는 콜백을 등록함.
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                Log.d("TAG", ">>>>>>> position <<<<<< : " + position);
////                super.onPageSelected(position);
//
//                // 마지막에서 넘겨도 첫번째 인덱스가 나오게 하려면 ?...
//                if (viewPager2.getCurrentItem() == NUM_PAGES-1) {
//                    viewPager2.setCurrentItem(0, false);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("TAG", "state: " + state);
//                super.onPageSelected(position);

                // 마지막에서 넘겨도 첫번째 인덱스가 나오게 하려면 ?...
                if (viewPager2.getCurrentItem() == NUM_PAGES-1) {
                    viewPager2.setCurrentItem(0, false);
                }
            }
        });
    }

    // 종료 버튼 눌렀을 때 구현하기
    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1);
        }
    }

    // 어댑터 만들기
    private class ScreenSlidePageAdapter extends FragmentStateAdapter {


        public ScreenSlidePageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


}