package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Васька");
        Cat catGennady = new Cat("Геннадий");
        Dog dog = new Dog("Палкан");
        Dog dogSharik = new Dog("Шарик");
        Dog dogDruzhek = new Dog("Дружек");

        System.out.println("===========================================");
        System.out.println("задание 2");
        System.out.println("===========================================");
        System.out.println("коты");
        System.out.println("===========================================");
        cat.run(10);
        cat.run(100);
        cat.run(500);

        System.out.println("===========================================");
        System.out.println("собаки");
        System.out.println("===========================================");
        dog.run(10);
        dog.run(500);
        dog.run(1000);
        System.out.println("===========================================");
        System.out.println("задание 3");
        System.out.println("===========================================");
        System.out.println("коты");
        System.out.println("===========================================");
        cat.swim(10);
        cat.swim(100);
        System.out.println("===========================================");
        System.out.println("собаки");
        System.out.println("===========================================");
        dog.swim(10);
        dog.swim(500);
        System.out.println("===========================================");
        System.out.println("задание 4");
        System.out.println("===========================================");
        System.out.printf("Количество созданных котов %d\n", Cat.getCatCount());
        System.out.printf("Количество созданных собак %d\n", Dog.getDogCount());
        System.out.printf("Количество созданных животных %d\n", Animal.getAnimalCount());

    }
}
