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
    public Employee add(@RequestParam String name, @RequestParam String surname) throws EmployeeStorageIsFullException,EmployeeAlreadyAddedException {
        return employeeService.addEmployee(name,surname);
    }
    @GetMapping(path = "/del")
    public Employee del(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return employeeService.delEmployee(name,surname);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return employeeService.findEmployee(name,surname);
    }

    @GetMapping(path = "/size")
    public String size() {
        return "Сотрудников в списке: "+ employeeService.getNumberOfEmployees();
    }



    @GetMapping(path = "/departments/max-salary")
    public Employee maxSalary (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/departments/min-salary")
    public Employee minSalary (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/departments/all")
    public Employee allId (@RequestParam int id){
        return null;
    }
    @GetMapping(path = "/all")
    public Collection<Employee> all() {
        return employeeService.getAllEmployees();
    }
}

