package com.a.afrosin.course.java.core.app;

public class Fruit<T extends Number> {

    private final T weight;

    public Fruit(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }
}