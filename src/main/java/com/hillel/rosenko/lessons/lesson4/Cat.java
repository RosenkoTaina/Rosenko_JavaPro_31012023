package com.hillel.rosenko.lessons.lesson4;

public class Cat extends Animal {
    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
}