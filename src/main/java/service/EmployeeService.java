package service;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import object.Employee;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService implements EmployeeServiceInterf {
    public Map<String, Employee> employees;
    private final int MAX_EMPLOYEES = 10;

    // Создаем список
    public EmployeeService() {
        this.employees = new LinkedHashMap<>();}

    // Добавление сотрудника
    @Override
    public String addEmployee(String name, String surname, int salary, int departmentId) {
        var kye = name + "_" + surname;
        var e = new Employee(name,surname,salary,departmentId);
        if (employees.size() < MAX_EMPLOYEES) {
            employees.put(kye,e);
            return e.getSurname()+" "+ e.getName()+" "+"Отдел №"+" "+ e.getDepartmentId();}
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
    

}



