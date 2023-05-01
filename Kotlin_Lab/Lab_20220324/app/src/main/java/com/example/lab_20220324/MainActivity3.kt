package com.example.lab_20220324

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    lateinit var Btn1 : Button
    lateinit var Btn2 : Button
    lateinit var Btn3 : Button
    lateinit var Btn4 : Button
    lateinit var Btn5 : Button
    lateinit var Btn6 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        title = "직접해보기 6번 문제"

        Btn1 = findViewById(R.id.Btn1)
        Btn2 = findViewById(R.id.Btn2)
        Btn3 = findViewById(R.id.Btn3)
        Btn4 = findViewById(R.id.Btn4)
        Btn5 = findViewById(R.id.Btn5)
        Btn6 = findViewById(R.id.Btn6)

        Btn1.setOnTouchListener { view, motionEvent ->
            Btn1.visibility = View.INVISIBLE
            Btn2.visibility = View.VISIBLE
            false
        }

        Btn2.setOnTouchListener { view, motionEvent ->
            Btn2.visibility = View.INVISIBLE
            Btn3.visibility = View.VISIBLE
            false
        }

        Btn3.setOnTouchListener { view, motionEvent ->
            Btn3.visibility = View.INVISIBLE
            Btn4.visibility = View.VISIBLE
            false
        }

        Btn4.setOnTouchListener { view, motionEvent ->
            Btn4.visibility = View.INVISIBLE
            Btn5.visibility = View.VISIBLE
            false
        }

        Btn5.setOnTouchListener { view, motionEvent ->
            Btn5.visibility = View.INVISIBLE
            Btn6.visibility = View.VISIBLE
            false
        }

        Btn6.setOnTouchListener { view, motionEvent ->
            Btn6.visibility = View.INVISIBLE
            Btn1.visibility = View.VISIBLE
            false
        }



    }
}