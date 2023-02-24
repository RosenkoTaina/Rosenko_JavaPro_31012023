package com.hillel.rosenko.lessons.lesson4;

public class Cat extends Animals {
    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println ("wrong data for cat run");
        } else if (distance > 200) {
            System.out.println ("cat cant run so far");
        } else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can`t swim ");
    }
}




