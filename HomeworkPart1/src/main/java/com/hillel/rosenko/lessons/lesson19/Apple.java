package com.hillel.rosenko.lessons.lesson19;

public class Apple extends Fruit {
  private static final double DEFAULT_WEIGHT = 1.0;
  private static final String DEFAULT_NAME = "Apple";

  public Apple() {
    super(DEFAULT_NAME, DEFAULT_WEIGHT);
  }
  @Override
  public double getWeight() {
    return DEFAULT_WEIGHT;
  }
}