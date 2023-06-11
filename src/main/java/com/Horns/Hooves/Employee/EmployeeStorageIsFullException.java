package com.Horns.Hooves.Employee;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String messega) {
        super(messega);
    }
}