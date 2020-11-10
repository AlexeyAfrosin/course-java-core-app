package com.a.afrosin.course.java.core.app;

public class Test3 {
    private String testName;
    private int priority;

    public Test3(String testName, int priority) {
        this.testName = testName;
        this.priority = priority;
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("method beforeSuite");
    }

    @AfterSuite
    public static void afterSuite_1() {
        System.out.println("method afterSuite_1");
    }

    @Test
    public static void print() {
        System.out.println("method print");
    }

    @Test(priority = 2)
    public static void print1() {
        System.out.println("method print_1");
    }

    @Test(priority = 3)
    public static void print2() {
        System.out.println("method print_2");
    }

    @Test
    public static void print3() {
        System.out.println("method print_3");
    }

}
