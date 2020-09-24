package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {

        Action[] actions = {new Human(2, 100),
                new Robot(3, 1000),
                new Cat(5, 10),
        };

        Obstruction[] obstructions = {
                new RunningTrack(20),
                new Wall(3),
                new RunningTrack(40),
                new Wall(1)
        };


        for (Obstruction obstruction : obstructions) {
            System.out.println("=====================================");
            for (Action action : actions) {
                if (!action.getOutOfGame()) {
                    action.passObstacle(obstruction);
                }
            }
        }

        System.out.println("=========Количество часов оставшихся рабочих часов========");
        for (DayOfWeek day: DayOfWeek.values()) {
            System.out.println(DayOfWeek.getWorkingHours(day));
        }
    }

}
