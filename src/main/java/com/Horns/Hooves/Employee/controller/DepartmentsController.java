package com.Horns.Hooves.Employee.controller;
import com.Horns.Hooves.Employee.object.Employee;
import com.Horns.Hooves.Employee.service.DepartmentsServiceImpl;
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
    private final DepartmentsServiceImpl departmentsServiceImpl;
    public DepartmentsController (DepartmentsServiceImpl departmentsServiceImpl){
        this.departmentsServiceImpl = departmentsServiceImpl;}
    @GetMapping(path = "/max-salary")
    public String maxSalary (@RequestParam int departmentId){
        return departmentsServiceImpl.getMaxSalaryEmployeeByDepartmentNumber(departmentId).toString();
    }
    @GetMapping(path = "/min-salary")
    public String minSalary (@RequestParam int departmentId){
        return departmentsServiceImpl.getMinSalaryEmployeeByDepartmentNumber(departmentId).toString();
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findAll (){
        return departmentsServiceImpl.getAllEmployeesByDepartment();
    }
    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> findByDepartment(@RequestParam Integer departmentId){
        return departmentsServiceImpl.getEmployeesByDepartment(departmentId);
    }

}


