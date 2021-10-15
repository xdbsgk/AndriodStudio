package com.example.myystex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myystex.models.Movie;
import com.example.myystex.models.Yst;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setRecyclerView();
        setRecyclerViewAdapter();

    }

    private void setRecyclerView() {

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setRecyclerViewAdapter() {
        final YtsAdapter adapter = new YtsAdapter();
        // retrofit 사용해서 데이터를 불러와야 한다.
        YtsService service = YtsService.RETROFIT.create(YtsService.class);
        Call<Yst> call = service.repoContributors("rating", "20", "1");
        call.enqueue(new Callback<Yst>() {
            @Override
            public void onResponse(Call<Yst> call, Response<Yst> response) {
                Yst yst = response.body();
                adapter.addItems(yst.getData().getMovies());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Yst> call, Throwable t) {

            }
        });
        // adapter 에 데이터를 넣어주어야 한다.


        // Recycler View 에 setAdapter 메서드에 adapter 를 넣어줘야 한다.
    }

}   // End Of Inner Class



class YtsAdapter extends RecyclerView.Adapter<YtsAdapter.MyViewHolder> {

    // Movie 담을 리스트 메모리에 공간 할당시키기
    List<Movie> list = new ArrayList<>();

    // 메서드 만들기 (값 전달용)
    public void addItem(Movie movie) {
        list.add(movie);
    }
    public void addItems(List<Movie> list) {
        this.list = list;
    }

    // 내부 클래스
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPoster;
        private TextView tvTitle;
        private TextView tvRating;
        private RatingBar ratingBar;

        // 생성자 만들기
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
            ratingBar = itemView.findViewById(R.id.rating_bar);
        }

        // onBindViewHolder 에서 해야되는 동작 메서드 설계
        public void setItem(Movie movie) {
            Picasso.with(ivPoster.getContext())
                    .load(movie.getMediumCoverImage())
                    .into(ivPoster);
            tvTitle.setText(movie.getTitle());
            tvRating.setText(String.valueOf(movie.getRating()));
            ratingBar.setRating(movie.getRating());
        }



    }   // End Of Inner Class

    // Implements Method

    // View Holder 만들어주기
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 만든 xml 파일 inflater 를 통해 가져오기
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 화면이 변경되면서 데이터를 교체해서 넣어준다.
        // n 번째의 데이터를 뽑아 movie 에 세팅해준다.
        Movie movie = list.get(position);
        holder.setItem(movie);
        // ToDo 함수 사용 예정
    }

    // 아이템 개수
    @Override
    public int getItemCount() {
        return list.size();
    }



}

