package com.Horns.Hooves.Employee;

public interface EmployeeServiceInterf {
    // Добавление сотрудника
    void addEmployee(Employee employee) throws EmployeeStorageIsFullException;
}
