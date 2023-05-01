package com.example.lab_20220407

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub3)
        val btn_finish : Button = findViewById(R.id.btn_finish)
        val btn_refactor : Button = findViewById(R.id.btn_refactor)
        var tvNameAndAge : TextView = findViewById(R.id.tvNameAndAge)
        var tvNumber : TextView = findViewById(R.id.tvNumber)
        var tvAddress : TextView = findViewById(R.id.tvAddress)
        var tvEtc : TextView = findViewById(R.id.tvEtc)

        var name = intent.getStringExtra("name")
        var age = intent.getStringExtra("age")
        var number = intent.getStringExtra("number")
        var address = intent.getStringExtra("address")
        var etc = intent.getStringExtra("etc")

        tvNameAndAge.setText("이름: $name, 나이: $age 세")
        tvNumber.setText("연락처: $number")
        tvAddress.setText("주소: $address")
        tvEtc.setText("기타: $etc")

        btn_refactor.setOnClickListener {
            finish()
        }

        btn_finish.setOnClickListener {
            val intent2 = Intent(this, MainActivity3::class.java)
            intent2.putExtra("name", name)
            intent2.putExtra("age", age)
            intent2.putExtra("number", number)
            intent2.putExtra("address", address)
            intent2.putExtra("etc", etc)
            Toast.makeText(this, "저장 완료!", Toast.LENGTH_SHORT).show()
            startActivity(intent2)
        }

    }
}