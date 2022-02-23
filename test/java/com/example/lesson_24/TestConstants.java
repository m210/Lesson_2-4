package com.example.lesson_24;

import java.util.List;
import java.util.Map;

public class TestConstants {

    public static final Employee EMPLOYEE_1 = new Employee("Bill", "Gates", 10000, 1);
    public static final Employee EMPLOYEE_2 = new Employee("Steve", "Jobs", 30000, 2);
    public static final Employee EMPLOYEE_3 = new Employee("John", "Romero", 20000, 2);
    public static final Employee EMPLOYEE_4 = new Employee("John", "Carmack", 50000, 4);
    public static final Employee EMPLOYEE_5 = new Employee("Gabe", "Newell", 30000, 5);

    public static final List<Employee> EMPLOYEE_LIST = List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3, EMPLOYEE_4, EMPLOYEE_5);

    public static final List<Employee> EMPTY_LIST = List.of();

    public static final Map<Integer, List<Employee>> EMPLOYEE_MAP = Map.of(
            1, List.of(EMPLOYEE_1),
            2, List.of(EMPLOYEE_2, EMPLOYEE_3),
            4, List.of(EMPLOYEE_4),
            5, List.of(EMPLOYEE_5)
    );

}
