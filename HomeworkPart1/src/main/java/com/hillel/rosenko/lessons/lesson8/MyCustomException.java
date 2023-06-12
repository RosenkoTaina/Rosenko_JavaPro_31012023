package com.hillel.rosenko.lessons.lesson8;
public class MyCustomException extends Exception {
  public MyCustomException(String message) {
    super(message);
  }
  public MyCustomException(String message, Throwable cause) {
    super(message, cause);
  }
}
