package com.hillel.rosenko.lessons.lesson4;

public class Dog extends Animal {
    int swimDistance;
    int runDistance;

    public Dog(String name, int swimDistance, int runDistance) {
        super(name);
        this.swimDistance = swimDistance;
        this.runDistance = runDistance;
        System.out.println("Dog " + name);
    }

    public int getSwimDistance() {
        if (swimDistance < 0 || swimDistance > 10) {
            throw new IllegalArgumentException("dog cant swim so far");
        } else return swimDistance;
    }
        public int getRunDistance() {
            if (runDistance < 0 || runDistance > 500) {
                throw new IllegalArgumentException("dog cant run so far");
            } else return runDistance;
        }


    @Override
        public void run() {
        System.out.println(getName() + " run " + getRunDistance() + " meters");
        }


        @Override
        public void swim() {
            System.out.println (getName() + " swim " + getSwimDistance() + " meters");
        }

    }

