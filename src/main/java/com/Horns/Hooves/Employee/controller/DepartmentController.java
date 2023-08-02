package com.Horns.Hooves.Employee.controller;

import com.Horns.Hooves.Employee.object.Employee;
import com.Horns.Hooves.Employee.service.DepartmentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentsServiceImpl departmentsServiceImpl;

    public DepartmentController(DepartmentsServiceImpl departmentsServiceImpl) {
        this.departmentsServiceImpl = departmentsServiceImpl;
    }
    @GetMapping(path = "/{id}/employees")
    public Collection<Employee> employeesListOfDepartment (@PathVariable Integer id){
        return departmentsServiceImpl.getEmployeesByDepartment(id);
    }
    @GetMapping(path = "/{id}/salary/sum")
    public Integer salaryOfDepartment (@PathVariable int id){
        return departmentsServiceImpl.getSalarySumByDepId(id);
    }
    @GetMapping(path = "/{id}/salary/max")
    public Integer maxSalaryOfDepartment (@PathVariable int id){
        return departmentsServiceImpl.getMaxSalaryByDepId(id);
    }
    @GetMapping(path = "{id}/salary/min")
    public Integer minSalaryOfDepartment (@PathVariable int id){
        return departmentsServiceImpl.getMinSalaryByDepId(id);
    }
    @GetMapping(path = "/employees")
    Map<Integer, List<Employee>> employeesByDepartment (){
        return departmentsServiceImpl.getAllEmployeesByDepartment();
    }

}
