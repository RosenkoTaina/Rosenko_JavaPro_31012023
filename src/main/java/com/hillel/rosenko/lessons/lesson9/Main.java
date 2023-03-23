package com.hillel.rosenko.lessons.lesson9;
import com.hillel.rosenko.lessons.lesson9.logger.*;
import com.hillel.rosenko.lessons.lesson9.program.*;

import java.io.IOException;
import java.util.Random;

/**
 * Exceptions in Java.
 */
public class Main {

  public static void main(String[] args) throws IOException, FileMaxSizeReachedException {

    // Logging
    FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
    FileLoggerConfiguration configuration = loader.load("C:/Users/TAYA/Rosenko_JavaPro_31012023/Logger/configLog.txt"); // Path to configuration file
    FileLogger logger = new FileLogger(configuration);

    // Program itself
    while (true) {
      String[][] arr = new String[4][4];
      Random rnd = new Random();
      for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[i].length; j++) {
          arr[i][j] = String.valueOf(rnd.nextInt(10));
        }
      }
      for (String[] row : arr) {
        for (String cell : row) {
          System.out.print(cell + " ");
        }
        System.out.println();
      }
      ArrayValueCalculator calc = new ArrayValueCalculator();
      try {
        logger.startLog("Sum calculation started", LoggingLevel.INFO); // Message in case calculation started
        int sum = ArrayValueCalculator.doCalc(arr);
        logger.startLog("Sum calculation ended", LoggingLevel.INFO); // Message in case calculation ended
        System.out.println("Sum: " + sum);
      } catch (MyCustomException e) {
        logger.startLog(e.getClass().getSimpleName(), LoggingLevel.DEBUG); // Message in case exception
        switch (e.getClass().getSimpleName()) {
          case "ArraySizeException" -> System.out.println("Array size should be 4x4");
          case "NumberFormatException" -> System.out.println(e.getMessage());
          default -> e.printStackTrace();
        }
      }
    }
  }
}