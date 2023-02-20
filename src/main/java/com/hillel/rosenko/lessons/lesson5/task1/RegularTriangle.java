package com.hillel.rosenko.lessons.lesson5.task1;

import static java.lang.Math.sqrt;

public class RegularTriangle implements Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    public RegularTriangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getSemiperimeter() {
        return getPerimeter() / 2;
    }
    @Override
    public double getShape() {
        return sqrt(getSemiperimeter() * (getSemiperimeter() - side1) * (getSemiperimeter() - side2) *  (getSemiperimeter() - side3) );
    }

}
