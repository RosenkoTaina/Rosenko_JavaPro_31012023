package com.hillel.rosenko.lessons.lesson14.phonebook;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutRule implements TestRule {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  public String getLog() {
    return outContent.toString();
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
          base.evaluate();
        } finally {
          System.setOut(originalOut);
        }
      }
    };
  }
}