package com.example.mydrawerlayoutex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴 바 만들어주기
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nv_view);
        setUpDrawerContent(navigationView);


    }

    // 이벤트 리스너 달아주기
    private void setUpDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectDrawerItem(item);
                        return true;
                    }
                }
        );

    }

    // 메서드화 해주기
    public void selectDrawerItem(MenuItem menuItem) {

        Fragment fragment = null;

        // 클래스 타입으로 먼저 담기 (동적 로딩), devNote 참고
        Class fragmentClass;

        switch (menuItem.getItemId()) {
            case R.id.nav_one_fragment:
                fragmentClass = Fragment1.class;
                break;
            case R.id.nav_two_fragment:
                fragmentClass = Fragment2.class;
                break;
            case R.id.nav_three_fragment:
                fragmentClass = Fragment3.class;
                break;
            // 기본값 설정
            default:
                fragmentClass = Fragment1.class;
        }

        // 객체화 시켜주기
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        // 프래그먼트 매니저 활용
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();

        // 사용자가 선택한 색 변경
        menuItem.setCheckable(true);
        // 위 바에 타이틀이 선택한 것으로 바뀐다.
        setTitle(menuItem.getTitle());
        // 사용자가 선택 시 자동으로 drawer 닫아주기
        drawerLayout.closeDrawers();


    }


}