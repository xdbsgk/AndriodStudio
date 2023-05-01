package com.example.lab_20220407_hw

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var btn2 : Button = findViewById(R.id.btn2)
        var tvKorName : TextView = findViewById(R.id.tvKorName)
        var tvEngName : TextView = findViewById(R.id.tvEngName)
        var tvContact : TextView = findViewById(R.id.tvContact)
        var tvEMail : TextView = findViewById(R.id.tvEMail)
        var tvAddress : TextView = findViewById(R.id.tvAddress)

        tvKorName.setText(intent.getStringExtra("KorName"))
        tvEngName.setText(intent.getStringExtra("EngName"))
        tvContact.setText(intent.getStringExtra("Contact"))
        tvEMail.setText(intent.getStringExtra("EMail"))
        tvAddress.setText(intent.getStringExtra("Address"))


        btn2.setOnClickListener {
            finish()
        }
    }
}