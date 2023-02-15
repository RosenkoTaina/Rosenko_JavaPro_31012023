package com.hillel.rosenko.lessons.lesson3;

import com.hillel.rosenko.lessons.lesson3.task1.SameName;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("BMW");
        System.out.println(car.modelName);

        car.start();
        car.stop();

      Employee employee = new Employee()
              .setName("Roman")
              .setMiddleName("Ivanovych")
              .setSurname("Tsisaryk")
              .setPosition("engineer")
              .setEmail("romanroman@post.com")
              .setPhone("+44452045221")
              .setAge(31);

        employee.displayInfo();

        SameName sameName = new SameName("test");
        sameName.printName();

        com.hillel.rosenko.lessons.lesson3.task2.SameName sameName1 = new com.hillel.rosenko.lessons.lesson3.task2.SameName("test2");
        sameName1.printName();


    }


}
