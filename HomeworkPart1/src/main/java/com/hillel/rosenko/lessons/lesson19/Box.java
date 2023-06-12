package com.hillel.rosenko.lessons.lesson19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> {
  private List<T> fruits;
  public Box() {
    fruits = new ArrayList<>();
  }

  public static <T extends Fruit> Box<T> merge(Box<T> firstBox, Box<? extends T> secondBox) {
    if (firstBox.getClass() != secondBox.getClass()) {
      throw new IllegalArgumentException("Cannot merge boxes with different fruit types.");
    }

    Box<T> newBox = new Box<>();
    newBox.fruits.addAll(firstBox.fruits);
    newBox.fruits.addAll(secondBox.fruits);
    firstBox.fruits.clear();
    secondBox.fruits.clear();
    return newBox;
  }

  public void addFruit(T fruit) throws IllegalArgumentException {
    if (fruit instanceof Apple || fruit instanceof Orange) {
      fruits.add(fruit);
    } else {
      throw new IllegalArgumentException("Can only add fruit to the box.");
    }
  }

  public void addFruits(T fruit, int value) {
    if (value < 0) {
      throw new IllegalArgumentException("Fruit amount cannot be negative.");
    } else {
      for (int i = 0; i < value; i++) {
        fruits.add(fruit);
      }
    }
  }

  public void removeFruit(T fruit) {
    fruits.remove(fruit);
  }

  public double getWeight() {
    double totalWeight = 0;
    for (T fruit : fruits) {
      totalWeight = fruits.size() * fruit.getWeight();
    }
    return totalWeight;

  }

  public boolean compare(Box<?> otherBox) {
    return Math.abs(getWeight() - otherBox.getWeight()) < 0.0001;
  }

}


