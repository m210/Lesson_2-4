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
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        if(service.addEmployee(firstName, lastName))
            return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
        return "Сотрудник " + firstName + " " + lastName + " уже есть в базе данных";
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        if(service.removeEmployee(firstName, lastName))
            return "Сотрудник " + firstName + " " + lastName + " успешно удален.";
        return "Сотрудник " + firstName + " " + lastName + " не найден";
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }
}
