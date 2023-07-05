package com.Horns.Hooves.Employee;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String messega){
        super(messega);
    }
}
