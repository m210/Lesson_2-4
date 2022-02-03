package com.example.lesson_24;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentControlller {

    DepartmentServiceImpl service;
    public DepartmentControlller(DepartmentServiceImpl service, EmployeeService oldService) {
        this.service = service;

        service.initEmployeeList(oldService);
    }

    @GetMapping()
    public List<Employee> welcome() {
        return service.getList();
    }

    @GetMapping("min-salary")
    public String getMinimumSalaryInDep(@RequestParam int departmentId) {
        return "Min salary in department " + departmentId + " is " + service.getMinimumSalaryInDep(departmentId) + " руб.";
    }

    @GetMapping("max-salary")
    public String getMaximumSalaryInDep(@RequestParam int departmentId) {
        return "Max salary in department " + departmentId + " is " + service.getMaximumSalaryInDep(departmentId) + " руб.";
    }

    @GetMapping("all")
    public String printEmployeesInDepartment(@RequestParam(required = false) Integer departmentId) {
        if(departmentId == null)
            return service.printEmployees();

        return service.printEmployeesInDepartment(departmentId);
    }
}
