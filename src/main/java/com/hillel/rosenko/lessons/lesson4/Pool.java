package com.hillel.rosenko.lessons.lesson4;

public class Pool extends Obstacle {
    public Pool(int length) {
        super(length);
    }

    public void overcome(Animal animal) {
        animal.swim(this.getLength());
    }
}