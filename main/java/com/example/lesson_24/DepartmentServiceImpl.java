package com.example.lesson_24;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Employee> list = new ArrayList<>();

    @Override
    public void initEmployeeList(EmployeeService service) {
        /*
        Для того чтобы получить список сотрудников,
        надо в новый сервис заинжектить старый сервис
        и запросить список всех сотрудников.

        Я, правда, не уверен, что это впринципе хорошее решение
        */

        list.addAll(service.getEmployees());
        Random rand = new Random();

        for(Employee empl : list) {
            empl.setDepartment(rand.nextInt(5));
            empl.setSalary(rand.nextInt(50000));
        }
    }

    @Override
    public int getMinimumSalaryInDep(int department) {
        Optional<Employee> empl = list.stream().filter(t -> t.getDepartment() == department).min(Comparator.comparingInt(employee -> employee.getSalary()));
        if(!empl.isPresent())
            throw new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!");

        return empl.get().getSalary();
    }

    @Override
    public int getMaximumSalaryInDep(int department) {
        Optional<Employee> empl = list.stream().filter(t -> t.getDepartment() == department).max(Comparator.comparingInt(employee -> employee.getSalary()));
        if(!empl.isPresent())
            throw new EmployeeNotFoundException("Подразделение с departmentId = " + department + " не найден!");

        return empl.get().getSalary();
    }

    @Override
    public String printEmployeesInDepartment(int department) {
        return list.stream().filter(t -> t.getDepartment() == department).collect(Collectors.toList()).toString();
    }

    @Override
    public String printEmployees() {
        StringBuilder sb = new StringBuilder();
        List<Employee> list2 = list.stream().sorted(Comparator.comparingInt(t -> t.getDepartment())).collect(Collectors.toList());

        int lastDep = -1;
        for(Employee empl : list2) {
            if(lastDep != empl.getDepartment()) {
                sb.append("Список сотрудников в отделе " + empl.getDepartment() + ": ");
                lastDep = empl.getDepartment();
            }
            sb.append(empl.toString());
        }
        return sb.toString();
    }

    @Override
    public List<Employee> getList() {
        return list;
    }
}
