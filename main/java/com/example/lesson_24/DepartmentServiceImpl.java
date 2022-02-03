package com.example.lesson_24;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    public void setSalaryAndDepartment(EmployeeService employeeService) {
        Collection<Employee> list = employeeService.getEmployees();
        Random rand = new Random();

        for(Employee empl : list) {
            empl.setDepartment(rand.nextInt(5));
            empl.setSalary(rand.nextInt(50000));
        }
    }

    @Override
    public Employee getMinimumSalaryInDep(EmployeeService employeeService, int department) {
        Collection<Employee> list = employeeService.getEmployees();
        Optional<Employee> empl = list.stream().filter(t -> t.getDepartment() == department).min(Comparator.comparingInt(Employee::getSalary));
        return empl.orElseThrow(() -> new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!"));
    }

    @Override
    public Employee getMaximumSalaryInDep(EmployeeService employeeService,int department) {
        Collection<Employee> list = employeeService.getEmployees();
        Optional<Employee> empl = list.stream().filter(t -> t.getDepartment() == department).max(Comparator.comparingInt(Employee::getSalary));
        return empl.orElseThrow(() -> new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!"));
    }

    @Override
    public List<Employee> printEmployeesInDepartment(EmployeeService employeeService, int department) {
        Collection<Employee> list = employeeService.getEmployees();
        return list.stream().filter(t -> t.getDepartment() == department).collect(Collectors.toList());
    }

    @Override
    public  Map<Integer, List<Employee>> printEmployees(EmployeeService employeeService) {
        Collection<Employee> list = employeeService.getEmployees();
        return list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
