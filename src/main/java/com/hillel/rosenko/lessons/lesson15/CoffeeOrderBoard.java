package com.hillel.rosenko.lessons.lesson15;

import java.util.Deque;
import java.util.LinkedList;

public class CoffeeOrderBoard {
  private final Deque<Order> orderList;
  private int orderNumber;
  private CustomerInputHandler inputHandler;

  public CoffeeOrderBoard() {
    orderList = new LinkedList<>();
    orderNumber = 1;
    inputHandler = new CustomerInputHandler();
  }

//  public void addOrder() throws IllegalArgumentException {
//    String nameOfCustomer = inputHandler.getNameOfCustomer();
//    Order order = new Order(orderNumber, nameOfCustomer);
//    orderList.addLast(order);
//    orderNumber++;
//  }

  public void addOrder(String customer) throws IllegalArgumentException {
    Order order = new Order(orderNumber, customer);
    orderList.addLast(order);
    orderNumber++;
  }

  public Order deliver() {
    if (!orderList.isEmpty()) {
      return orderList.removeFirst();
    } else {
      return null;
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

  public int getOrderListSize() {
    return orderList.size();
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