package com.hillel.rosenko.lessons.lesson29;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {
  private int order;
  private String name;

  public Order(int order, String name) {
    this.order = order;
    this.name = name;
  }


}