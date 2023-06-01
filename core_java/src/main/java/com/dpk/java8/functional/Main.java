package com.dpk.java8.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));

        //.anyMatch(p -> p.getCountry().equals("Canada"));
        boolean anyCanadian = list.stream().anyMatch(p -> p.getCountry().equals("Canada"));

        System.out.println("Is there any resident of Canada: " + anyCanadian);

        List<Employee> list1 = new ArrayList<>();
        list1.sort(Comparator.comparing(emp -> emp.country));

    }

    public Map<String, List<Employee>> mapByCountry(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry));
    }

    public double findAverageSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToInt(Employee::getSalary).average().getAsDouble();
    }

    public List<Employee> findEmployeeInUSAWithSalaryGT40000(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(emp -> "USA".equals(emp.getCountry()))
                .filter(emp -> emp.getSalary() > 40000)
                .collect(Collectors.toList());
    }

    public Employee getUSAEmployeeWithHighestSalary(List<Employee> employeeList) {
        Employee employee = employeeList.stream()
                .filter(emp -> "USA".equals(emp.getCountry()))
                .max(Comparator.comparingInt(Employee::getSalary))
                .get();

        List<Employee> employees = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .limit(3).collect(Collectors.toList());



        return employee;
    }

}


class Person {
    String name;
    int age;
    String country;

    Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

}

class Employee {

    String name;
    int age;
    String country;
    int salary;

    public Employee(String name, int age, String country) {
        super();
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public int getSalary() {
        return salary;
    }
}


