package com.hillel.rosenko.lessons.lesson9.program;

public class MyCustomException extends Exception {
  public MyCustomException(String message) {
    super(message);
  }

  public MyCustomException(String message, Throwable cause) {
    super(message, cause);
  }
}
