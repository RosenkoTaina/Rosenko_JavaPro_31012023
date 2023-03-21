package com.hillel.rosenko.lessons.lesson9;

public class Main {
    public static void main(String[] args) {

        FileLoggerConfiguration config = new FileLoggerConfiguration("log.txt", LoggingLevel.INFO);
        FileLogger logger = new FileLogger(config);

    }
}
