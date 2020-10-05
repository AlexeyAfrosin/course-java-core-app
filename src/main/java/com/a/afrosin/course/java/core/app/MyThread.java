package com.a.afrosin.course.java.core.app;

public class MyThread implements Runnable {
    float[] arr;
    private int startI;
    Thread t;

    public MyThread(String name, int arraySize, int startI) {
        t = new Thread(this, name);
        this.arr = new float[arraySize];
        this.startI = startI;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        if (startI == 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        } else {
            int tmpI;
            for (int i = 0; i < arr.length; i++) {
            tmpI = startI + i;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + tmpI / 5) * Math.cos(0.2f + tmpI / 5) * Math.cos(0.4f + tmpI / 2));
            }
        }
        System.out.println("=========================================");
        System.out.printf("Время работы потока %s: %d\n", t.getName(), System.currentTimeMillis() - startTime);
        System.out.printf("Поток %s завершен\n", t.getName());
    }
}
