package com.example.lesson_24;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeControlller {
    private final EmployeeService service;

    public EmployeeControlller(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @RequestMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }
}
