package com.hillel.rosenko.lessons.lesson15;

import java.io.OutputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CoffeeOrderBoard {
  private final Deque<Order> orderList;
  private int orderNumber;

  public CoffeeOrderBoard() {
    orderList = new LinkedList<>();
    orderNumber = 1;
  }

  public String getNameOfCustomer() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name:");
    return sc.nextLine();
  }

  public void addOrder() throws IllegalArgumentException {
    String nameOfCustomer = getNameOfCustomer();

    for (Order order : orderList) {
      if (order.getName().equals(nameOfCustomer)) {
        throw new IllegalArgumentException("Duplicate order for customer: " + nameOfCustomer);
      }
    }

    Order order = new Order(orderNumber, nameOfCustomer);
    orderList.addLast(order);
    orderNumber++;
  }

//  public Order deliver() {
//    if (!orderList.isEmpty()) {
//      return orderList.removeFirst();
//    }
//    return null;
//  }


  public void deliver() {
    if (!orderList.isEmpty()) {
      Order nextOrder = orderList.pollFirst();
      System.out.println("Next order to deliver: " + nextOrder);
    } else {
      System.out.println("No orders to deliver.");
    }
  }

  public Order deliver(int orderNumber) {
    for (Order order : orderList) {
      if (order.getOrder() == orderNumber) {
        orderList.remove(order);
        return order;
      }
    }
    return null;
  }

  public void draw() {
    System.out.println("==========================");
    System.out.println("Num\t| Name");
    System.out.println("==========================");

    for (Order order : orderList) {
      System.out.println(order.getOrder() + "\t| " + order.getName());
    }

    System.out.println("==========================");
  }
}