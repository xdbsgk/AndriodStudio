package com.example.mycallbackex;

public interface OnMyButtonCallback {
        // interface -> 추상 메서드, static 변수만 사용 가능
        // ToDo 프래그먼트의 버튼이 눌러지면 메인 액티비티에 동작이 되도록 작성한다.
        void onMyClicked();
        void onMyTouch();
        void onMyPassValue(String str);
}
