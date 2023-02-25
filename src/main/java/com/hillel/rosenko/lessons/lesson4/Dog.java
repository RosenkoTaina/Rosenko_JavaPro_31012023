package com.hillel.rosenko.lessons.lesson4;
public class Dog extends Animal {
    private static int dogCount;
    public Dog(String name, int maxRunDistance, int maxSwimDistance) throws InvalidObjectParametersException {
        super(name, maxRunDistance, maxSwimDistance);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}




