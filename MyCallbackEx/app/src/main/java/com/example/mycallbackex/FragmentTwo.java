package com.example.mycallbackex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// 호출자 : 메서드를 호출해야 된다.
public class FragmentTwo extends Fragment {

    private OnMyButtonCallback callback;

    public void setOnMyButtonCallback(OnMyButtonCallback callback) {
        this.callback = callback;
    }

    public FragmentTwo() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_two, container, false);
        Button button = view.findViewById(R.id.frButton2);
        button.setOnClickListener(view1 -> {
            callback.onMyPassValue("플래그먼트에서 값을 보냄");

        });


        return view;
    }
}