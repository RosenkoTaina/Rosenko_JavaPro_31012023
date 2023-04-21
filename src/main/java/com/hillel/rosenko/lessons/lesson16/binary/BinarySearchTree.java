package com.hillel.rosenko.lessons.lesson16.binary;

import java.util.function.Consumer;

public interface BinarySearchTree <T extends Comparable<T>> {

  boolean insert(T element);

  boolean contains(T element);

  int size();

  int depth();

  void inOrderTraversal(Consumer<T> consumer);

}
