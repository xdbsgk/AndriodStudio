package com.example.lab_20220324

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.lang.NullPointerException


class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnMod : Button
    lateinit var btnChange : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var cnt = 0
    var result : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        title = "${cnt}회 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnMod = findViewById(R.id.BtnMod)
        btnChange = findViewById(R.id.BtnChange)
        textResult = findViewById(R.id.TextResult)


        btnAdd.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "게산 결과 : "+ result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                cnt++
                title = "${cnt}회 계산기"
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "계산할 수를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        btnSub.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text = "게산 결과 : "+ result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                cnt++
                title = "${cnt}회 계산기"
            } catch (e:Exception) {
                Toast.makeText(this@MainActivity, "계산할 수를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        btnMul.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "게산 결과 : "+ result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                cnt++
                title = "${cnt}회 계산기"
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "계산할 수를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        btnDiv.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                textResult.text = "게산 결과 : "+ result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                cnt++
                title = "${cnt}회 계산기"
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "계산할 수를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        btnMod.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) % Integer.parseInt(num2)
                textResult.text = "게산 결과 : "+ result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                cnt++
                title = "${cnt}회 계산기"
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "계산할 수를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        btnChange.setOnClickListener {
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                edit1.setText(num2)
                edit2.setText(num1)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "값을 교체할 수 없습니다.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
