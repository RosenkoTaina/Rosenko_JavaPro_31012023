package com.hillel.rosenko.lessons.lesson9.logger;

public enum LoggingLevel {
  INFO, DEBUG;

  public boolean includes(LoggingLevel level) {
    return this == DEBUG || level == INFO;
  }
}