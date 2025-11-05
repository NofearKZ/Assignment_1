package com.ecommerce.entities;


public class Customer extends User {
    private int customerId;
    private static int customerCounter = 1;


    public Customer(String name, String email, String password) {
        super(name, email, password, "customer");
        this.customerId = customerCounter++;
    }


    public int getCustomerId() {
        return customerId;
    }


    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId);
        super.displayInfo();
    }
}