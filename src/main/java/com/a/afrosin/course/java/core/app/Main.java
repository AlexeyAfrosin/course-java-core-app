package com.a.afrosin.course.java.core.app;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10000000;
        final int PART_COUNT = 5;
        float[] arrMethod1;
        float[] arrMethod2;
        if (ARRAY_SIZE % PART_COUNT == 0) {
            arrMethod1 = method_1(ARRAY_SIZE);
            arrMethod2 = method_2(ARRAY_SIZE, PART_COUNT);

            System.out.println("=========================================");
            if (Arrays.equals(arrMethod1, arrMethod2)) {
                System.out.println("Массивы равны");
            } else {
                System.out.println("Массивы не равны");
            }
        }else{
            System.out.println("Размер массива должен делиться на количество частей без остатка");
        }

    }

    private static float[] method_1(int arraySize) {
        System.out.println("=========================================");
        float[] arr = new float[arraySize];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы метода 1: " + (System.currentTimeMillis() - startTime));
        return arr;
    }

    private static float[] method_2(int arraySize, int partCount) {
        float[] sourceArr = new float[arraySize];
        int partSize = arraySize / partCount;


        MyThread[] tArray = new MyThread[partCount];

        Arrays.fill(sourceArr, 1);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread("ArrPart " + (i + 1), partSize, i * partSize);
            System.arraycopy(sourceArr, i * partSize, tArray[i].arr, 0, partSize);
            tArray[i].t.start();
        }

        try {
            for (MyThread myThread : tArray) {
                myThread.t.join();
            }

        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        for (int i = 0; i < tArray.length; i++) {
            System.arraycopy(tArray[i].arr, 0, sourceArr, i * partSize, partSize);
        }

        System.out.println("=========================================");
        System.out.println("Время работы метода 2: " + (System.currentTimeMillis() - startTime));
        System.out.println("Главный метод завершен");
        return sourceArr;
    }

}
