package com.Horns.Hooves.Employee;

public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String messega) {
        super(messega);
    }
}