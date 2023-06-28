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
    public String add(@RequestParam String name, @RequestParam String surname,@RequestParam String department,@RequestParam int salary,@RequestParam int id) throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException {
        return "Сотрудник : "+employeeService.addEmployee(name,surname,department,salary,id)+" добавлен.";
    }
    @GetMapping(path = "/del")
    public Employee del(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return null;
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return null;
    }

    @GetMapping(path = "/size")
    public String size() {
        return "Сотрудников в списке: "+ employeeService.getNumberOfEmployees();
    }



    @GetMapping(path = "/departments/max-salary")
    public String maxSalary (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/departments/min-salary")
    public String minSalary (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/departments/all")
    public String allId (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/all")
    public Collection<Employee> all() {
        return employeeService.getAllEmployees();
    }
}

