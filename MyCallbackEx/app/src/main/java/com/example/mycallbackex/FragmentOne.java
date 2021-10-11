package com.example.mycallbackex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



// 콜리(호출자) : 생성자로 사용하는 방법
// 객체 생성시 무조건 매개변수로 타입을 넘겨 받아서 사용해야 한다.
public class FragmentOne extends Fragment {

    OnMyButtonCallback callback;

    public FragmentOne(OnMyButtonCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callback.onMyClicked();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button button = view.findViewById(R.id.frButton1);
        button.setOnClickListener(view1 -> {
            Log.d("TAG", "버튼이벤트 동작 확인 !!");
            callback.onMyClicked();
        });

        return view;
    }
}