package com.Horns.Hooves.Employee.service;

import com.Horns.Hooves.Employee.object.Employee;

public interface EmployeeService {

    // Добавление сотрудника
    Employee addEmployee(String name, String surname, int salary, int departmentId);

    // Удаление сотрудника
   String delEmployee(String name, String surname);

    // Поиск сотрудника
    String findEmployee(String name, String surname);

}
