package com.Horns.Hooves.Employee.controller;
import com.Horns.Hooves.Employee.object.Employee;
import com.Horns.Hooves.Employee.service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentsService departmentsService;
    public DepartmentsController (DepartmentsService departmentsService){
        this.departmentsService=departmentsService;}
    @GetMapping(path = "/max-salary")
    public String maxSalary (@RequestParam int departmentId){
        return departmentsService.getMaxSalaryEmployeeByDepartmentNumber(departmentId).toString();
    }
    @GetMapping(path = "/min-salary")
    public String minSalary (@RequestParam int departmentId){
        return departmentsService.getMinSalaryEmployeeByDepartmentNumber(departmentId).toString();
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findAll (){
        return departmentsService.getAllEmployeesByDepartment();
    }
    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> findByDepartment(@RequestParam Integer departmentId){
        return departmentsService.getEmployeesByDepartment(departmentId);
    }

}


