package com.hillel.rosenko.lessons.lesson4;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {
                new Pool(6),
                new Track(50)
        };

        Animal[] animals = {
                new Cat("Tom"),
                new Dog("Rex"),
                new Cat("Fluffy")
        };

        for (Animal animal : animals) {
            for (Obstacle obstacle : obstacles) {
                obstacle.overcome(animal);
            }
        }

        System.out.println("Cat count: " + Cat.getCatCount());
        System.out.println("Dog count: " + Dog.getDogCount());
        System.out.println("Animal count: " + Animal.getAnimalCount());
    }
}