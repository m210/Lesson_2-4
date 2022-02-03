package com.example.lesson_24;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee getMinimumSalaryInDep(int department);

    Employee getMaximumSalaryInDep(int department);

    List<Employee> getEmployeesInDepartment(int department);

    Map<Integer, List<Employee>> getEmployees();

    String printEmployeesInDepartment(Integer departmentId);

}
