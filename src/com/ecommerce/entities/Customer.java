package com.ecommerce.entities;

/**
 * Represents a customer in the e‑commerce system.
 * Customers are users who can place orders for products.
 */
public class Customer extends User {
    private int customerId;
    private static int customerCounter = 1;

    /**
     * Constructs a Customer with the specified personal information.
     *
     * @param name     the customer's full name
     * @param email    the customer's email address
     * @param password the customer's password
     */
    public Customer(String name, String email, String password) {
        super(name, email, password, "customer");
        this.customerId = customerCounter++;
    }

    /**
     * Gets the unique ID assigned to this customer.
     *
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Displays information about the customer, including their ID.
     */
    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId);
        super.displayInfo();
    }
}