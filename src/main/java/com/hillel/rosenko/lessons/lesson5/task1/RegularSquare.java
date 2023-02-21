package com.hillel.rosenko.lessons.lesson5.task1;

public class RegularSquare implements Square {

    private final double side1;

    public RegularSquare(double side1) {
        this.side1 = side1;
    }

    @Override
    public double getPerimeter() {
        return 4*side1;
    }

    @Override
    public double getShape() {
        return Math.pow(side1,2);
    }


}
