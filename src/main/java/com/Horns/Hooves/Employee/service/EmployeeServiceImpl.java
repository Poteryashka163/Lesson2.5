package com.Horns.Hooves.Employee.service;

import com.Horns.Hooves.Employee.exception.EmployeeAlreadyAddedException;
import com.Horns.Hooves.Employee.exception.EmployeeDataValidatorException;
import com.Horns.Hooves.Employee.exception.EmployeeNotFoundException;
import com.Horns.Hooves.Employee.exception.EmployeeStorageIsFullException;
import com.Horns.Hooves.Employee.object.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees;

    // Создаем список
    public EmployeeServiceImpl() {
        this.employees = new LinkedHashMap<>();}

    // Добавление сотрудника
    @Override
    public Employee addEmployee(String name, String surname, int salary, int departmentId) {
        validateEmployeeData(name,surname);
        var kye = name + "_" + surname;
        var e = new Employee(name,surname,salary,departmentId);
        int MAX_EMPLOYEES = 10;
        if (employees.size() < MAX_EMPLOYEES) {
            employees.put(kye,e);
            return e;}

        else if (employees.containsKey(kye)){
            throw new EmployeeAlreadyAddedException("Такой сотрудки уже есть в списке");
        }
        else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
    }
    @Override
    // Удаление сотрудника
    public String delEmployee(String name, String surname){
        var kye = name + "_" + surname;
        if (employees.containsKey(kye)) {
            employees.remove(kye);
            return surname+" "+name;
        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }

    }
    @Override
    // Поиск сотрудника
    public String findEmployee(String name, String surname) {
        var kye = name + "_" + surname;
        if (employees.containsKey(kye)) {
            return surname+" "+name;

        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
    }

    // Получение списка всех сотрудников
    public Collection<Employee> getAllEmployees() {
        List <Employee> emploeesList = new ArrayList<>(employees.values());
        return Collections.unmodifiableList(emploeesList);}

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }


    public static void validateEmployeeData(String name, String surname) {
        if (!isValidName(name) || !isValidNameSurname(surname)) {
            throw new EmployeeDataValidatorException("Invalid employee data");
        }
    }

    private static boolean isValidName(String name) {
        return StringUtils.isNotBlank(name) && StringUtils.isAlpha(name) && StringUtils.isAllUpperCase(name.substring(0, 1));
    }
    private static boolean isValidNameSurname(String surname) {
        return StringUtils.isNotBlank(surname) && StringUtils.isAlpha(surname) && StringUtils.isAllUpperCase(surname.substring(0, 1));
    }

}



