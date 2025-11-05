package com.ecommerce.entities;


public class Employee extends User {
    private int employeeId;
    private static int employeeCounter = 1;


    public Employee(String name, String email, String password) {
        super(name, email, password, "employee");
        this.employeeId = employeeCounter++;
    }


    public int getEmployeeId() {
        return employeeId;
    }


    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        super.displayInfo();
    }
}