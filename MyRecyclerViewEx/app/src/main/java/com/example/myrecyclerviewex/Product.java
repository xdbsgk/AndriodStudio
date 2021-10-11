package com.example.myrecyclerviewex;

import java.util.ArrayList;

public class Product {
    // 네트워크로 받았을 때 객체를 bin 객체 전달
    String productName;
    String location;
    String date;
    String price;
    int commentCount;
    int likeCount;
    String imageUri;

    // 생성자를 만들어 모양 맞추기
    public Product(String productName, String location, String date, String price, int commentCount, int likeCount, String imageUri) {
        this.productName = productName;
        this.location = location;
        this.date = date;
        this.price = price;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.imageUri = imageUri;
    }

    // 샘플 데이터 생성하기
    public static ArrayList<Product> getProductList() {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(
                new Product(
                        "니트 조끼",
                        "좌동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_1.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "먼나라 이웃나라 12",
                        "중동",
                        "3시간 전",
                        "18,000원",
                        1,
                        3,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_2.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "캐나다구스 패딩조",
                        "좌동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_3.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "유럽 여행",
                        "우동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_4.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "가죽 파우치",
                        "중동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_5.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "노트북",
                        "좌동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_6.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "원피스",
                        "중동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_7.jpg?raw=true"
                ));

        productList.add(
                new Product(
                        "아메리카노",
                        "우동",
                        "2시간 전",
                        "35,000원",
                        3,
                        8,
                        "https://github.com/flutter-coder/ui_images/blob/master/carrot_product_1.jpg?raw=true"
                ));

        return productList;
    }


}
