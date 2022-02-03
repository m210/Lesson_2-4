package com.example.lesson_24;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> map = new HashMap<>();

    public EmployeeService() {
        addEmployee("Bill", "Gates");
        addEmployee("Steve", "Jobs");
        addEmployee("John", "Romero");
        addEmployee("John", "Carmack");
        addEmployee("Gabe", "Newell");
    }

    public Collection<Employee> getEmployees() {
        return map.values();
    }

    private String generateKey(String first, String last) {
        return first.toLowerCase() + " " + last.toLowerCase();
    }

    public Employee addEmployee(String first, String last) {
        if(map.containsKey(generateKey(first, last))) {
            throw new EmployeeExistException("Сотрудник " + first + " " + last + " уже есть в базе данных");
        }
        Employee addedEmployee = new Employee(first, last);
        map.put(generateKey(first, last), addedEmployee);
        return addedEmployee;
    }

    public Employee removeEmployee(String first, String last) {
        if(!map.containsKey(generateKey(first, last))) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник " + first + " " + last + " не найден");
        }
        return map.remove(generateKey(first, last));
    }

    public Employee findEmployee(String first, String last) {
        if(!map.containsKey(generateKey(first, last))) {
            throw new EmployeeNotFoundException("Сотрудник " + first + " " + last + " не найден");
        }
        return map.get(generateKey(first, last));
    }
}
