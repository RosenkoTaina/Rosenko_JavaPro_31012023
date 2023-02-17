package com.hillel.rosenko.lessons.lesson4;

public class Main {
    public static void main(String[] args) {
Dog bob = new Dog("bob", 10, 100);
bob.setRunDistance();
bob.setSwimDistance();
bob.run();
bob.swim();
Cat tom = new Cat("tom",40);
tom.getRunDistance();
tom.run();
tom.swim();
    }
}
