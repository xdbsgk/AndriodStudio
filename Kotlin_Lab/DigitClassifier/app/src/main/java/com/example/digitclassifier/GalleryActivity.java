package com.example.digitclassifier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitclassifier.tflite.Classifier;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Locale;

public class GalleryActivity extends AppCompatActivity {
    public static final String TAG = "[IC]GalleryActivity";
    public static final int GALLERY_IMAGE_REQUEST_CODE = 1;

    Classifier cls;
    Bitmap bitmap = null;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Button selectBtn = findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(v -> getImageFromGallery());

        imageView = findViewById(R.id.imageView1);
        textView = findViewById(R.id.textView);

        Button classifyBtn = findViewById(R.id.classifyBtn);
        classifyBtn.setOnClickListener(v -> {
            if(bitmap != null) {
                Pair<Integer, Float> res = cls.classify(bitmap);
                String res1 = "";
                switch (res.first) {
                    case 0:
                        res1 = "T-shirt/top";
                        break;
                    case 1:
                        res1 = "Trouser";
                        break;
                    case 2:
                        res1 = "Pullover";
                        break;
                    case 3:
                        res1 = "Dress";
                        break;
                    case 4:
                        res1 = "Coat";
                        break;
                    case 5:
                        res1 = "Sandal";
                        break;
                    case 6:
                        res1 = "Shirt";
                        break;
                    case 7:
                        res1 = "Sneaker";
                        break;
                    case 8:
                        res1 = "Bag";
                        break;
                    case 9:
                        res1 = "Ankle boot";
                        break;
                    default:
                        res1 = "Cannot classified";
                }
                String outStr = String.format(
                        Locale.ENGLISH,
                        "%s, %.0f%%",
                        res1,
                        res.second * 100.0f);
                textView.setText(outStr);
            }
        });

        cls = new Classifier(this);
        try {
            cls.init();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void getImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
        startActivityForResult(intent, GALLERY_IMAGE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK &&
            requestCode == GALLERY_IMAGE_REQUEST_CODE) {
            if (data == null) {
                return;
            }

            Uri seletedImage = data.getData();

            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    ImageDecoder.Source src =
                            ImageDecoder.createSource(getContentResolver(), seletedImage);
                    bitmap = ImageDecoder.decodeBitmap(src).copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), seletedImage);
                }
            } catch (IOException ioe) {
                Log.e(TAG, "Failed to read Image", ioe);
            }

            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    protected void onDestroy() {
        cls.finish();
        super.onDestroy();
    }
}