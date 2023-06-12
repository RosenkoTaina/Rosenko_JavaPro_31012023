package com.hillel.rosenko.lessons.lesson16;

import com.hillel.rosenko.lessons.lesson16.binary.RecursiveBinarySearchTree;
import com.hillel.rosenko.lessons.lesson16.tree.BinaryTree;

public class Main {

  public static void main(String[] args) {

    RecursiveBinarySearchTree<Integer>
        tree = RecursiveBinarySearchTree.of(8, 3, 10, 1, 6, 14, 4, 7, 13);
    boolean contains = tree.contains(10);
    int size = tree.size();
    int depth = tree.depth();
    System.out.println(contains);
    System.out.println(size);
    System.out.println(depth);
    System.out.println();
    tree.inOrderTraversal(System.out::println);

    System.out.println("----");
    BinaryTree<Integer> tree2 = new BinaryTree<>();
    tree2.addNode(8);
    tree2.addNode(3);
    tree2.addNode(10);
    tree2.addNode(1);
    tree2.addNode(6);
    tree2.addNode(14);
    tree2.addNode(4);
    tree2.addNode(7);
    tree2.addNode(13);


    tree2.preOrderTraversal(tree2.getRoot());
  }
}
