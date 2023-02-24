package com.hillel.rosenko.lessons.lesson4;

public class Animals {

    private String name;
    private static int animalCount;

    public static int getAnimalCount() {
        return animalCount;
    }

    public Animals(String name) {
        this.name = name;
        animalCount++;
    }


    public void run(int distance) {
        System.out.println("This animal " + name + " ran " + distance + " m");
    }

    public void swim(int distance) {
        System.out.println("This animal " + name + " swam " + distance +  " m");
    }

}

