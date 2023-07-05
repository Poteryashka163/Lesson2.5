package com.Horns.Hooves.Employee.service;

import com.Horns.Hooves.Employee.object.Employee;

public interface DepartmentService {

    Employee getMaxSalaryEmployeeByDepartmentNumber(int departmentId);
}
