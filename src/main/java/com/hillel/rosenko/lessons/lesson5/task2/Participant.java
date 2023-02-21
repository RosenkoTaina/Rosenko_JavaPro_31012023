package com.hillel.rosenko.lessons.lesson5.task2;

 abstract class Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getName() {
        return name;
    }

    public boolean run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(this.name + " has run " + distance + " meters.");
            return true;
        } else {
            System.out.println(this.name + " couldn't run " + distance + " meters.");
            return false;
        }
    }

    public boolean jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(this.name + " has jumped " + height + " meters high.");
            return true;
        } else {
            System.out.println(this.name + " couldn't jump " + height + " meters high.");
            return false;
        }
    }
}

