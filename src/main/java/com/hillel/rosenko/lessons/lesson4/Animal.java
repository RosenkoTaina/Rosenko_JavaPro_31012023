package com.hillel.rosenko.lessons.lesson4;

public abstract class Animal {
    private String name;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Invalid distance input");
            return;
        }

        String animalType = this.getClass().getSimpleName();
        int maxDistance = 0;

        if (animalType.equals("Cat")) {
            maxDistance = 200;
        } else if (animalType.equals("Dog")) {
            maxDistance = 500;
        }

        if (distance > maxDistance) {
            System.out.println(this.name + " can't run that far");
        } else {
            System.out.println(this.name + " ran " + distance + "m");
        }
    }
    public void swim(int distance) {
        String animalType = this.getClass().getSimpleName();

        if (animalType.equals("Cat")) {
            System.out.println(this.name + " can't swim");
            return;
        } else if (animalType.equals("Dog") && distance > 10) {
            System.out.println(this.name + " can't swim that far");
            return;
        }

        System.out.println(this.name + " swam " + distance + "m");
    }
}