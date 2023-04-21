package com.hillel.rosenko.lessons.lesson16.tree;

public class BinaryTree<T extends Comparable<T>> {
  private Node<T> root;

  public void addNode(T element) {
    Node<T> newNode = new Node<>(element);

    if (root == null) {
      root = newNode;
    } else {
      Node<T> focusNode = root;
      Node<T> parent;

      while (true) {
        parent = focusNode;

        if (element.compareTo(focusNode.element) < 0) {
          focusNode = focusNode.left;
          if (focusNode == null) {
            parent.left = newNode;
            return;
          }
        } else {
          focusNode = focusNode.right;
          if (focusNode == null) {
            parent.right = newNode;
            return;
          }
        }
      }
    }
  }

  public void preOrderTraversal(Node<T> focusNode) {
    if (focusNode != null) {
      System.out.print(focusNode.element + " ");
      preOrderTraversal(focusNode.left);
      preOrderTraversal(focusNode.right);
    }
  }

  public Node<T> getRoot() {
    return root;
  }

}


