package com.hillel.rosenko.lessons.lesson4;

public class Cat extends Animal {
    private static int catCount;
    public Cat(String name, int maxRunDistance, int maxSwimDistance) throws InvalidObjectParametersException {
        super(name, maxRunDistance, maxSwimDistance);
        if (maxSwimDistance != 0) {
            throw new InvalidObjectParametersException("myCatParam must be 0 for maxSwimDistance");
        }
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
}

