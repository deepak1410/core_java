package com.dpk.collection;

import com.dpk.dto.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeCollectionUtils {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee("Tom", 20, "London"),
                new Employee("Matt", 30, "New York"),
                new Employee("Matt", 40, "New Jersey"),
                new Employee("John", 25, "California")
        ));

        Collections.min(employeeList, Comparator.comparing(Employee::getName));


    }
}
