package com.hillel.rosenko.lessons.lesson6;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HomeWorkApp {
    public static void main(String[] args) {
        stringWriter();
        System.out.println("-----------");
        checkSumSign1(-4, -5);
        printColor1(100);
        compareNumbers1(5, 6);
        printCheckSumRange1(5,1);
        checkPositiveOrNegative1(-5);
        printIsNegative(-5);
        printIsLeapYear(2120);
        printStringSeveralTimes("cat",6);
        System.out.println("-----------");
    }

    private static void stringWriter() {
        System.out.println(printThreeWords());
        System.out.println(printTask());
    }

    private static String printThreeWords() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("Orange");
        printWriter.println("Banana");
        printWriter.println("Apple");
        return stringWriter.toString();
    }

    private static String printTask() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(checkSumSign());
        printWriter.println(printColor());
        printWriter.println(compareNumbers());
        printWriter.println(checkSumRange(5, 1));
        printWriter.println(checkPositiveOrNegative(-5));
        printWriter.println(isNegative(-5));
        printWriter.println(isLeapYear(2100));
        return stringWriter.toString();

    }

    private static String checkSumSign() {
        int a = -4;
        int b = -5;
        int sum = a + b;
        if (sum >= 0) {
            return  "Сума позитивна";
        } else {
            return  "Сума негативна";
        }
    }

    private static String printColor() {
        int value = 100;
        if (value <= 0) {
            return "Червоний";
        } else if (value > 0 && value <= 100) {
            return  "Жовтий";
        } else {
            return  "Зелений";
        }
    }

    private static String compareNumbers() {
        int a = 5;
        int b = 6;
        if (a >= b) {
            return "a >= b";
        } else {
            return "a < b";
        }
    }

    private static String checkSumRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return "true";
        } else {
            return "false";
        }
    }


    private static String checkPositiveOrNegative(int a) {
        if (a >= 0) {
            return a + " додатнє число";
        } else {
            return a + " від’ємне число ";
        }
    }


    public static void checkSumSign1(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    public static void printColor1 (int value) {
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    public static void compareNumbers1 (int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

     public static boolean checkSumRange1(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    public static void printCheckSumRange1(int a, int b) {
        boolean result = checkSumRange1(a, b);
        System.out.println(result);
    }

    public static void checkPositiveOrNegative1(int a) {
        int result = (int) Math.signum(a);
        if (result == 0 || result == 1) {
            System.out.println(a + " додатнє число");
        } else { System.out.println(a + " від`ємне число");
        }

    }
    public static boolean isNegative(int num) {
        if(num < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void printIsNegative(int a) {
        boolean result = isNegative(a);
        System.out.println(result);
    }
    public static void printStringSeveralTimes(String a, int b) {
        int y = 1;
        if (b >= 1) {
            do {
                System.out.println(a);
                y++;
            } while (y<=b);
        } else {
            System.out.println("wrong data");
        }
    }

    public static boolean isLeapYear(int num) {
        int a = num % 4;
        int b = num % 100;
        int c = num % 400;

        if ((a != 0) || (b == 0) && (c != 0)) {
            return false;
        } else {
            return true;
            }
    }

    public static void printIsLeapYear(int num) {
        boolean result = isLeapYear(num);
        System.out.println(result);
    }

}



