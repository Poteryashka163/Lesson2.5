package com.Horns.Hooves.Employee.service;

import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplTest {
    private static final String FIRSTNAME= "Fedor";
    private static final String LASTNAME = "Sumkin";


    private final EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

    @Test
    void addEmployee() {
        String wrongFirsName = "ivan";
        String lastName = "Ivanov";

        //Подготовка ожидаемого результата
        String expectedMessage = "Имя начинается не с заглавной буквы";

        //Начало теста
        Exception exception = assertThrows(InvalidNameException.class, () -> {
            employeeServiceImpl.add(wrongFirsName, lastName);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void delEmployee() {
    }

    @Test
    void findEmployee() {
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void getNumberOfEmployees() {
    }

    @Test
    void validateEmployeeData() {
    }
}