package com.Horns.Hooves.Employee;

public interface EmployeeServiceInterf {

    // Добавление сотрудника
    Employee addEmployee(String name, String surname, String department, int salary, int id);

    // Удаление сотрудника
    Employee delEmployee(String name, String surname, String department, int salary, int id);

    // Поиск сотрудника
    Employee findEmployee(String name, String surname, String department, int salary, int id);
}
