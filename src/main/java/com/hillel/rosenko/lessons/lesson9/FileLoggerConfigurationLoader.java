package com.hillel.rosenko.lessons.lesson9;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration loadConfiguration(String filePath) {

        FileLoggerConfiguration config = new FileLoggerConfiguration("log.txt", LoggingLevel.INFO);
        FileLogger logger = new FileLogger(config);

        logger.log(LoggingLevel.INFO, "This is an info message");
        logger.log(LoggingLevel.DEBUG, "This is a warning message");
        logger.log(LoggingLevel.ERROR, "This is an error message");


        return new FileLoggerConfiguration(filePath, LoggingLevel.INFO);


    }

}

