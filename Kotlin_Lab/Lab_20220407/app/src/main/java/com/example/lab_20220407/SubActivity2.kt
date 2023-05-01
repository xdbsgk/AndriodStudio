package com.example.lab_20220407

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubActivity2 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)
        val btn : Button = findViewById(R.id.btn_sub)
        val ev : EditText = findViewById(R.id.ev_sub)
        val res : TextView = findViewById(R.id.res_sub)
        val value = intent.getStringExtra("data")
        res.setText(value)

        btn.setOnClickListener {
            if (ev.text.isEmpty()) {
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data: String = ev.text.toString()
            val intent = Intent(this, SubActivity2::class.java)
            intent.putExtra("data", data)
            startActivityForResult(intent, 100)
            ev.text = null
            finish()
        }

    }
}