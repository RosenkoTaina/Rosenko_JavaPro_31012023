package com.hillel.rosenko.lessons.lesson9.logger;

public class FileMaxSizeReachedException extends Exception {
  private final String message;
  private final Long currentSize;
  private final long maxSize;
  private final String filePath;

  public FileMaxSizeReachedException(String message, Long currentSize, long maxSize,
                                     String filePath) {
    this.message = message;
    this.currentSize = currentSize;
    this.maxSize = maxSize;
    this.filePath = filePath;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "FileMaxSizeReachedException " + message + ", currentSize=" + currentSize + ", maxSize="
        + maxSize + ", filePath=" + filePath + "]";
  }

  public Long getCurrentSize() {
    return currentSize;
  }

  public long getMaxSize() {
    return maxSize;
  }

  public String getFilePath() {
    return filePath;
  }
}