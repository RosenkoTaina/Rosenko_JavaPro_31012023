package com.hillel.rosenko.lessons.lesson16.tree;

class Node<T extends Comparable<T>> {
  T element;
  Node<T> left;
  Node<T> right;

  public Node(T element) {
    this.element = element;
  }
}