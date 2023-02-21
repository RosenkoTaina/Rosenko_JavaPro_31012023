package com.hillel.rosenko.lessons.lesson5.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        final float[] totalCircles = new float[]{0};
        final float[] totalSquares = new float[]{0};
        final float[] totalTriangles = new float[]{0};


        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(5, 5, 5));
        triangles.add(new Triangle(5, 6, 8));

        triangles.forEach(triangle -> {
                    System.out.println("Triangle № " + (triangles.indexOf(triangle) + 1));
                    System.out.printf("Shape: %.2f", triangle.getArea());
                    System.out.println();
                    totalTriangles[0] += triangle.getArea();
                }

        );
        System.out.println("TOTAL: " + (totalTriangles[0]));

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(5));
        circles.add(new Circle(2));

        circles.forEach(circle -> {
                    System.out.println("Circle № " + (circles.indexOf(circle) + 1));
                    System.out.printf("Shape: %.2f", circle.getArea());
                    System.out.println();
                    totalCircles[0] += circle.getArea();
                }
        );
        System.out.println("TOTAL: " + (totalCircles[0]));


        List<Square> squares = new ArrayList<>();
        squares.add(new Square(5));
        squares.add(new Square(6));


        squares.forEach(square -> {
                    System.out.println("Square № " + (squares.indexOf(square) + 1));
                    System.out.printf("Shape: %.2f", square.getArea());
                    System.out.println();
                    totalSquares[0] += square.getArea();
                }
        );
        System.out.println("TOTAL: " + (totalSquares[0]));


        Figure[] figures = new Figure[]{
                new Triangle(5, 5, 5),
                new Triangle(5, 6, 8),
                new Circle(5),
                new Circle(2),
                new Square(5),
                new Square(6)
        };

        double totalArea = getTotalArea(figures);
        System.out.println("Total area of figures: " + totalArea);
    }
        public static double getTotalArea(Figure[] figures) {
            double totalArea = 0;
            for (Figure figure : figures) {
                totalArea += figure.getArea();
            }
            return totalArea;
        }


    }


    



