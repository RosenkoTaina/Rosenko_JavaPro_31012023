package com.hillel.rosenko.lessons.lesson5.task2;

public class Main {	public static void main(String[] args) {
    Participant[] participants = {
            new Cat("Barsik", 2, 1),
            new Human("Ivan", 4, 2),
            new Robot("T800", 10, 5)
    };

    Obstacle[] obstacles = {
            new RunningTrack(5),
            new Wall(2),
            new RunningTrack(10),
            new Wall(4)
    };


    for (Participant participant : participants) {
        boolean isParticipantWin = true;
        for (Obstacle obstacle : obstacles) {
            if (obstacle instanceof RunningTrack) {
                if (!participant.run(obstacle.getLength())) {
                    isParticipantWin = false;
                    break;
                }
            } else if (obstacle instanceof Wall) {
                if (!participant.jump(obstacle.getHeight())) {
                    isParticipantWin = false;
                    break;
                }
            }
        }
        if (isParticipantWin) {
            System.out.println(participant.getName() + " has finished the obstacle course!");
        } else {
            System.out.println(participant.getName() + " failed to finish the obstacle course.");
        }
    }
}
}


