package com.a.afrosin.course.java.core.app;

public class Test1 {
    private String testName;
    private int priority;

    public Test1(String testName, int priority) {
        this.testName = testName;
        this.priority = priority;
    }

    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("method beforeSuite");
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("method afterSuite");
    }

    @Test
    public static void print(){
        System.out.println("method print");
    }

    @Test(priority = 3)
    public static void print1(){
        System.out.println("method print_1" );
    }

    @Test(priority = 2)
    public static void print2(){
        System.out.println("method print_2");
    }

    @Test
    public static void print3(){
        System.out.println("method print_3");
    }

}
