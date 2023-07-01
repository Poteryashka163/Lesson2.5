package com.Horns.Hooves.Employee.controller;
import com.Horns.Hooves.Employee.service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String allId (@RequestParam(defaultValue = "departmentId") String departmentId){
            if (departmentId.equals("departmentId")) {
                return departmentsService.getEmployeesByDepartment(departmentId).toString();
            } else {
                return departmentsService.getAllEmployeesByDepartment().toString();
            }
        }

    }


