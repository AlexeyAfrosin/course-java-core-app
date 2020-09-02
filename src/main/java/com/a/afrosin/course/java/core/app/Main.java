package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов И.И.", "Директор", "i.ivanov@company.com", "9000000000", 5000F, 41),
                new Employee("Петров П.П.", "Зам. директора", "p.petrov@company.com", "9000000001", 4000F, 39),
                new Employee("Сидоров С.С.", "Водитель", "s.sidorov@company.com", "9000000002", 1000F, 30),
                new Employee("Козлов К.К.", "Сторож", "k.kozlov@company.com", "9000000003", 500F, 52),
                new Employee("Булкин Б.Б.", "Клининг менеджер", "b.bulkin@company.com", "9000000004", 7000F, 38)
        };

        for (Employee employee: employees) {
            if (employee.getAge() > 40){
                System.out.println("==================================");
                employee.print();
            }
        }
    }
}
