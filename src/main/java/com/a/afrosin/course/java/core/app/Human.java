package com.a.afrosin.course.java.core.app;

public class Human implements Action  {

    private final Param param;

    private final String TYPE = "Человек";

    public Human(int maxJumpHeight, int maxRunDistance) {
        this.param = new Param(maxJumpHeight, maxRunDistance, TYPE);
    }

    @Override
    public boolean getOutOfGame() {
        return param.isOutOfGame();
    }

    @Override
    public void setOutOfGame(boolean value) {
        param.setOutOfGame(value);
    }

    @Override
    public String getType() {
        return param.getType();
    }

    @Override
    public int getMaxJumpHeight() {
        return param.getMaxJumpHeight();
    }

    @Override
    public int getMaxRunDistance() {
        return param.getMaxRunDistance();
    }


}
