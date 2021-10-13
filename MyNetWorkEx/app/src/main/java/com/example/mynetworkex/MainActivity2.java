package com.example.mynetworkex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mynetworkex.beans.Todo;
import com.example.mynetworkex.interfaces.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // retrofit 사용 방법

        // 1. retrofit 생성하기
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()) // GSon
                .build();

        // 2. 'RetrofitService 인터페이스 만들기'

        // 3.
        RetrofitService service = retrofit.create(RetrofitService.class);

        // 4. 인터페이스에서 만든 것 사용하기 - 콜백메서드로
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            // 요청
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG2", response.isSuccessful() + "");
                if (response.isSuccessful()) {
                    Todo todo = response.body().get(0);
                    Log.d("TAG2", todo.getId() + "");
                    Log.d("TAG2", todo.getTitle() + "");
                }
            }
            // 실패시
            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });


    }
}