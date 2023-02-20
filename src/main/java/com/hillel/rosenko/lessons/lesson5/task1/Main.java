package com.hillel.rosenko.lessons.lesson5.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new RegularTriangle(5, 5, 5));
        triangles.add(new RegularTriangle(5, 6, 8));
        triangles.add(new RegularTriangle(9, 7, 14));
        triangles.add(new RegularTriangle(7, 5, 6));
        triangles.add(new RegularTriangle(11, 20, 24));

        triangles.forEach(triangle -> {
            System.out.println("Triangle № " + (triangles.indexOf(triangle) + 1));
            System.out.printf("Shape: %.2f", triangle.getShape());
            System.out.println();
                }

        );

        List<Circle> circles = new ArrayList<>();
        circles.add(new RegularCircle(5));
        circles.add(new RegularCircle(2));
        circles.add(new RegularCircle(2.4));
        circles.add(new RegularCircle(3));
        circles.add(new RegularCircle(7));

        circles.forEach(circle -> {
                    System.out.println("Circle № " + (circles.indexOf(circle) + 1));
                    System.out.printf("Shape: %.2f", circle.getShape());
                    System.out.println();
                }
        );


        List<Square> squares = new ArrayList<>();
        squares.add(new RegularSquare(5));
        squares.add(new RegularSquare(6));
        squares.add(new RegularSquare(2));
        squares.add(new RegularSquare(3.3));
        squares.add(new RegularSquare(8));

        squares.forEach(square -> {
                    System.out.println("Circle № " + (squares.indexOf(square) + 1));
                    System.out.printf("Shape: %.2f", square.getShape());
                    System.out.println();
                }
        );
    }
}


