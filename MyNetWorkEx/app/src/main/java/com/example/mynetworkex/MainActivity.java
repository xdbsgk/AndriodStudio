package com.example.mynetworkex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mynetworkex.beans.Todo;
import com.example.mynetworkex.beans.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getName();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.basicTextView);

        // json 형식
        // 1.
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", 1);
            jsonObject.put("name", "호랑이");
            jsonObject.put("title", "호랑이 굴");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // 2.
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);

        Log.d(TAG, "jsonArray : " + jsonArray.toString());

        /**
         * [
         *  {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *  {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *  {"id":1,"name":"호랑이","title":"호랑이 굴"}
         * ]
         *
         */

        // 3. 전체가 key 와 value 구조로 나타남.
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("arr", jsonArray);
            Log.d(TAG, "arr JSON : " + jsonObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /**
         * {"arr":[
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"}
         *        ]
         * {"arr2":[
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"},
         *           {"id":1,"name":"호랑이","title":"호랑이 굴"}
         *        ]
         * }
         */

        /*
        JSONObject obj;
        try {
            obj = new JSONObject(jsonObject.toString());
            JSONArray jsonArray = obj.getJSONArray("arr"); // [ { } ]
            JSONObject datObject = jsonArray.getJSONObject(0);

            int id = datObject.getInt("id");
            String name = datObject.getString("name");
            String title = datObject.getString("title");

            System.out.println(" name: " + name);
            System.out.println(" id: " + id);
            System.out.println(" title: " + title);

            Log.d(TAG, "jsonArr: " + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */


        // 주소가 필요하다.
        String urlString = "https://jsonplaceholder.typicode.com/todos";
        String urlString2 = "https://jsonplaceholder.typicode.com/users";

        // 네트워크 사용 시 비동기 방식이나 새로운 스레드를 만들어야 함. (동작되는 시간동안 사용자에게 표시)
        // Thread 만들기 (작업자 생성)
        new Thread(new Runnable() {
            @Override
            public void run() {

                // 새로운 작업 실행
                try {
                    // 1. URL 만들기
                    URL url = new URL(urlString2);
                    // 2. 자바 - http Connection 클래스 있음. connection -> 주소값, 형변환 필요하다.
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    // 2-1. 요청
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json");

                    // 네트워크 연결 후에 데이터를 담을 변수
                    // String buffer --> 메모리에 적게 부담가도록 한다. 효율적인 메모리 할당.
                    String buffer = "";

                    // 'Http 상태 코드' 참고, HttpURLConnection --> 스태틱 변수이므로 HTTP_OK 사용가능.
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        // 데이터를 읽을 수 있음. 동작 수행
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream(), "UTF-8")
                        );


                        // while 문 사용해 끝까지 읽어줘야 함.
                        StringBuffer sb = new StringBuffer();
                        // 초기화 먼저 진행
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        String str = sb.toString();
                        //Log.d(TAG, "buffer: " + str);

                        //////////////////////////////////////////////////////
                        Todo[] todos = new Gson().fromJson(str, Todo[].class);
                        // User[] users = new Gson().fromJson(str, User[].class);
                        //////////////////////////////////////////////////////

                        // *** ToDo Code
                        /*
                        for (Todo t : todos) {
                            Log.d(TAG, "getUserId: " + t.getUserId());
                            Log.d(TAG, "getId: " + t.getId());
                            Log.d(TAG, "getTitle: " + t.getTitle());
                            Log.d(TAG, "getCompleted: " + t.getCompleted());
                            Log.d(TAG, "----------------------------------------");
                        }

*/

                        // *** List --> ArrayList 쓰기 (편하게 받기 가능)
                        Type todoListType = new TypeToken<ArrayList<Todo>>() {
                        }.getType();
                        ArrayList<Todo> todoList = new Gson().fromJson(str, todoListType);
                        // ArrayList 돌리는 for 문 완성
                        /*
                        for (Todo t : todoList) {
                            Log.d(TAG, "getId: " + t.getId());
                            Log.d(TAG, "getUserId: " + t.getUserId());
                            Log.d(TAG, "getTitle: " + t.getTitle());
                            Log.d(TAG, "getCompleted: " + t.getCompleted());
                            Log.d(TAG, "----------------------------------------");
                        }
                        */

                        // *** User Code
                        Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
                        ArrayList<User> userList = new Gson().fromJson(str, userListType);
                        //
                        for (User u : userList) {

                            textView.setText(u.getName());

                            Log.d(TAG, "getId: " + u.getId());
                            Log.d(TAG, "getName: " + u.getName());
                            Log.d(TAG, "getUsername: " + u.getUsername());
                            Log.d(TAG, "getEmail: " + u.getEmail());
                            Log.d(TAG, "getAddress: " + u.getAddress().getStreet());
                            Log.d(TAG, "getAddress: " + u.getAddress().getSuite());
                            Log.d(TAG, "getAddress: " + u.getAddress().getCity());
                            Log.d(TAG, "getAddress: " + u.getAddress().getZipcode());
                            Log.d(TAG, "getPhone: " + u.getPhone());
                            Log.d(TAG, "getWebsite: " + u.getWebsite());
                            Log.d(TAG, "getCompany: " + u.getCompany().getName());
                            Log.d(TAG, "getCompany: " + u.getCompany().getCatchPhrase());
                            Log.d(TAG, "getCompany: " + u.getCompany().getBs());
                            Log.d(TAG, "--------------------------------------------------------");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}