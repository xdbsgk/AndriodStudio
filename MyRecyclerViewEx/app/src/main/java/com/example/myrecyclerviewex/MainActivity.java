package com.example.myrecyclerviewex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.metrics.Event;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 어댑터 생성
        ProductAdapter adapter = new ProductAdapter(Product.getProductList());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // 2. RecyclerView 는 레이아웃 매니저가 필요하다. (어떻게 배치할 것인지 정해준다.)
        // - LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // - GridLayoutManager
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        // 3. Divider 생성하기
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getApplicationContext(), linearLayoutManager.getOrientation());

        // 위 내용 세팅해주기
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}




// 어댑터 만들기 (뷰 홀더 만들어줘야함 내부클래스 ok)
class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    // Implement
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        // 만든 xml 파일 inflater 를 통해 가져오기
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        
        // new 로 ViewHolder 만들어주기
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 화면이 변경되면서 데이터를 교체해서 넣어준다.
        // 여기서 글라이드를 처리해주면 더 좋은 코드 완성 가능하다.

        // 뒤 코드가 복잡하므로 간단하게 바꿔주기 -> product 데이터 타입 선언해 변수명 item 선언 후 코드 줄여준다.
        Product item = products.get(position);

        // 글라이드를 실행하려면 매니페스트 파일에서 인터넷 권한을 설정해주어야한다.
        Glide.with(holder.itemView.getContext())
                .load(item.imageUri)
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.productImageView);

        // holder 로 멤버 변수에 접근 가능
        // image 는 Glide 로 만들어주기.
        holder.titleTextView.setText(item.productName);
        holder.subTitleTextView.setText(item.location + " ㆍ " + item.date);
        holder.footerTextView.setText(item.price);
        holder.commentCountTextView.setText(item.commentCount + "");
        holder.likeCountTextView.setText(item.likeCount + "");


    }
    
    @Override
    public int getItemCount() {
        return products.size();
    }


    // 내부 클래스
    class ViewHolder extends RecyclerView.ViewHolder {
    // 처음 생성한 데이터 파일들을 담는다.
        ImageView productImageView;
        TextView titleTextView;
        TextView subTitleTextView;
        TextView footerTextView;
        TextView commentCountTextView;
        TextView likeCountTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // findViewById 해주기
            productImageView = itemView.findViewById(R.id.productImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            footerTextView = itemView.findViewById(R.id.footerTextView);
            commentCountTextView = itemView.findViewById(R.id.commentCountTextView);
            likeCountTextView = itemView.findViewById(R.id.likeCountTextView);


            itemView.setOnClickListener(view -> {
                Log.d("TAG", getLayoutPosition() + "번째");
                Toast.makeText(itemView.getContext(), getLayoutPosition() + "번째 레이아웃입니다.", Toast.LENGTH_SHORT).show();
            });
            
        }
    }

}


