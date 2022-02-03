package com.example.lesson_24;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/departments")
public class DepartmentControlller {

    private final DepartmentServiceImpl departmentService;
    private final EmployeeService employeeService;

    public DepartmentControlller(DepartmentServiceImpl service, EmployeeService employeeService) {
        this.departmentService = service;
        this.employeeService = employeeService;
    }

    @PostConstruct
    private void postConstruct() {
        departmentService.setSalaryAndDepartment(employeeService);
    }

    @GetMapping("min-salary")
    public String getMinimumSalaryInDep(@RequestParam int departmentId) {
        return "Min salary in department " + departmentId + " has " + departmentService.getMinimumSalaryInDep(employeeService, departmentId);
    }

    @GetMapping("max-salary")
    public String getMaximumSalaryInDep(@RequestParam int departmentId) {
        return "Max salary in department " + departmentId + " has " + departmentService.getMaximumSalaryInDep(employeeService, departmentId);
    }

    @GetMapping("all")
    public String printEmployeesInDepartment(@RequestParam(required = false) Integer departmentId) {
        if(departmentId == null)
            return departmentService.printEmployees(employeeService).toString();

        return departmentService.printEmployeesInDepartment(employeeService, departmentId).toString();
    }
}
