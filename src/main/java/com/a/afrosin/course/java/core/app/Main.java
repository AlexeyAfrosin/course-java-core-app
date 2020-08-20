package com.a.afrosin.course.java.core.app;

import java.text.Format;

public class Main {
    // задание 1
    public static void main(String[] args) {
        // задание 2
        byte vByte = 1;
        short vShort = 1;
        int vInt = 1;
        long vLong = 1L;
        float vFloat = 1.1f;
        double vDouble = 1.1123;
        char vChar = 'c';
        boolean vBoolean = true;

        printMessage(String.format("Результат задания 3: %.2f", calcExpression(1, 2, 3, 4)));
        printMessage(String.format("Результат задания 4: %b", sumInInterval(10, -1)));
        printMessage(String.format("Результат задания 4: %b", sumInInterval(10, 2)));
        printMessage(String.format("Результат задания 4: %b", sumInInterval(10, 20)));

        calcNumPositiveOrNegative(10);
        calcNumPositiveOrNegative(-1);
        calcNumPositiveOrNegative(0);

        printMessage(String.format("Результат задания 6: %b", numIsNegative(1)));
        printMessage(String.format("Результат задания 6: %b", numIsNegative(-1)));
        printMessage(String.format("Результат задания 6: %b", numIsNegative(0)));

        sayHello("Иван");

        calcLeapYear(400);
        calcLeapYear(100);
        calcLeapYear(2020);
        calcLeapYear(2019);

    }

    // задание 3
    public static double calcExpression(int a, int b, int c, int d){
        return  a *(b + ((double) c / (double) d));
    }

    // задание 4
    public static boolean sumInInterval(int a, int b){
        int sum = a + b;
        return  (10 <= sum && sum <= 20);
    }

    // задание 5
    public static void calcNumPositiveOrNegative(int a){

        String tmp = "положительное";
        if (numIsNegative(a)) {
            tmp = "отрицательное";
        }

        printMessage(String.format("Результат задания 5: число %d - %s", a, tmp));
    }

    // задание 6
    public static boolean numIsNegative(int a){
        return a < 0;
    }

    // задание 7
    public static void sayHello(String name){
        printMessage(String.format("Привет, %s!", name));
    }

    // задание 8
    public static void calcLeapYear(int year){
        String tmp = "не високосный";
        if (year % 4 == 0) {
            if ((year % 100 != 0) || (year % 400 == 0)) {
                tmp = "високосный";
            }
        }
        printMessage(String.format("Результат задания 8: год %d - %s", year, tmp));
    }


    public static void printMessage(String message){
        System.out.println(message);
    }
}
