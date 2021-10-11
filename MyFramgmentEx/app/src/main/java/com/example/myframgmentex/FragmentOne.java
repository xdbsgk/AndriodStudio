package com.example.myframgmentex;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("life_cycle", "F : onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("life_cycle", "F : onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("life_cycle", "F : onCreateView");

        // 방어적 코드 짜주기
        if (getArguments() != null) {
            String data = getArguments().getString("keyHello");
            Log.d("DATA", "data : " + data);
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    // deprecated
    // 앞으로 이 메서드를 변경/유지보수 하지 않겠다. or 앞으로 개발될 때 빠질 수도 있다.
    // 가능한 쓰지 않거나 잘 알고 쓰는것이 좋다.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("life_cycle", "F : onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("life_cycle", "F : onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("life_cycle", "F : onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("life_cycle", "F : onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("life_cycle", "F : onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("life_cycle", "F : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("life_cycle", "F : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("life_cycle", "F : onDetach");
        super.onDetach();
    }
}