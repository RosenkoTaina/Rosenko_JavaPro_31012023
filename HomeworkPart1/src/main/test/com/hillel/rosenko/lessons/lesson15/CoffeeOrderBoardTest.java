package main.test.com.hillel.rosenko.lessons.lesson15;

import static org.junit.jupiter.api.Assertions.*;

import com.hillel.rosenko.lessons.lesson15.CoffeeOrderBoard;
import com.hillel.rosenko.lessons.lesson15.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoffeeOrderBoardTest {
  private CoffeeOrderBoard coffeeOrderBoard;

  @BeforeEach
  public void setup() {
    coffeeOrderBoard = new CoffeeOrderBoard();
  }

  @ParameterizedTest
  @ValueSource(strings = {"John", "Alice", "Bob"})
  public void testAddOrder(String customer) {
    coffeeOrderBoard.addOrder(customer);

    assertEquals(1, coffeeOrderBoard.getOrderListSize());
  }


  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void testDeliver(int orderNumber) {
    Order deliveredOrder = coffeeOrderBoard.deliver(orderNumber);

    if (deliveredOrder != null) {
      assertEquals(orderNumber, deliveredOrder.getOrder());
      assertEquals(1, coffeeOrderBoard.getOrderListSize());
    } else {
      assertNull(deliveredOrder);
    }
  }
  @ParameterizedTest
  @ValueSource(strings = {"John", "Alice", "Bob"})
  public void testDeliver(String input) {
    coffeeOrderBoard.addOrder(input);
    Order deliveredOrder = coffeeOrderBoard.deliver();
    assertEquals(input, deliveredOrder.getName());
  }

  @Test
  public void testDraw() {


    coffeeOrderBoard.addOrder("John");
    coffeeOrderBoard.addOrder("Alice");
    coffeeOrderBoard.addOrder("Bob");

    coffeeOrderBoard.draw();


  }
}