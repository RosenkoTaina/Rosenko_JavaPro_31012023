package com.hillel.rosenko.lessons.lesson8;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array) throws ArraySizeException {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException("Масив повинен мати розмірність 4x4");
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        }
        return sum;
    }
}



