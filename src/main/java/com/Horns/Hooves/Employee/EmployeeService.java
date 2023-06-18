package com.Horns.Hooves.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeService implements EmployeeServiceInterf {
    private List<Employee> employees;
    private final int MAX_EMPLOYEES = 3;

    // Создаем список
    public EmployeeService() {
        this.employees = new ArrayList<>();
        // Работник создан для примера
        employees.add(new Employee("Ivan","Ivanov"));
    }

    // Добавление сотрудника
    @Override
    public Employee addEmployee(String name,String surname) {
        Employee employee = new Employee(name,surname);
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);}
        else if (employees.contains(employee)){
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
        Employee employee = new Employee(name,surname);
        if (employees.contains(employee)) {
            employees.remove(employee);
        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }
    @Override
    // Поиск сотрудника
    public Employee findEmployee(String name,String surname) {
        Employee employee = new Employee(name,surname);
        if (employees.contains(employee)) {

        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }

    // Получение списка всех сотрудников
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }





}

