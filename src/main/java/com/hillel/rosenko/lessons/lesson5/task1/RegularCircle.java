package com.hillel.rosenko.lessons.lesson5.task1;

public class RegularCircle implements Circle {

    public static final double P = 3.14;
    private final double r;

    public RegularCircle(double r) {
        this.r = r;
    }

    @Override
    public double getRadius() {
        return r;
    }


    @Override
    public double getShape() {
        return P * Math.pow(r,2);
    }
}
