package service;

import object.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class DepartmentsService implements DepartmentServiceInterf {
    public Collection<Employee> getList(){
        return new ArrayList<>(employeeService.employees.values());
    }


    private final EmployeeService employeeService;
    public DepartmentsService (EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployeeByDepartmentNumber(int departmentId) {
        Optional<Employee> result = getList().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary));
        return result.orElse(null);
    }
    public Employee getMinSalaryEmployeeByDepartmentNumber(int departmentId) {
        Optional<Employee> result = getList().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary));
        return result.orElse(null);
    }
    public Employee getEmployeesByDepartment(int departmentId) {
        List<Employee> result = getList().stream()
                .filter(e -> e.getDepartmentId()==(departmentId))
                .collect(Collectors.toList());
        return (Employee) result;
    }

}
