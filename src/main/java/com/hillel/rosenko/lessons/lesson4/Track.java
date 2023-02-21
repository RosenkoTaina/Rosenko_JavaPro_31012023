package com.hillel.rosenko.lessons.lesson4;

public class Track implements Obstacles{

    @Override
    public void start(Animal animal) {
        animal.run();
    }
}
