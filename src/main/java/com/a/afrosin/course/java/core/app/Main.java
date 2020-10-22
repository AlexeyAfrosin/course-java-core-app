package com.a.afrosin.course.java.core.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] stringArr = {"one", "two", "three", "four"};
        Integer[] integerArr = {1, 2, 3, 4};
        Boolean[] booleanArr = {false, true, false, true};
        System.out.println("=====================================Задание 1=========================");
        task1(stringArr, 1, 2);
        task1(integerArr, 0, 3);
        task1(booleanArr, 2, 3);

        System.out.println("=====================================Задание 2=========================");
        ArrayList<String> stringArrayList = task2(stringArr);
        ArrayList<Integer> integerArrayList = task2(integerArr);
        ArrayList<Boolean> booleanArrayList = task2(booleanArr);

        System.out.printf("массив %s после: %s\n", stringArrayList.getClass().getName(), Arrays.toString(stringArr));
        System.out.printf("массив %s после: %s\n", integerArrayList.getClass().getName(), Arrays.toString(integerArr));
        System.out.printf("массив %s после: %s\n", booleanArrayList.getClass().getName(), Arrays.toString(booleanArr));

        System.out.println("=====================================Задание 3=========================");
        task3();
    }

    private static <T> void task1(T[] arr, int firstIdx, int lastIdx) {
        if (arr.length > 0 && firstIdx >= 0 && firstIdx <= arr.length && lastIdx >= 0 && lastIdx <= arr.length) {
            System.out.printf("массив %s до: %s\n", arr.getClass().getName(), Arrays.toString(arr));
            T tmpT = arr[lastIdx];
            arr[lastIdx] = arr[firstIdx];
            arr[firstIdx] = tmpT;
            System.out.printf("массив %s после: %s\n", arr.getClass().getName(), Arrays.toString(arr));
        } else {
            System.out.println("Параметры заданы не верно");
        }
    }

    private static <T> ArrayList<T> task2(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    private static void task3() {
        Apple[] apples = {
                new Apple(),
                new Apple(),
                new Apple()
        };
        Orange[] oranges = {
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange()
        };
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBoxForPour = new Box<>();

        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBoxForPour = new Box<>();

        for (Apple apple : apples) {
            appleBox.put(apple);
        }

        for (Orange orange : oranges) {
            orangeBox.put(orange);
        }

        System.out.printf("В коробке %d яблока\n", appleBox.getCount());
        System.out.printf("Вес коробки с яблоками %.2f\n", appleBox.getWeight());

        System.out.printf("В коробке %d апельсина\n", orangeBox.getCount());
        System.out.printf("Вес коробки с апельсинами %.2f\n", orangeBox.getWeight());

        System.out.println("=====================================Сравниваем коробки=========================");
        System.out.printf("Вес коробки с яблоками равен весу коробки с апельсинами?\nОтвет: %b\n", appleBox.compare(orangeBox));

        System.out.println("=====================================Пересыпаем яблоки=========================");
        System.out.println("=====================================До пересыпания яблок=========================");
        System.out.printf("В коробке appleBoxForPour %d яблока\n", appleBoxForPour.getCount());
        System.out.printf("Вес коробки appleBoxForPour %.2f\n", appleBoxForPour.getWeight());

        appleBox.pourFruits(appleBoxForPour);
        System.out.println("=====================================После пересыпания яблок=========================");
        System.out.printf("В коробке appleBoxForPour %d яблока\n", appleBoxForPour.getCount());
        System.out.printf("Вес коробки appleBoxForPour %.2f\n", appleBoxForPour.getWeight());
        System.out.printf("В коробке %d яблока\n", appleBox.getCount());
        System.out.printf("Вес коробки с яблоками %.2f\n", appleBox.getWeight());

        System.out.println("=====================================Пересыпаем апельсины=========================");
        System.out.println("=====================================До пересыпания апельсинов=========================");
        System.out.printf("В коробке orangeBoxForPour %d апельсинов\n", orangeBoxForPour.getCount());
        System.out.printf("Вес коробки orangeBoxForPour %.2f\n", orangeBoxForPour.getWeight());

        orangeBox.pourFruits(orangeBoxForPour);

        System.out.println("=====================================После пересыпания яблок=========================");
        System.out.printf("В коробке orangeBoxForPour %d апельсинов\n", orangeBoxForPour.getCount());
        System.out.printf("Вес коробки orangeBoxForPour %.2f\n", orangeBoxForPour.getWeight());
        System.out.printf("В коробке %d апельсина\n", orangeBox.getCount());
        System.out.printf("Вес коробки с апельсинами %.2f\n", orangeBox.getWeight());

    }
}
