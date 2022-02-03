package com.example.lesson_24;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    void setSalaryAndDepartment(EmployeeService employeeService);

    Employee getMinimumSalaryInDep(EmployeeService employeeService, int department);

    Employee getMaximumSalaryInDep(EmployeeService employeeService, int department);

    List<Employee> printEmployeesInDepartment(EmployeeService employeeService, int department);

    Map<Integer, List<Employee>> printEmployees(EmployeeService employeeService);

}
