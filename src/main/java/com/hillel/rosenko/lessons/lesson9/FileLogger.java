package com.hillel.rosenko.lessons.lesson9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void log(LoggingLevel level, String message) {
        if (level.ordinal() >= configuration.getLoggingLevel().ordinal()) {
            String formattedMessage = String.format("[%s] %s - %s\n",
                    level.toString(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                    message);

            try {
                FileWriter writer = new FileWriter(new File(configuration.getFilePath()), true);
                writer.write(formattedMessage);
                writer.close();
            } catch (IOException e) {
                System.err.println("Error writing log message: " + e.getMessage());
            }
        }
    }
}

