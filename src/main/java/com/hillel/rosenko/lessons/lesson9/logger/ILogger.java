package com.hillel.rosenko.lessons.lesson9.logger;

import java.io.IOException;

public interface ILogger {
  void log(String message, LoggingLevel level) throws IOException;

}

