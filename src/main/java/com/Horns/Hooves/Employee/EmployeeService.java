package com.Horns.Hooves.Employee;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterf {
    private List<Employee> employees;
    private final int MAX_EMPLOYEES = 10;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    // Добавление сотрудника
    @Override
    public void addEmployee(Employee employee) throws EmployeeStorageIsFullException {
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);
        } else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
    }

    // Получение списка всех сотрудников
    public List<Employee> getAllEmployees() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
        return getAllEmployees();
    }

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }


}

