package com.example.mynetworkex.beans;

public class Todo {

// Data 예시
//    {
//        "userId": 1,
//            "id": 1,
//            "title": "delectus aut autem",
//            "completed": false
//    }
    private int userId;
    private int id;
    private String title;
    private String completed;

    // 패키지가 다르기 때문에 게터 만들기

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return completed;
    }
}
