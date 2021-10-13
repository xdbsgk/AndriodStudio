package com.example.mynetworkex.interfaces;

import com.example.mynetworkex.beans.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

// 비즈니스 로직을 처리하는 부분은 요청사항에 따라서 언제든지 변할 수 있다.
// 변화에 대응하기 위해 확장을 염두해서 인터페이스로 구성한다.
public interface RetrofitService {
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

//    @GET("todos")
//    Call<ArrayList<Todo>> getTodos();

//    @GET("todos")
//    Call<ArrayList<Todo>> getTodos();

}
