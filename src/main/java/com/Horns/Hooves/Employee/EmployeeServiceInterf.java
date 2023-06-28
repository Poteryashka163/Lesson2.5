package com.Horns.Hooves.Employee;

public interface EmployeeServiceInterf {

    // Добавление сотрудника
    String addEmployee(String name, String surname, String department, int salary, int id);

    // Удаление сотрудника
   String delEmployee(String name, String surname);

    // Поиск сотрудника
    String findEmployee(String name, String surname);
}
