package com.a.afrosin.course.java.core.app;

public interface Obstruction {
    boolean forRun();
    boolean forJump();

    default int getHeight(){
        return 0;
    }
    default int getDistance(){
        return 0;
    }
}
