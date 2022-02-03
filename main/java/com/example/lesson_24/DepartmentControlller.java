package com.example.lesson_24;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/departments")
public class DepartmentControlller {

    private final DepartmentServiceImpl departmentService;

    public DepartmentControlller(DepartmentServiceImpl service, EmployeeService employeeService) {
        this.departmentService = service;
    }

    @GetMapping("min-salary")
    public String getMinimumSalaryInDep(@RequestParam int departmentId) {
        return "Min salary in department " + departmentId + " has " + departmentService.getMinimumSalaryInDep(departmentId);
    }

    @GetMapping("max-salary")
    public String getMaximumSalaryInDep(@RequestParam int departmentId) {
        return "Max salary in department " + departmentId + " has " + departmentService.getMaximumSalaryInDep(departmentId);
    }

    @GetMapping("all")
    public String printEmployeesInDepartment(@RequestParam(required = false) Integer departmentId) {
        return departmentService.printEmployeesInDepartment(departmentId);
    }
}
