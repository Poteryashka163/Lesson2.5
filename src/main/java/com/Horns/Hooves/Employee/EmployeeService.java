package com.Horns.Hooves.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterf {
    private List<Employee> employees;
    private final int MAX_EMPLOYEES = 3;

    public EmployeeService() {
        this.employees = new ArrayList<>();
        employees.add(new Employee("Ivan","Ivanov"));
        employees.add(new Employee("Alex","Alexandrov"));
    }

    // Добавление сотрудника
    @Override
    public void addEmployee(Employee employee) throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException {
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);}
        else if (employees.contains(employee) != false){
            throw new EmployeeAlreadyAddedException("Такой сотрудки уже есть в списке");
        }
        else {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников.");
        }
    }
    public void delEmployee(Employee employee){
        employees.remove(employee);
    }
    public void findEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employees.contains(employee)) {

        }else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
    }

    // Получение списка всех сотрудников
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Получение количества сотрудников в фирме
    public int getNumberOfEmployees() {
        return employees.size();
    }
//    public static boolean notFound(){
//        return ;
//    }
//    public static boolean alreadyAdded{
//        return;
//    }
//    public static boolean storageFull{
//        return;
//    }


}

