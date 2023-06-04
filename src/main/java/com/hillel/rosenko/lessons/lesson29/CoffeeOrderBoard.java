package com.hillel.rosenko.lessons.lesson29;

import java.util.Deque;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CoffeeOrderBoard {
  private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

  private final Deque<Order> orderList;
  private int orderNumber;


  public CoffeeOrderBoard() {
    orderList = new LinkedList<>();
    orderNumber = 1;
  }



  public void addOrder(String customer) throws IllegalArgumentException {
    logger.info("Adding order for customer: {}", customer);
    Order order = new Order(orderNumber, customer);
    orderList.addLast(order);
    orderNumber++;
  }

  public Order deliver() {
    logger.info("Delivering order");
    if (!orderList.isEmpty()) {
      return orderList.removeFirst();
    } else {
      return null;
    }
  }

  public Order deliver(int orderNumber) {
    logger.info("Delivering order with number: {}", orderNumber);
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
    logger.info("Drawing coffee order board");
    System.out.println("==========================");
    System.out.println("Num\t| Name");
    System.out.println("==========================");

    for (Order order : orderList) {
      System.out.println(order.getOrder() + "\t| " + order.getName());
    }

    System.out.println("==========================");
  }
}