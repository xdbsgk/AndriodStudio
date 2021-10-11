package com.example.myaddviewex;

public class Car {
    String name;
    String engine;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
