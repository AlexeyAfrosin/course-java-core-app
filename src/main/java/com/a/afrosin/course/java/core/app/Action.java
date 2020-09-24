package com.a.afrosin.course.java.core.app;

public interface Action {

    String getType();

    int getMaxJumpHeight();

    int getMaxRunDistance();

    boolean getOutOfGame();

    void setOutOfGame(boolean value);

    default void run(int distance) {

        if (getMaxRunDistance() >= distance) {
            System.out.printf("%s пробежал %d метров\n", getType(), distance);
        } else {
            setOutOfGame(true);
            System.out.printf("%s не смог пробежать %d. Максимальное расстояние %d\n", getType(), distance, getMaxRunDistance());
        }

    }

    default void jump(int jumpHeight) {
        if (getMaxJumpHeight() >= jumpHeight) {
            System.out.printf("%s перепрыгнул через стену высотой %d метров\n", getType(), jumpHeight);
        } else {
            setOutOfGame(true);
            System.out.printf("%s не смог перепрыгнуть через стену высотой %d. Максимальная высота %d\n", getType(), jumpHeight, getMaxJumpHeight());
        }
    }

    default void passObstacle(Obstruction obstruction) {
        if (obstruction.forJump()) {
            jump(obstruction.getHeight());
        } else if (obstruction.forRun()) {
            run(obstruction.getDistance());
        }
    }
}
