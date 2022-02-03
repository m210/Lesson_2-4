package com.example.lesson_24;

import java.util.List;

public interface DepartmentService {

    void initEmployeeList(EmployeeService oldService);

    int getMinimumSalaryInDep(int department);

    int getMaximumSalaryInDep(int department);

    String printEmployeesInDepartment(int department);

    String printEmployees();

    List<Employee> getList();

}
