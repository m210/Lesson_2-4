package com.example.lesson_24;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] list = new Employee[5];

    public Employee addEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index != -1) {
            throw new EmployeeExistException("Сотрудник " + first + " " + last + " уже есть в базе данных");
        }

        Employee addedEmployee = null;
        for(int i = 0; i < list.length; i++) {
            if(list[i] == null) {
                addedEmployee = new Employee(first, last);
                list[i] = addedEmployee;
                break;
            }
        }

        if(addedEmployee == null) {
            throw new EmployeeStoreException("Массив сотрудников переполнен");
        }

        return addedEmployee;
    }

    public Employee removeEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index == -1) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник " + first + " " + last + " не найден");
        }

        Employee foundEmployee = list[index];
        list[index] = null;
        return foundEmployee;
    }

    public Employee findEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index == -1) {
            throw new EmployeeNotFoundException("Сотрудник " + first + " " + last + " не найден");
        }
        return list[index];
    }

    private int findEmployeeIndex(String first, String last) {
        for (int i = 0; i < list.length; i++) {
            Employee dude = list[i];
            if(dude != null && dude.getFirstName().equalsIgnoreCase(first)
                    && dude.getLastName().equalsIgnoreCase(last)) {
                return i;
            }
        }
        return -1;
    }
}
