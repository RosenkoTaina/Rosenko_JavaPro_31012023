package com.hillel.rosenko.lessons.lesson19;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

  public class FruitBoxTest {

   @Test
   public void testAppleGetName() {
    Apple apple = new Apple();
    Assertions.assertEquals("Apple", apple.getName());
   }

   @Test
   public void testAppleGetWeight() {
    Apple apple = new Apple();
    Assertions.assertEquals(1.0, apple.getWeight(), 0.0);
   }

   @Test
   public void testOrangeGetName() {
    Orange orange = new Orange();
    Assertions.assertEquals("Orange", orange.getName());
   }

   @Test
   public void testOrangeGetWeight() {
    Orange orange = new Orange();
    Assertions.assertEquals(1.5, orange.getWeight(), 0.0);
   }

   @Test
   public void testBoxAddFruit() {
    Box<Fruit> box = new Box<>();
    Apple apple = new Apple();
    box.addFruit(apple);
    Assertions.assertEquals(1.0, box.getWeight(), 0.0);
   }

   @Test
   public void testBoxAddFruits() {
    Box<Fruit> box = new Box<>();
    Apple apple = new Apple();
    box.addFruits(apple, 3);
    Assertions.assertEquals(3.0, box.getWeight(), 0.0);
   }

   @Test
   public void testBoxAddFruitsNegativeValue() {
    Box<Fruit> box = new Box<>();
    Apple apple = new Apple();
    assertThrows(IllegalArgumentException.class, () -> {
    box.addFruits(apple, -1);
    });
   }


   @Test
   public void testBoxRemoveFruit() {
    Box<Fruit> box = new Box<>();
    Apple apple = new Apple();
    box.addFruit(apple);
    box.removeFruit(apple);
    Assertions.assertEquals(0.0, box.getWeight(), 0.0);
   }

   @Test
   public void testBoxGetWeight() {
    Box<Fruit> box = new Box<>();
    Apple apple = new Apple();
    box.addFruit(apple);
    Assertions.assertEquals(1.0, box.getWeight(), 0.0);
   }

   @Test
   public void testBoxCompare() {
    Box<Fruit> box1 = new Box<>();
    Apple apple = new Apple();
    box1.addFruit(apple);
    Box<Fruit> box2 = new Box<>();
    Orange orange = new Orange();
    box2.addFruit(orange);
    Assertions.assertFalse(box1.compare(box2));
    Assertions.assertTrue(box1.compare(box1));
   }
  }
