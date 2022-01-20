package com.example.lesson_24;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] list = new Employee[5];

    public boolean addEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index != -1) {
            return false;
        }

        for(int i = 0; i < list.length; i++) {
            if(list[i] == null) {
                list[i] = new Employee(first, last);
                return true;
            }
        }
        throw new EmployeeStoreException("Массив сотрудников переполнен");
    }

    public boolean removeEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index != -1) {
            list[index] = null;
            return true;
        }
        throw new EmployeeNotFoundException("Удаляемый сотрудник " + first + " " + last + " не найден");
    }

    public Employee findEmployee(String first, String last) {
        int index = findEmployeeIndex(first, last);
        if(index != -1) {
            return list[index];
        }
        throw new EmployeeNotFoundException("Сотрудник " + first + " " + last + " не найден");
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
