package com.example.week10_1

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val databaseName = "people"
    var database: SQLiteDatabase? = null
    val tableName = "student"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doButton1.setOnClickListener {

        }
        doButton2.setOnClickListener {

        }
        doButton3.setOnClickListener {

        }
        doButton4.setOnClickListener {

        }
        doButton5.setOnClickListener {

        }
        doButton6.setOnClickListener {

        }

        fun createDatabase() {
            database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null)
            output1.append("데이터베이스 생성 또는 오픈 함\n")
        }

        fun checkDatabase() : Boolean {
            if (database == null) {
                output1.append("데이터베이스를 먼저 오픈하세요.\n")
                return true
            }
            return false
        }

        fun closeDatabase() {
            database?.close()
        }

        fun createTable() {
            if(checkDatabase()) return
            database?.execSQL("DROP Table ${tableName}")
            val wql = "create table if not exist ${tableName}" +
                    ""
        }
    }
}