package com.a.afrosin.course.java.core.app;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void increaseFood(int n) {
        this.food += n;
    }

    public boolean decreaseFood(int n) {
        if (food - n >= 0) {
            food -= n;
            return true;
        }
        else{
            return false;
        }

    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.printf("В тарелке %d еды\n", food);
    }


}
