package com.hillel.rosenko.lessons.lesson5.task2;

abstract class Obstacle {
    private int parameter;

    public Obstacle(int parameter) {
        this.parameter = parameter;
    }

    public int getLength() {
        return parameter;
    }

    public int getHeight() {
        return parameter;
    }
}
