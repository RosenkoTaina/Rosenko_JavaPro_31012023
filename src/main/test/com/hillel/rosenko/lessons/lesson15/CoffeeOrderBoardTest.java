package com.hillel.rosenko.lessons.lesson15;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {
  public static void main(String[] args) {
    CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

    int numberOfOrders = 4;
    for (int i = 0; i < numberOfOrders; i++) {
      coffeeOrderBoard.addOrder();
    }

    coffeeOrderBoard.draw();



    coffeeOrderBoard.deliver();
    coffeeOrderBoard.deliver(3);


    coffeeOrderBoard.draw();
  }
}