package com.a.afrosin.course.java.core.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("======================================Задание 2======================================");
        String[] words = {
                "абонемент",
                "абсолютный",
                "авиамодель",
                "авиация",
                "автобиография",
                "автобиография",
                "автомобиль",
                "автомат",
                "агитатор",
                "агрегат",
                "агрессор",
                "агрессор",
                "агроном",
                "администрация",
                "администрация",
                "адмирал",
                "адъютант",
                "академик",
                "аквариум",
                "аккомпанемент",
                "аккумулятор",
                "аккуратный"
        };

        System.out.println("Список слов: " + Arrays.toString(words));

        Map<String, Integer> uniqueWords = new HashMap<>();
        int count;
        for (String word : words) {
            count = uniqueWords.getOrDefault(word, 0) + 1;
            uniqueWords.put(word, count);
        }
        System.out.println("Уникальные слова: " + uniqueWords.keySet());
        System.out.println("Слово\tколичество");

        for (String uniqueWord : uniqueWords.keySet()) {
            System.out.printf("%s\t%d\n", uniqueWord, uniqueWords.get(uniqueWord));
        }
    }

    private static void task2() {
        System.out.println("======================================Задание 2======================================");
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "123");
        phoneBook.add("Иванов", "123");
        phoneBook.add("Иванов", "666");
        phoneBook.add("Сидоров", "2345");

        HashSet<String> phones;
        String[] fioArray = {"Иванов", "Петров", "Сидоров"};

        for (String fio: fioArray) {
            System.out.printf("==================ФИО '%s'==================\n", fio);
            phones = phoneBook.get(fio);

            if (phones.size() > 0) {
                System.out.println("Список номеров:");
                for (String phone : phones) {
                    System.out.println(phone);
                }
            } else {
                System.out.println("Номера не найдены");
            }
        }
    }
}
