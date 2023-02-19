package com.hillel.rosenko.lessons.lesson4;

public class Pool implements Obstacles {

    @Override
    public void start(Animal animal) {
        animal.swim();
    }
}
