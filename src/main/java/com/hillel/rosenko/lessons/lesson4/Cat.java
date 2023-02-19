package com.hillel.rosenko.lessons.lesson4;

public class Cat extends Animal{
    static int noOfCats = 0;
    int runDistance;

    public Cat(String name, int runDistance) {
        super(name);
        this.runDistance = runDistance;
        System.out.println("Cat " + name);
    }


    public int getRunDistance() {
        if (runDistance < 0 || runDistance > 200) {
            throw new IllegalArgumentException("cat cant run so far");
        } else return runDistance;
    }


    static {
        noOfCats += 1;
    }
    @Override
    public void run() {
        System.out.println(getName() + " run " + getRunDistance() + " meters");
    }


    @Override
    public void swim() {
        System.out.println(getName() + " can`t swim " );
    }


}



