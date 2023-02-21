package com.hillel.rosenko.lessons.lesson4;

public abstract class Animal {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }

    public abstract void run();
    public abstract void swim();

    public String getName() {
        return name;
    }
}
