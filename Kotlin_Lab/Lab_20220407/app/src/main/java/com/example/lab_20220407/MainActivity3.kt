package com.example.lab_20220407

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val btn_save : Button = findViewById(R.id.btn_save)
        var etName : EditText = findViewById(R.id.etName)
        var etAge : EditText = findViewById(R.id.etAge)
        var etNumber : EditText = findViewById(R.id.etNumber)
        var etAddress : EditText = findViewById(R.id.etAddress)
        var etEtc : EditText = findViewById(R.id.etEtc)
        var imageView : ImageView = findViewById(R.id.imageView)


        btn_save.setOnClickListener {
            if (etName.text.isEmpty() || etAge.text.isEmpty() || etNumber.text.isEmpty() || etAddress.text.isEmpty() || etEtc.text.isEmpty()) {
                Toast.makeText(this, "모두 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var name : String = etName.text.toString()
            var age : String = etAge.text.toString()
            var number : String = etNumber.text.toString()
            var address : String = etAddress.text.toString()
            var etc : String = etEtc.text.toString()

            val intent = Intent(this, SubActivity3::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("number", number)
            intent.putExtra("address", address)
            intent.putExtra("etc", etc)

            startActivity(intent)

        }

    }
}