package com.Horns.Hooves.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;}
    @RequestMapping
    public String memu(){
        return "Добро пожаловать в бугалтерскую книгу.";
    }
    @GetMapping(path = "/add")
    public String add(@RequestParam String name, @RequestParam String surname) throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException {
        Employee employee = new Employee(name,surname);
        employeeService.addEmployee(employee);
        return "Сотрудник "+employee.getName()+" "+employee.getSurname()+" добавлен";
    }
    @GetMapping(path = "/del")
    public String del(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name,surname);
        employeeService.delEmployee(employee);
        return "Сотрудник "+employee.getName()+" "+employee.getSurname()+" удален" ;
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name,surname);
        employeeService.findEmployee(employee);
        return employee.getName() +" "+employee.getSurname() +"Найден." ;
    }
    @GetMapping(path = "/all")
    public Collection<Employee> all() {
        return employeeService.getAllEmployees();

    }
    @GetMapping(path = "/size")
    public String size() {
        return "Сотрудников в списке: "+ employeeService.getNumberOfEmployees();
    }
}

