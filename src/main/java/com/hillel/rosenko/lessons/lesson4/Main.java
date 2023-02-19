package com.hillel.rosenko.lessons.lesson4;

public class Main {
    public static void main(String[] args) {

        Obstacles[] obstacles = {
                new Pool(),
                new Track()
        };

        Animal[] animals = {
                new Cat("Tom", 5),
                new Dog("Sausage", 10,200)

        };

        for (Obstacles obstacle : obstacles) {
            for (Animal animal : animals) {
                obstacle.start(animal);
            }
        }

    }
}
