package com.hillel.rosenko.lessons.lesson3;

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
    }


}
