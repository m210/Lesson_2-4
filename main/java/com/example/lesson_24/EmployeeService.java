package com.example.lesson_24;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.management.BadStringOperationException;
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

    private String getFullNameWithCheck(String first, String last) {
        if(!StringUtils.isAlpha(first) || !StringUtils.isAlpha(last)) {
            throw new BadRequestException("Недопустимые символы");
        }

        return StringUtils.capitalize(first.toLowerCase()) + " " + StringUtils.capitalize(last.toLowerCase());
    }

    public Employee addEmployee(String first, String last) {
        String fullName = getFullNameWithCheck(first, last);
        if(map.containsKey(fullName)) {
            throw new EmployeeExistException("Сотрудник " + fullName + " уже есть в базе данных");
        }

        Employee addedEmployee = new Employee(StringUtils.capitalize(first.toLowerCase()), StringUtils.capitalize(last.toLowerCase()));
        map.put(fullName, addedEmployee);
        return addedEmployee;
    }

    public Employee removeEmployee(String first, String last) {
        String fullName = getFullNameWithCheck(first, last);
        if(!map.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник " + fullName + " не найден");
        }
        return map.remove(fullName);
    }

    public Employee findEmployee(String first, String last) {
        String fullName = getFullNameWithCheck(first, last);
        if(!map.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Сотрудник " + fullName + " не найден");
        }
        return map.get(fullName);
    }
}
