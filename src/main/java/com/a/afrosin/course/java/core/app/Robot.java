package com.a.afrosin.course.java.core.app;

public class Robot implements Action  {

    private final Param param;
    private final String TYPE = "Робот";

    public Robot(int maxJumpHeight, int maxRunLength) {
        this.param = new Param(maxJumpHeight, maxRunLength, TYPE);
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
        return TYPE;
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
