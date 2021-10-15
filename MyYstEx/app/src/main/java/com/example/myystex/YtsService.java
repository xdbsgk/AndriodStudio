package com.example.myystex;

import com.example.myystex.models.Yst;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

// https://yts.lt/api/v2/list_movies.json?limit=20&page=1&sort_by=rating

public interface YtsService {
    // interface 에 들어올 수 있는 것 - 추상 메서드, static 변수

    @GET("list_movies.json")
    Call<Yst> repoContributors(
            @Query("sort_by") String sort_by,
            @Query("limit") String limit,
            @Query("page") String page
    );

    public static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl("https://yts.lt/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
