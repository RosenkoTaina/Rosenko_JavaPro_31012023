package com.hillel.rosenko.lessons.lesson8;

public class ArrayValueCalculator {
    public int doCalc(String[][] arr) throws MyCustomException {
        int sum = 0;
        if (arr == null || arr.length != 4) {
            throw new ArraySizeException("Array size should be 4x4");
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new ArraySizeException("Array size should be 4x4");
            }
            for (String val : arr[i]) {
                try {
                    sum += Integer.parseInt(val);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid value in array: " + val, e);
                }
            }
        }
        return sum;
    }
}
