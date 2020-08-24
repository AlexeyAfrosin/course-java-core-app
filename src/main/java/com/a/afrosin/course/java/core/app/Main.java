package com.a.afrosin.course.java.core.app;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task1() {
        printText("задание 1");

        int[] arr = new int[8];

        // заполняем массив
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2 == 0 ? 1 : 0;
        }
        printText(String.format("Массив до изменения %s", Arrays.toString(arr)));

        // меняем 0 на 1, 1 на 0
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        printText(String.format("Массив после изменения %s", Arrays.toString(arr)));
    }

    public static void task2() {
        printText("\nзадание 2");
        int[] arr = new int[8];

        // заполняем массив
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        printText(String.format("Результирующий массив %s", Arrays.toString(arr)));
    }

    public static void task3() {
        printText("\nзадание 3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printText(String.format("Массив до изменения %s", Arrays.toString(arr)));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
        printText(String.format("Результирующий массив %s", Arrays.toString(arr)));
    }

    public static void task4() {
        printText("\nзадание 4");
        int[][] arr = new int[4][4];

        printText("Массив до изменения");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }
        printArr(arr);

        printText("Массив после изменения");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i + j == arr[i].length - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        printArr(arr);
    }

    public static void task5() {
        printText("\nзадание 5");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printText(String.format("Массив %s", Arrays.toString(arr)));

        printText(String.format("Минимальный элемент %d", arrayMinValue(arr)));
        printText(String.format("Максимальный элемент %d", arrayMaxValue(arr)));
    }

    public static int arrayMinValue(int[] arr) {
        int minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }

        return minValue;
    }

    public static int arrayMaxValue(int[] arr) {
        int maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    public static void task6() {
        printText("\nзадание 6");
        int[][] arr = {{1, 1, 1, 2, 1},
                {2, 2, 2, 1, 2, 2, 10, 1},
                {10, 1, 2, 2, 2, 1, 2, 2},
                {110, 1, 2, 2, 2, 1, 2, 2},
        };
        for (int[] item : arr) {
            printText(String.format("Массив %s", Arrays.toString(item)));
            printText(String.format("Есть место, в котором сумма левой и правой части массива равны?\nОтвет: %b", checkBalance(item)));
        }

    }

    public static boolean checkBalance(int[] arr) {
        boolean result = false;
        int sumLeft = 0;
        int sumRight;

        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            sumRight = 0;

            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }

            if (sumLeft == sumRight) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void task7() {
        printText("\nзадание 7");
        int[][] arr = {{1, 2, 3, 4},
                {1, 2, 3},
                {3, 5, 6, 1}
        };
        int[] arrN = {-3, -2, -1, 0, 1, 3};
        for (int n : arrN) {
            for (int[] item : arr) {
                printText(String.format("Массив %s до сдвига на %d элемента(ов)", Arrays.toString(item), n));
                shiftArr(item, n);
                printText("");
            }
        }

    }

    public static void shiftArr(int[] arr, int n) {
        if (n > 0) {
            shiftArrRight(arr, n);
        } else {
            shiftArrLeft(arr, n);
        }
    }

    public static void shiftArrRight(int[] arr, int n) {
        printText("Сдвиг вправо");
        int tmp1;
        int j;
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < n; i++) {
            tmp1 = tmpArr[tmpArr.length - 1];
            for (j = tmpArr.length - 1; j >= 1; j--) {
                tmpArr[j] = tmpArr[j - 1];
            }
            tmpArr[j] = tmp1;
        }
        printText(String.format("Массив после сдвига %s", Arrays.toString(tmpArr)));
    }

    public static void shiftArrLeft(int[] arr, int n) {
        printText("Сдвиг влево");
        int tmp1;
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < Math.abs(n); i++) {
            tmp1 = tmpArr[0];
            for (int j = 0; j < tmpArr.length - 1; j++) {
                tmpArr[j] = tmpArr[j + 1];
            }
            tmpArr[tmpArr.length - 1] = tmp1;
        }
        printText(String.format("Массив после сдвига %s", Arrays.toString(tmpArr)));
    }

    public static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%-2s", anInt);
            }
            System.out.println();
        }
    }

    public static void printText(String text) {
        System.out.println(text);
    }
}
