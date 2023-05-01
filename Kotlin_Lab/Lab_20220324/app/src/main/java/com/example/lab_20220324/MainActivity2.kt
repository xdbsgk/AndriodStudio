package com.example.lab_20220324

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var LinLay : LinearLayout
    lateinit var Btn : Button
    var num : Int = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        title = "직접해보기 1번 문제"

        LinLay = findViewById(R.id.LinLay)
        Btn = findViewById(R.id.Btn)

        Btn.setOnTouchListener { view, motionEvent ->
            num ++
            if (num % 3 == 0) {
                LinLay.setBackgroundColor(Color.parseColor("#FF0000"))
            } else if (num % 3 == 1) {
                LinLay.setBackgroundColor(Color.parseColor("#00FF00"))
            } else {
                LinLay.setBackgroundColor(Color.parseColor("#0000FF"))
            }
            false
        }


    }
}