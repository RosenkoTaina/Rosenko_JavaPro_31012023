package com.hillel.rosenko.lessons.lesson9.logger;

public class FileLoggerConfiguration {

    private final String logFilePath;
    private final LoggingLevel loggingLevel;
    private final long maxFileSize;
    private final String logFormat;
    private final String isConsoleLoggingEnabled;

    // Configuration Constructor
    public FileLoggerConfiguration(String logFilePath, LoggingLevel loggingLevel, long maxFileSize, String logFormat, String isConsoleLoggingEnabled) {
        this.logFilePath = logFilePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
        this.isConsoleLoggingEnabled = isConsoleLoggingEnabled;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public String isConsoleLoggingEnabled() {
        return isConsoleLoggingEnabled;
    }
}
