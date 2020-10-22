package com.a.afrosin.course.java.core.app;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> boxElements;

    public Box() {
        boxElements = new ArrayList<T>();
    }

    public ArrayList<T> getBoxElements() {
        return boxElements;
    }

    public void clearBoxElements() {
        boxElements.clear();
    }

    public double getWeight() {

        if (boxElements.size() > 0) {
            return boxElements.size() * boxElements.get(0).getWeight().doubleValue();
        } else {
            return 0;
        }
    }

    public int getCount() {
        return boxElements.size();
    }

    public void put(T fruit) {
        boxElements.add(fruit);
    }

    public boolean compare(Box otherBox) {
        return getCount() == otherBox.getCount();
    }

    public void addAll(Box<T> sourceBox) {
        boxElements.addAll(sourceBox.getBoxElements());
    }

    public void pourFruits(Box<T> destinationBox) {
        destinationBox.addAll(this);
        this.clearBoxElements();
    }
}