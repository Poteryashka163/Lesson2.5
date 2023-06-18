package com.Horns.Hooves.Employee;

public interface EmployeeServiceInterf {
    // Добавление сотрудника
    Employee addEmployee(String name, String surname);
    // Удаление сотрудника
    Employee delEmployee(String name, String surname);
    // Поиск сотрудника
    Employee findEmployee(String name, String surname);
}
