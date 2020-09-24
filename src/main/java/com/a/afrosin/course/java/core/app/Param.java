package com.a.afrosin.course.java.core.app;

public class Param {
    private final int maxJumpHeight;
    private final int maxRunLength;
    private final String type;
    private boolean outOfGame;

    public Param(int maxJumpHeight, int maxRunLength, String type) {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.type = type;
        this.outOfGame = false;
    }

    public boolean isOutOfGame() {
        return outOfGame;
    }

    public void setOutOfGame(boolean outOfGame) {
        this.outOfGame = outOfGame;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxRunDistance() {
        return maxRunLength;
    }

    public String getType() {
        return type;
    }

}
