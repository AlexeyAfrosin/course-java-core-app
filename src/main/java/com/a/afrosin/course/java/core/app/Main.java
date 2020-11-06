package com.a.afrosin.course.java.core.app;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Результат задания 1: " + Arrays.toString(task_1(new int[]{1, 2, 3, 4, 3})));
        System.out.println("Результат задания 2: " + task_2(new int[]{1, 1, 4, 4, 1}));

    }

    public static int[] task_1(int[] arr) {
        int idx = -1;
        final int FIND_DIG = 4;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == FIND_DIG) {
                idx = i;
                break;
            }
        }
        if (idx > -1) {
            // берем следующий после FIND_DIG элемент
            idx += 1;
            if (idx == arr.length) {
                return new int[0];
            } else {
                return Arrays.copyOfRange(arr, idx, arr.length);
            }

        } else {
            throw new RuntimeException("Array mush have digit " + FIND_DIG);
        }
    }

    public static boolean task_2(int[] arr) {
        final int FIND_DIG_4 = 4;
        final int FIND_DIG_1 = 1;
        int idx_4 = -1;
        int idx_1 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == FIND_DIG_1) {
                idx_1 = i;
            } else if (arr[i] == FIND_DIG_4) {
                idx_4 = i;
            } else {
                return false;
            }
        }

        return idx_4 >= 0 && idx_1 >= 0;
    }
}
