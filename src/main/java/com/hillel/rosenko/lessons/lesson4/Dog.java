package com.hillel.rosenko.lessons.lesson4;

public class Dog extends Animals {
    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println ("Wrong data for Dog to run");
        } else if (distance > 500) {
            System.out.println ("Dog cant run so far");
        } else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) {
             System.out.println ("Wrong data for Dog to swim");
        } else if (distance > 10) {
            System.out.println ("Dog cant swim so far");
        } else {
            super.swim(distance);
        }
    }
}
