package com.hillel.rosenko.lessons.lesson19;

public class Orange extends Fruit {
  private static final double DEFAULT_WEIGHT = 1.5;
  private static final String DEFAULT_NAME = "Orange";

  public Orange() {
    super(DEFAULT_NAME, DEFAULT_WEIGHT);
  }

  @Override
  public double getWeight() {
    return DEFAULT_WEIGHT;
  }
}
