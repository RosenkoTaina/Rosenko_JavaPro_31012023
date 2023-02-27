package com.hillel.rosenko.lessons.lesson4;
public abstract class Obstacle {
    private int length;

    public Obstacle(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public abstract void overcome(Animal animal);
}

