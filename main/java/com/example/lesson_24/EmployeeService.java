package com.example.lesson_24;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> list = new ArrayList<>();

    public List<Employee> getEmployees() {
        return list;
    }

    public Employee addEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index != -1) {
            throw new EmployeeExistException("Сотрудник " + first + " " + last + " уже есть в базе данных");
        }

        Employee addedEmployee = new Employee(first, last);
        list.add(addedEmployee);
        return addedEmployee;
    }

    public Employee removeEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index == -1) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник " + first + " " + last + " не найден");
        }
        return list.remove(index);
    }

    public Employee findEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index == -1) {
            throw new EmployeeNotFoundException("Сотрудник " + first + " " + last + " не найден");
        }
        return list.get(index);
    }

    private int findEmployeeIndex(String first, String last) {
        return list.indexOf(new Employee(first, last));
    }
}
