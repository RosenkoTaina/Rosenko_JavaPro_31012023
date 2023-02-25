package com.hillel.rosenko.lessons.lesson4;
public class Track extends Obstacle {
    public Track(int length) {
        super(length);
    }

    public void overcome(Animal animal) {
        animal.run(this.getLength());
    }
}