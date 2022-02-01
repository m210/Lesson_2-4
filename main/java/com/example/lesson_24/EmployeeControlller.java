package com.example.lesson_24;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeControlller {
    private final EmployeeService service;

    public EmployeeControlller(EmployeeService service) {
        this.service = service;

        service.addEmployee("Bill", "Gates");
        service.addEmployee("Steve", "Jobs");
        service.addEmployee("John", "Romero");
        service.addEmployee("John", "Carmack");
        service.addEmployee("Gabe", "Newell");
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

    @RequestMapping("/showall")
    public Collection<Employee> getEmployees() {
        return service.getEmployees();
    }
}
