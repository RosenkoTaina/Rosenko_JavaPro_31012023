package com.hillel.rosenko.lessons.lesson4;

public class Cat extends Animal{

    int runDistance;

    public Cat(String name, int runDistance) {
        super(name);
        this.runDistance = runDistance;
        System.out.println("Cat " + super.name);
    }


    public int getRunDistance() {
        if (runDistance < 0 || runDistance > 200) {
            throw new IllegalArgumentException("cat cant run so far");
        } else return runDistance;
    }

    @Override
    public void run() {
        System.out.println(name + " run " + getRunDistance() + " meters");
    }


    @Override
    public void swim() {
        System.out.println(name + " can`t swim " );
    }

}



