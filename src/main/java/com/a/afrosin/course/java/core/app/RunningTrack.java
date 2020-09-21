package com.a.afrosin.course.java.core.app;

public class RunningTrack implements Obstruction{
    private final int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean forRun() {
        return true;
    }

    @Override
    public boolean forJump() {
        return false;
    }
}
