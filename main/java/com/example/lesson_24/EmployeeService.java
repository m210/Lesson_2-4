package com.example.lesson_24;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> map = new HashMap<>();

    public Collection<Employee> getEmployees() {
        return map.values();
    }

    public Employee addEmployee(String first, String last) {
        if(map.containsKey(first + last)) {
            throw new EmployeeExistException("Сотрудник " + first + " " + last + " уже есть в базе данных");
        }
        Employee addedEmployee = new Employee(first, last);
        map.put(first + last, addedEmployee);
        return addedEmployee;
    }

    public Employee removeEmployee(String first, String last) {
        if(!map.containsKey(first + last)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник " + first + " " + last + " не найден");
        }
        return map.remove(first + last);
    }

    public Employee findEmployee(String first, String last) {
        if(!map.containsKey(first + last)) {
            throw new EmployeeNotFoundException("Сотрудник " + first + " " + last + " не найден");
        }
        return map.get(first + last);
    }
}
