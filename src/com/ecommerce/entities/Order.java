package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order placed by a customer. An order contains one or more
 * products and a reference to the customer who placed it. The order ID is
 * automatically generated.
 */
public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private static int orderCounter = 1;

    /**
     * Constructs a new order for the given customer.
     *
     * @param customer the customer placing the order
     */
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

    /**
     * Adds a product to this order.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Calculates the total amount for this order based on the sum of product prices.
     *
     * @return the total amount
     */
    public double calculateTotalAmount() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    /**
     * Prints a simple receipt for this order to the console.
     */
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