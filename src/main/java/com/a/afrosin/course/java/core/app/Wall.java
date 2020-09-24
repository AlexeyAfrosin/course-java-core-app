package com.a.afrosin.course.java.core.app;

public class Wall implements Obstruction{
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean forRun() {
        return false;
    }

    @Override
    public boolean forJump() {
        return true;
    }
}
