package com.a.afrosin.course.java.core.app;

public class Main {
    private final Object mon = new Object();
    private volatile char currentLetter  = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        Thread t1 = new Thread(() -> {
            m.printChar('A', 'B');
        });
        Thread t2 = new Thread(() -> {
            m.printChar('B', 'C');
        });
        Thread t3 = new Thread(() -> {
            m.printChar('C', 'A');
        });
        t1.start();
        t2.start();
        t3.start();

    }

    public void printChar(char bakedSymbol, char nextChar) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != bakedSymbol) {
                        mon.wait();
                    }
                    System.out.print(bakedSymbol);
                    currentLetter = nextChar;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
