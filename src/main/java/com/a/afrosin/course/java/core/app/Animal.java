package com.a.afrosin.course.java.core.app;

public class Animal {
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private static int animalCount = 0;

    public static int getAnimalCount() {
        return animalCount;
    }

    private static void incAnimalCount() {
        animalCount += 1;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        incAnimalCount();
    }

    public void run(int distance){
        if( this.maxRunDistance <= 0){
            System.out.printf("%s не умеет бегать.\n", this.name);
        }
        else if (distance > this.maxRunDistance){
            System.out.printf("%s не может пробежать %d м. Максимальное расстояние для бега %d м.\n", this.name, distance, this.maxRunDistance);
        }
        else{
            System.out.printf("%s пробежал %d м\n", this.name, distance);
        }
    }

    public void swim(int distance){
        if( this.maxSwimDistance <= 0){
            System.out.printf("%s не умеет плавать.\n", this.name);
        }
        else if (distance > this.maxSwimDistance){
            System.out.printf("%s не может проплыть %d м. Максимальное расстояние для плавания %d м.\n", this.name, distance, this.maxSwimDistance);
        }
        else{
            System.out.printf("%s проплыл %d м\n", this.name, distance);
        }
    }
}
