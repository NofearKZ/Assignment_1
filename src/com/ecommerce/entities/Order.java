package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private static int orderCounter = 1;


    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }


    public double calculateTotalAmount() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }


    public void printReceipt() {
        System.out.println("\n===== Order Receipt =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product p : products) {
            System.out.printf("  - %s (%.2f)\n", p.getName(), p.getPrice());
        }
        System.out.printf("Total Amount: %.2f\n", calculateTotalAmount());
        System.out.println("==========================\n");
    }
}