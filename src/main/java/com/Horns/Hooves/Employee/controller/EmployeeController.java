package com.Horns.Hooves.Employee.controller;
import com.Horns.Hooves.Employee.exception.EmployeeAlreadyAddedException;
import com.Horns.Hooves.Employee.exception.EmployeeStorageIsFullException;
import com.Horns.Hooves.Employee.service.EmployeeService;
import com.Horns.Hooves.Employee.exception.EmployeeNotFoundException;
import com.Horns.Hooves.Employee.object.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;}
    @RequestMapping
    public String memu(){
        return "Добро пожаловать в бугалтерскую книгу.";
    }
    @GetMapping(path = "/add")
    public String add(@RequestParam String name, @RequestParam String surname,@RequestParam int salary,@RequestParam int departmentId) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        return "Сотрудник : "+employeeService.addEmployee(name,surname,salary,departmentId)+" добавлен.";
    }
    @GetMapping(path = "/del")
    public String del(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return "Сотрудник : "+ employeeService.delEmployee(name,surname)+" удален.";
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam String name,@RequestParam String surname) throws EmployeeNotFoundException {
        return "Найден сотрудник : "+ employeeService.findEmployee(name,surname);
    }

    @GetMapping(path = "/size")
    public String size() {
        return "Сотрудников в списке: "+ employeeService.getNumberOfEmployees();
    }

    @GetMapping(path = "/all")
    public Collection<Employee> all() {
        return employeeService.getAllEmployees();
    }
}

