package com.ecommerce.entities;

/**
 * Represents an electronics product in the e‑commerce system.
 */
public class Electronics extends Product {
    private String brand;
    private String model;

    /**
     * Constructs an Electronics product with the specified details.
     *
     * @param name          the name of the product
     * @param price         the price of the product
     * @param stockQuantity the available stock
     * @param brand         the brand of the electronic
     * @param model         the model identifier
     */
    public Electronics(String name, double price, int stockQuantity, String brand, String model) {
        super(name, price, stockQuantity);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Brand: " + brand + ", Model: " + model);
    }
}