package com.Horns.Hooves.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return "Сотрудник добавлен";
    }
    @GetMapping(path = "/del")
    public String del(@RequestParam String name,@RequestParam String surname) {
        Employee employee = new Employee(name,surname);
        employeeService.delEmployee(employee);
        return "Сотрудник удален" ;
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam String name,@RequestParam String surname) {
        Employee employee = new Employee(name,surname);
        employeeService.findEmployee(employee);
        return employee.getName() +" "+employee.getSurname() ;
    }
    @GetMapping(path = "/all")
    public String all() {
        return employeeService.getAllEmployees().toString();

    }
    @GetMapping(path = "/size")
    public int size() {
        return employeeService.getNumberOfEmployees();
    }
}

