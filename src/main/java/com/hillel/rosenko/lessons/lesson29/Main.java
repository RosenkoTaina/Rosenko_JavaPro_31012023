package com.hillel.rosenko.lessons.lesson29;

public class Main {
  public static void main(String[] args) {

    CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

    coffeeOrderBoard.addOrder("Petro");
    coffeeOrderBoard.addOrder("Petro2");
    coffeeOrderBoard.addOrder("Petro3");

    coffeeOrderBoard.deliver();
    coffeeOrderBoard.deliver(2);
    coffeeOrderBoard.draw();
  }
}
