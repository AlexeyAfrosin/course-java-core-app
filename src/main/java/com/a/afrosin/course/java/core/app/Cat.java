package com.a.afrosin.course.java.core.app;

public class Cat extends Animal {
    static final int MAX_RUN_DISTANCE = 200;
    static final int MAX_SWIM_DISTANCE = 0;
    private static int catCount = 0;

    public static int getCatCount() {
        return catCount;
    }

    private static void incCatCount() {
        catCount += 1;
    }

    public Cat(String name) {
        super(name, MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE);
        incCatCount();
    }
}
