package com.hillel.rosenko.lessons.lesson9.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger implements ILogger {
  private FileLoggerConfiguration configuration;
  private BufferedWriter writer;
  private File currentFile;

  public FileLogger(FileLoggerConfiguration configuration) throws IOException {
    this.configuration = configuration;
    openNewFile();
  }

  // New File Open
  private void openNewFile() throws IOException {
    String timestamp = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss").format(new Date());
    String fileName = "Log_" + timestamp + configuration.getLogFormat();
    currentFile = new File(configuration.getLogFilePath(), fileName);
    writer = new BufferedWriter(new FileWriter(currentFile));
  }

  // Choosing whether system should log into file or into console or both
  public void startLog(String message, LoggingLevel level) throws IOException {
    try {
      if (configuration.isConsoleLoggingEnabled()) {
        logToConsole(message, level);
      } else {
        if (configuration.getLogFilePath() != null) {
          log(message, level);
        }
      }
    } catch (IOException | FileMaxSizeReachedException e) {
      log(message, level);

    }
  }


  // Logging to File
  @Override
  public void log(String message, LoggingLevel level) throws IOException {

    if (level.ordinal() > configuration.getLoggingLevel().ordinal()) {
      return;
    }
    String formattedMessage = String.format("[%s][%s]%s", new Date().toString(), level.toString(),
        " Message: " + message);


    try {
      if (currentFile.length() + formattedMessage.length() > configuration.getMaxFileSize()) {

        throw new FileMaxSizeReachedException("Maximum file size reached", currentFile.length(),
            configuration.getMaxFileSize(), currentFile.getAbsolutePath());

      }
    } catch (FileMaxSizeReachedException fileMaxSizeReachedException) {
      try {
        Thread.sleep(5000); // Sleep and Catch needed so program write logs to appropriate files.
        // Because do while cycle is too fast for our logging
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      closeCurrentFile();
      try {
        Thread.sleep(1000); // Sleep and Catch needed so program write logs to appropriate files.
        // Because do while cycle is too fast for our logging
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      openNewFile();
      writer.write(fileMaxSizeReachedException.toString());
      writer.newLine();
      writer.flush();

    }
    writer.write(formattedMessage);
    writer.newLine();
    writer.flush();
  }

  // Logging to Console
  void logToConsole(String message, LoggingLevel level)
      throws IOException, FileMaxSizeReachedException {
    if (level.ordinal() > configuration.getLoggingLevel().ordinal()) {
      return;
    }
    System.out.println("[" + LocalDateTime.now() + "]" + "[" + level + "] Message: " + message);
  }

  // Close the file
  public void closeCurrentFile() {
    if (writer != null) {
      try {
        writer.close();
      } catch (IOException e) {
        throw new RuntimeException(
            "Failed to load configuration from file: " + currentFile.getAbsolutePath(), e);
      } finally {
        writer = null;
      }
    }
  }
}
