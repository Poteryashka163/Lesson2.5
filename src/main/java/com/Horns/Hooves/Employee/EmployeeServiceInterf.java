package com.Horns.Hooves.Employee;

public interface EmployeeServiceInterf {
    // Добавление сотрудника
    void addEmployee(Employee employee) throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException;

    // Удаление сотрудника
    void delEmployee(Employee employee) throws EmployeeNotFoundException;

    void findEmployee(Employee employee) throws EmployeeNotFoundException;

}
