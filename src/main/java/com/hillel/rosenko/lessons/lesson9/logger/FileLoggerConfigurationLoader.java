package com.hillel.rosenko.lessons.lesson9.logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
  static String line;
  static String file = null;
  static LoggingLevel level = null;
  static long maxSize = -1;
  static String format = null;
  static String console = null;


  // Loading Configuration file

  public static FileLoggerConfiguration load(String filePath) throws IOException {

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("=");
        if (parts.length != 2) {
          throw new IllegalArgumentException("Invalid configuration line: " + line);
        }

        String key = parts[0].trim();
        String value = parts[1].trim();

        switch (key.toUpperCase()) {
          case "FILE" -> file = value;
          case "LEVEL" -> level = LoggingLevel.valueOf(value.toUpperCase());
          case "MAX-SIZE" -> maxSize = Long.parseLong(value);
          case "FORMAT" -> format = value;
          case "CONSOLE" -> console = value;
          default -> throw new IllegalArgumentException("Unknown configuration key: " + key);
        }
      }
    } catch (IllegalArgumentException exception) {
      throw new IOException("Invalid configuration file: " + filePath, exception);
    }

    return new FileLoggerConfiguration(file, level, maxSize, format, console);
  }

  public static String getFile() {
    return file;
  }

  public static LoggingLevel getLevel() {
    return level;
  }

  public static long getMaxSize() {
    return maxSize;
  }

  public static String getConsole() {
    return console;
  }

  public static String getFormat() {
    return format;
  }
}