package com.ecommerce.entities;

/**
 * Represents an employee of the e‑commerce system.
 * Employees can perform administrative tasks such as adding
 * products and managing user accounts.
 */
public class Employee extends User {
    private int employeeId;
    private static int employeeCounter = 1;

    /**
     * Constructs an Employee with the specified personal information.
     *
     * @param name     the employee's full name
     * @param email    the employee's email address
     * @param password the employee's password
     */
    public Employee(String name, String email, String password) {
        super(name, email, password, "employee");
        this.employeeId = employeeCounter++;
    }

    /**
     * Gets the unique ID assigned to this employee.
     *
     * @return the employee ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Displays information about the employee, including their ID.
     */
    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        super.displayInfo();
    }
}