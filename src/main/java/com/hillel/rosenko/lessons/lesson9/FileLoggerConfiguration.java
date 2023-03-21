package com.hillel.rosenko.lessons.lesson9;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
}

