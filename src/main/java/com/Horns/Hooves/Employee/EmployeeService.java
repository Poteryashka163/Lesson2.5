package com.Horns.Hooves.Employee;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService implements EmployeeServiceInterf {
    private Map<String, String> employees;
    private final int MAX_EMPLOYEES = 3;

    // Создаем список
    public EmployeeService() {
        this.employees = new LinkedHashMap<>();
        // Работник создан для примера
        employees.putIfAbsent("Ivan","Ivanov");
    }

    // Добавление сотрудника
    @Override
    public Employee addEmployee(String name,String surname) {
        Map<String, String> employee = new LinkedHashMap<>();
        if (employees.size() < MAX_EMPLOYEES) {
            employees.putIfAbsent(employee);}
        else if (employees.containsKey(employee) || employees.containsValue(employee)){
            throw new EmployeeAlreadyAddedException("Такой сотрудки уже есть в списке");
        }
        else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
        return employee;
    }
    @Override
    // Удаление сотрудника
    public Employee delEmployee(String name, String surname){
        Map<String, String> employee = new LinkedHashMap<>();;
        if (employees.containsKey(employee)) {
            employees.remove(employee);
        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }
    @Override
    // Поиск сотрудника
    public Employee findEmployee(String name,String surname) {
        Map<String, String> employee = new LinkedHashMap<>();
        if (employees.containsKey(employee)) {

        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }

    // Получение списка всех сотрудников
    public Collection<Employee> getAllEmployees() {
        return ;
    }

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }





}

