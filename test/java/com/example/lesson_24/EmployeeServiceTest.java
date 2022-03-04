package com.example.lesson_24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    public void addTest() {
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("Peter", "1"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("1", "Peter"));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee(null, null));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee("Peter", null));
        assertThrows(BadRequestException.class, () -> employeeService.addEmployee(null, "Peter"));

        employeeService.addEmployee("Aaa", "Bbb");
        assertThrows(EmployeeExistException.class, () -> employeeService.addEmployee("Aaa", "Bbb"));

        Employee ref = new Employee("John", "Connor");
        Employee out = employeeService.addEmployee("JoHn", "CoNnOr");

        assertEquals(ref, out);
    }

    @Test
    public void removeTest() {
        assertThrows(BadRequestException.class, () -> employeeService.removeEmployee("Peter", "1"));
        assertThrows(BadRequestException.class, () -> employeeService.removeEmployee("1", "Peter"));
        assertThrows(BadRequestException.class, () -> employeeService.removeEmployee(null, null));
        assertThrows(BadRequestException.class, () -> employeeService.removeEmployee("Peter", null));
        assertThrows(BadRequestException.class, () -> employeeService.removeEmployee(null, "Peter"));

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee("Aaa", "Bbb"));

        Employee ref = new Employee("John", "Carmack");
        Employee out = employeeService.removeEmployee("JoHn", "cArMaCk");

        assertEquals(ref, out);
    }

    @Test
    public void findTest() {
        assertThrows(BadRequestException.class, () -> employeeService.findEmployee(null, null));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Aaa", "Bbb"));

        Employee ref = new Employee("John", "Carmack");
        Employee out = employeeService.findEmployee("JoHn", "cArMaCk");

        assertEquals(ref, out);
    }

}
