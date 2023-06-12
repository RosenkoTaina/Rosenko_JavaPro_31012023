package main.java.com.hillel.rosenko.lessons.lesson5.task1;

public class Square implements Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

}

