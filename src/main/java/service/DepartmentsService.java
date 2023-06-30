package service;

import object.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service

public class DepartmentsService implements DepartmentServiceInterf {
    private final EmployeeService employeeService;
    public DepartmentsService (EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @Override
    public Employee getMaxSalaryEmployeeByDepartmentNumber(int departmentId) {
        Optional<Employee> result = employeeService.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary));
        return result.orElse(null);
    }

}
