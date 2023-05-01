package com.example.mymovie

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reserved.*
import kotlinx.android.synthetic.main.activity_reserved.posterImageView
import java.io.*
import java.lang.Exception
import java.lang.NullPointerException

class ReservedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserved)

        processIntent(intent)
        btnclose.setOnClickListener{
            finish()
        }
    }

    fun processIntent(intent: Intent?){
        val movies = intent?.getSerializableExtra("movies") as ArrayList<ReservedMovie>?
        val movie = movies?.get(0)
        if(movie!=null){
            posterImageView.setImageURI(Uri.parse(movie.poster_image))
            input1.setText(movie.name)
            input2.setText(movie.reserved_time)
            input3.setText(movie.director)
            input4.setText(movie.synopsis)
        } else {

        }
    }
}

class MainActivity : AppCompatActivity() {
    val databaseName = "movie"
    var database: SQLiteDatabase? = null
    val tableName = "movie_reserved"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDatabase()
        createTable()

        btn1.setOnClickListener {
            saveMovie()
        }
        btn2.setOnClickListener {
            loadMovie()
        }
    }

    fun createDatabase(){
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE,null)
    }

    fun createTable(){
        if(database == null) return

        val sql = " CREATE TABLE IF NOT EXISTS $tableName" +
                "(_id integer PRIMARY KEY autoincrement, " +
                "title text, " +
                "bookDate text, " +
                "director text, " +
                "synopsis text, " +
                "posterImage text)"
        database?.execSQL(sql)
    }


    fun saveMovie(){
        val posterImageUri = savePosterToFile(R.drawable.gg)
        val name = input1.text.toString()
        val reserved_time = input2.text.toString()
        val director = input3.text.toString()
        val synopsis = input4.text.toString()
        val poster_image = posterImageUri.toString()
        addData(name,poster_image,director,synopsis,reserved_time)
    }

    fun savePosterToFile(drawable:Int): Uri {
        val drawable = ContextCompat.getDrawable(applicationContext,drawable)
        val bitmap = (drawable as BitmapDrawable).bitmap

        val wrapper = ContextWrapper(applicationContext)
        val imagesFolder = wrapper.getDir("images", Context.MODE_PRIVATE)
        val file = File(imagesFolder,"gg.jpg")

        try{
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
            stream.flush()
            stream.close()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    fun addData(name:String, poster_image:String, director:String, synopsis:String, reserved_time:String){
        val sql = "INSERT INTO $tableName(title, bookDate, director, synopsis, posterImage) " +
                "VALUES" +
                "('$name', '$reserved_time', '$director', '$synopsis', '$poster_image')"

        if(database==null) {
            println("데이터베이스를 먼저 오픈하세요\n")
            return
        }
        database?.execSQL(sql)
        println("데이터 추가함\n")
    }

    fun loadMovie(){
        val movies = queryData()
        val intent = Intent(this, ReservedActivity::class.java)
        intent.putExtra("movies",movies)
        startActivity(intent)
    }

    fun queryData():ArrayList<ReservedMovie>?{
        val sql = "select _id, title, bookDate, director, synopsis, posterImage from ${tableName}"

        if(database == null){
            println("데이터베이스를 먼저 오픈하세요.\n")
            return null
        }
        val list= arrayListOf<ReservedMovie>()
        val cursor = database?.rawQuery(sql,null)
        if (cursor?.count == 0) return null
        if(cursor!=null){
            for (index in 0 until cursor.count){
                cursor.moveToNext()
                val _id = cursor.getInt(0)
                val name = cursor.getString(1)
                val reserved_time = cursor.getString(2)
                val director = cursor.getString(3)
                val synopsis = cursor.getString(4)
                val poster_image = cursor.getString(5)
                println("레코드# ${index}: $_id, $name, $poster_image, $director, $synopsis, $reserved_time\n")

                val movie = ReservedMovie(_id,name,poster_image,director,synopsis,reserved_time)
                list.add(movie)
            }
            cursor.close()
        }
        println("데이터 조회함\n")
        return list
    }
}

data class ReservedMovie(
    val _id:Int?,
    val name:String?,
    val poster_image: String?,
    val director: String?,
    val synopsis: String?,
    val reserved_time: String?
): Serializable