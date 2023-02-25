package com.hillel.rosenko.lessons.lesson4;

public abstract class Animal {
    private String name;
    private static int animalCount;
    private int maxRunDistance;
    private int maxSwimDistance;
    public Animal(String name, int maxRunDistance, int maxSwimDistance) throws InvalidObjectParametersException {
        this.name = name;
        if (maxRunDistance < 0 || maxSwimDistance < 0) {
            throw new InvalidObjectParametersException("myAnimalsParam must be non-negative");
        }
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }


    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " can't run that far.");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " can't swim.");
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " can't swim that far.");
        }
    }

}
