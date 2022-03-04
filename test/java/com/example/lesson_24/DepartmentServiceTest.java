package com.example.lesson_24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;

import static com.example.lesson_24.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private EmployeeService employeeService = mock(EmployeeService.class);
    private DepartmentServiceImpl departmentService = new DepartmentServiceImpl(employeeService);

    @BeforeEach
    private void init() {
        Mockito.when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);
    }

    @Test
    public void shouldEMPLOYEE_1() {
        Employee out = departmentService.getMinimumSalaryInDep(1);
        assertEquals(out, EMPLOYEE_1);
    }

    @Test
    public void shouldMaximumSalaryEqualsEMPLOYEE_4() {
        Employee out = departmentService.getMaximumSalaryInDep(4);
        assertEquals(out, EMPLOYEE_4);
    }

    @Test
    public void shouldThrowExceptionMaximumSalary() {
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.getMaximumSalaryInDep(3));
    }

    @Test
    public void shouldThrowExceptionMinimumSalary() {
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.getMinimumSalaryInDep(32));
    }

    @Test
    public void shouldGetEmptyList() {
        assertEquals(EMPTY_LIST, departmentService.getEmployeesInDepartment(111));
    }

    @Test
    public void shouldEqualsEMPLOYEE_2and3() {
        assertIterableEquals(List.of(EMPLOYEE_2, EMPLOYEE_3), departmentService.getEmployeesInDepartment(2));
    }

    @Test
    public void shouldEqualsEMPLOYEE_MAP() {
        assertTrue(EMPLOYEE_MAP.equals(departmentService.getEmployees()));
    }

    @Test
    public void shouldPrintEqualsEMPLOYEE_4() {
        String ref = List.of(EMPLOYEE_4).toString();
        assertTrue(ref.equals(departmentService.printEmployeesInDepartment(4)));
    }

    @Test
    public void shouldEqualsStringOfEMPLOYEE_MAP() {
        String ref = EMPLOYEE_MAP.toString();
        assertTrue(ref.equals(departmentService.printEmployeesInDepartment(null)));
    }

    @Test
    public void shouldGetEmptyMap() {
        Mockito.when(employeeService.getEmployees()).thenReturn(EMPTY_LIST);

        assertTrue(new HashMap<>().toString().equals(departmentService.printEmployeesInDepartment(null)));
    }
}
