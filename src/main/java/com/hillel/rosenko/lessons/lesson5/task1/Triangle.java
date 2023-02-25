package com.hillel.rosenko.lessons.lesson5.task1;

import static java.lang.Math.sqrt;

public class Triangle implements Figure{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private double getPerimeter() {
        return side1 + side2 + side3;
    }

    private double getSemiperimeter() {
        return getPerimeter() / 2;
    }

    @Override
    public double getArea() {
        return sqrt(getSemiperimeter() * (getSemiperimeter() - side1) * (getSemiperimeter() - side2) *  (getSemiperimeter() - side3) );

    }

}
