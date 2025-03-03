package com.employeepayrollapp.EmployeePayRollApp.expections;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

