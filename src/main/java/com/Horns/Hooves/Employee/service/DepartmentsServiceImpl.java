package com.Horns.Hooves.Employee.service;
import com.Horns.Hooves.Employee.object.Employee;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentService {
    public Collection<Employee> getList() {
        return new ArrayList<>(employeeServiceImpl.employees.values());
    }


    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentsServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
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

    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        return getList().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return getList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
//Блок кода для Контроллера DepartmentController

    public int getSalarySumByDepId(int Id) {
        int result = getList().stream()
                .filter(e -> e.getDepartmentId() == Id)
                .mapToInt(Employee::getSalary)
                .sum();
        return result;
    }
    public int getMaxSalaryByDepId(int id) {
        int result = getList().stream()
                .filter(e -> e.getDepartmentId() == id)
                .mapToInt(Employee::getSalary)
                .max()
                .getAsInt();
        return result;
    }

    public int getMinSalaryByDepId(int id) {
        int result = getList().stream()
                .filter(e -> e.getDepartmentId() == id)
                .mapToInt(Employee::getSalary)
                .min()
                .getAsInt();
        return result;
    }
}