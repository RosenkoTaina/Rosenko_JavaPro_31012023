package com.hillel.rosenko.lessons.lesson4;

public class Main {
    public static void main(String[] args) throws InvalidObjectParametersException {

        Obstacle[] obstacles = {
                new Pool(10),
                new Track(200)
        };
        Animal[] animals = new Animal[0];
        try {
            animals = new Animal[]{
                    new Cat("Tom", 200, 0),
                    new Dog("Rex", 300, 10),
                    new Cat("Fluffy", 300, 0)
            };
        } catch (InvalidObjectParametersException ex) {
            System.out.println(ex.getMessage());
        }

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


