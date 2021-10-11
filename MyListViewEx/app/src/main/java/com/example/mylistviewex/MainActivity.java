package com.example.mylistviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Car> carArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            carArrayList.add(new Car(i + "번째 자동차", i + "번째 엔진"));
        }

        // BaseAdapter
        ListViewAdapter adapter = new ListViewAdapter(carArrayList, this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 아이템 리스너를 사용하는 방법 (클릭 시 상세페이지로 이동하기) - 람다표현식 사용가능
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //             메인 액티비티에 띄워라고 전달함.
                Toast.makeText(view.getContext(), "선택된 아이템 : " + i, Toast.LENGTH_SHORT).show();
            }
        });

    }
}


// BaseAdapter 사용하여 클래스 만들기, 추상메서드 구현해야 함.

class ListViewAdapter extends BaseAdapter {

    private ArrayList<Car> carArrayList;
    private Context context;

    // 생성자 만들어주기
    public ListViewAdapter(ArrayList<Car> carArrayList, Context context) {
        this.carArrayList=carArrayList;
        this.context=context;
    }

    // 전체 개수를 알려준다.
    @Override
    public int getCount() {
        return carArrayList.size();
    }

    // 화면에 표시할 데이터
    @Override
    public Object getItem(int i) {
        return carArrayList.get(i);
    }

    // 해당 item 의 position 또는 id
    @Override
    public long getItemId(int i) {
        return i;
    }

    // 그리고자 하는 아이템 리스트의 하나
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 한 번에 보여주지 않고 화면에 보여지는 부분까지 보여준다.

        View itemView;
        CarViewHolder carViewHolder;

        // 아이템 뷰가 생성되지 않았다면 생성해주기
        if (view == null) {
            Log.d("TAG", "getView 호출" + i);
            // 데이터 세팅하는 과정
            carViewHolder = new CarViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.item_view, null);
            carViewHolder.carNameTv = itemView.findViewById(R.id.carNameTextView);
            carViewHolder.engineTv = itemView.findViewById(R.id.engineTextView);
            itemView.setTag(carViewHolder);
        } else {
            // 메모리에 만들어놓았기 때문에 다시 당겨와쓰기
            carViewHolder = (CarViewHolder) view.getTag();
            itemView = view;
        }

        // 뷰 홀더를 통해 껍데기 안 내용만 교체한다. 22개의 뷰만 만들고 데이터만 체인지함. 효율적이다.
        carViewHolder.carNameTv.setText(carArrayList.get(i).name);
        carViewHolder.engineTv.setText(carArrayList.get(i).engine);

        // inflater 로 생성한 것 return
        return itemView;
    }
}


// Car 클래스

class Car {
    String name;
    String engine;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
    }

}

// 뷰 홀더 사용 - 생성된 뷰를 담아놓고 사용(재사용하기 위해 만든다.)
// 용이한 메모리 관리
// findViewById 가 메모리를 많이 사용하기 때문에 새로운 클래스로 구현해보자

class CarViewHolder {
    TextView carNameTv;
    TextView engineTv;
}