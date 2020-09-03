package com.a.afrosin.course.java.core.app;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;

    public static int getDogCount() {
        return dogCount;
    }

    public static void incDogCount() {
        dogCount += 1;
    }

    public Dog(String name) {
        super(name, MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE);
        incDogCount();
    }
}
