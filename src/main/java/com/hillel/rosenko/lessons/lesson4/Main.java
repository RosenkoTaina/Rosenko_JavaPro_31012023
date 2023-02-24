package com.hillel.rosenko.lessons.lesson4;

public class Main {
    public static void main(String[] args) {

        Obstacle[] obstacles = {
                new Pool(5),
                new Track(50),

        };

        Animals[] animals = {
             new Cat("Cat1"),
                new Dog("Dog1"),
                new Cat("Chip"),
        };

        for (Animals animal : animals) {
                Obstacle.start(animal);
            }
        System.out.println("Cat count: " + Cat.getCatCount());
        System.out.println("Dog count: " + Dog.getDogCount());
        System.out.println("Animal count: " + Animals.getAnimalCount());

    }

    }

