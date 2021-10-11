package com.example.myglideex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = findViewById(R.id.image1);
        ImageView imageView2 = findViewById(R.id.image2);
        ImageView imageView3 = findViewById(R.id.image3);
        ImageView imageView4 = findViewById(R.id.image4);
        ImageView imageView5 = findViewById(R.id.image5);
        ImageView imageView6 = findViewById(R.id.image6);
        ImageView imageView7 = findViewById(R.id.image7);
        ImageView imageView8 = findViewById(R.id.image8);
        ImageView imageView9 = findViewById(R.id.image9);
        // place order -> 이미지 다운 전까지 기본적으로 보여지는 이미지

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView1);


        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2015/10/28/15/05/lemurs-1010643_960_720.jpg")
                .circleCrop()
                .into(imageView2);


        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2018/07/24/13/01/vegetable-3559112_960_720.jpg")
                .circleCrop()
                .into(imageView3);


        Glide.with(this)
                .load("https://i.picsum.photos/id/1064/80/80.jpg?hmac=dNFPVuqJaEivKIcBl55zH8K_b8ZO32bGIRmdA3M4-B8")
                .circleCrop()
                .into(imageView4);


        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView5);


        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView6);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView7);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView8);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/24/10/15/quokka-2676171_960_720.jpg")
                .circleCrop()
                .into(imageView9);



    }
}