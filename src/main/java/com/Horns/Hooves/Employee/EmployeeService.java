package com.Horns.Hooves.Employee;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;
    private final int MAX_EMPLOYEES = 10;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    // Добавление сотрудника
    public void addEmployee(Employee employee) throws EmployeeStorageIsFullException {
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);
        } else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
    }

    // Получение списка всех сотрудников
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }


}

