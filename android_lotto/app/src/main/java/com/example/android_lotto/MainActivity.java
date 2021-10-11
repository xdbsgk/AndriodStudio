package com.example.android_lotto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private Button initBtn;
    private Button runBtn;
    private NumberPicker numberPicker;
    private boolean didRun = false;

    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);

        //
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        // 텍스트 뷰 가져오기
        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));
    }

    private Drawable setTextViewBackground(int number) {
        // 숫자별로 색 칠해주기 메서드
        Drawable drawable;
        // drawable Resource 를 가져오는 방법 (코드)
        if (number <= 10) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_1);
        } else if (number <= 20) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_2);
        } else if (number <= 30) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_3);
        } else if (number <= 40) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_4);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_5);
        }
        return drawable;
    }

    private void addEventListener() {

        runBtn.setOnClickListener(view -> {
            List<Integer> list = getRandomNumber();
            Log.d("TAG", getRandomNumber().toString());
            list.addAll(pickerNumberSet);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int randomNumber = list.get(i);
                numberTextViewList.get(i).setText(String.valueOf(randomNumber));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                numberTextViewList.get(i).setBackground(setTextViewBackground(randomNumber));
            }
            didRun = true;
        });


        addBtn.setOnClickListener(view -> {
            int selectedNumber = numberPicker.getValue();

            // 예외처리
            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도해주세요", Toast.LENGTH_SHORT).show();
                return;
            }

            // 번호는 5개까지만 선택가능하다.
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "번호는 5개까지만 선택가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            // 포함 여부 확인
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "이미 선택한 번호입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            // 1 2 3 4 5 6
            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(view.VISIBLE);


            // 문자열로 변경해 세팅 (에러 방지)
            textView.setText(String.valueOf(selectedNumber));
            textView.setBackground(setTextViewBackground(selectedNumber));
            pickerNumberSet.add(selectedNumber);
        });


        initBtn.setOnClickListener(view -> {

            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            }


        });
    }

    private List<Integer> getRandomNumber() {

        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            // 중복된 값이 있는지 확인하기. 중복된 값이 있다면 numberList 에 담지 않고 넘어간다.
            if (pickerNumberSet.contains(i)) {
                continue;
            }
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        // 0부터 시작해서 총 6개를 잘라라.
        return numberList.subList(0, 6 - pickerNumberSet.size());

    }

}
