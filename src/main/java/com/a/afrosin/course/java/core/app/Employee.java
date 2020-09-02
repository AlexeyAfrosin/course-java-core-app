package com.a.afrosin.course.java.core.app;

public class Employee {
    private String fio;
    private String post;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Employee(String fio, String post, String email, String phone, float salary,int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void print(){
        System.out.println("ФИО: " + this.fio);
        System.out.println("Должность: " + this.post);
        System.out.println("E-mail: " + this.email);
        System.out.println("Телефон: " + this.phone);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
    }

    public int getAge() {
        return age;
    }
}