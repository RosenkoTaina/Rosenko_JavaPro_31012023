package com.hillel.rosenko.lessons.lesson4;

abstract class Obstacle {
    private static int parameter;

    public Obstacle(int parameter) {
        Obstacle.parameter = parameter;
    }

    public static int getLength() {
        return parameter;
    }

    public static void start(Animals animals) {
        animals.swim(getLength());
        animals.run(getLength());

    }
}
