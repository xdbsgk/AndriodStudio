package com.example.mypermissonex1;

public class Person {

    String name;
    int age;

    // 생성자 만들기
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    // 내부 클래스
    public static class Builder {
        String name;
        int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}
