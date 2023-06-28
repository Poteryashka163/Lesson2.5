package com.Horns.Hooves.Employee;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService implements EmployeeServiceInterf {
    private Map<String, Employee> employees;
    private final int MAX_EMPLOYEES = 3;

    // Создаем список
    public EmployeeService() {
        this.employees = new LinkedHashMap<>();}

    // Добавление сотрудника
    @Override
    public String addEmployee(String name, String surname, String department, int salary, int id) {
        var kye = name + "_" + surname;
        var e = new Employee(name,surname,department,salary,id);
        if (employees.size() < MAX_EMPLOYEES) {
            employees.putIfAbsent(kye,e);}
        else if (employees.containsKey(kye)){
            throw new EmployeeAlreadyAddedException("Такой сотрудки уже есть в списке");
        }
        else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
        return e.toString();
    }
    @Override
    // Удаление сотрудника
    public String delEmployee(String name, String surname){
        var kye = name + "_" + surname;
        var e = new Employee(name,surname);
        if (employees.containsKey(kye)) {
            employees.remove(kye);
        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return e;
    }
    @Override
    // Поиск сотрудника
    public String findEmployee(String name, String surname) {
        var kye = name + "_" + surname;
        var e = new Employee(name,surname);
        if (employees.containsKey(kye)) {

        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return e;
    }

    // Получение списка всех сотрудников
    public Collection<Employee> getAllEmployees() {
        List <Employee> emploeesList = new ArrayList<>(employees.values());
        return Collections.unmodifiableList(emploeesList);}

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }

    public String maxSalary(int id){
        Employee maxEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (maxEmployee == null || employees[i].getSalary() > maxEmployee.getSalary()) {
                    maxEmployee = employees[i];
                }
            }
        }

        return maxEmployee;
    }
    public String minSalary(int id){
        Employee minEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minEmployee == null || employees[i].getSalary() < minEmployee.getSalary()) {
                    minEmployee = employees[i];
                }
            }
        }

        return minEmployee;

    }
    public String allId(int id){int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        return count;
    }
    }






}

