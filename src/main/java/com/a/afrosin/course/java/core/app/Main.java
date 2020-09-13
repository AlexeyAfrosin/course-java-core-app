package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                    new Cat("Васька", 11),
                    new Cat("Геннадий", 5),
                    new Cat("Борис", 12),
                    new Cat("Марс", 1)
        };

        Plate plate = new Plate(10);
        feedCats(cats, plate);
        plate.increaseFood(20);
        feedCats(cats, plate);
    }

    public static void feedCats(Cat[] cats, Plate plate){
        System.out.println("++++++++++Кормим котов++++++++++");
        plate.info();
        for (Cat cat: cats) {
            cat.eat(plate);
            plate.info();
        }
    }
}
