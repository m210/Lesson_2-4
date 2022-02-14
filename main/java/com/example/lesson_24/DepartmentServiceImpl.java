package com.example.lesson_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    private void postConstruct() {
        Collection<Employee> list = employeeService.getEmployees();
        Random rand = new Random();

        for(Employee empl : list) {
            empl.setDepartment(rand.nextInt(5));
            empl.setSalary(rand.nextInt(50000));
        }
    }

    @Override
    public Employee getMinimumSalaryInDep(int department) {
        Optional<Employee> empl = employeeService.getEmployees().stream().filter(t -> t.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
        return empl.orElseThrow(() -> new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!"));
    }

    @Override
    public Employee getMaximumSalaryInDep(int department) {
        Optional<Employee> empl = employeeService.getEmployees().stream().filter(t -> t.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
        return empl.orElseThrow(() -> new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!"));
    }

    @Override
    public List<Employee> getEmployeesInDepartment(int department) {
        return employeeService.getEmployees().stream().filter(t -> t.getDepartment() == department).collect(Collectors.toList());
    }

    @Override
    public  Map<Integer, List<Employee>> getEmployees() {
        return employeeService.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public String printEmployeesInDepartment(Integer departmentId) {
        if(departmentId == null)
            return getEmployees().toString();
        return getEmployeesInDepartment(departmentId).toString();
    }

}
