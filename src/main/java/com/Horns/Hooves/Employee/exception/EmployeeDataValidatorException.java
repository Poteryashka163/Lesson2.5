package com.Horns.Hooves.Employee.exception;

public class EmployeeDataValidatorException extends RuntimeException{
    public EmployeeDataValidatorException() {
    }

    public EmployeeDataValidatorException(String message) {
        super(message);
    }

    public EmployeeDataValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDataValidatorException(Throwable cause) {
        super(cause);
    }

    public EmployeeDataValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
