package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {
        Class[] tests = {Test1.class, Test2.class, Test3.class};

        for (Class testClass : tests) {
            try {
                TestRunner.start(testClass);
            } catch (Exception e) {
                System.err.println("================" + testClass.getName() + "============================");
                System.err.println("=======================================================================");
                e.printStackTrace();
                System.err.println("=======================================================================");
            }
        }

    }
}
