package com.ecommerce.entities;


public class Electronics extends Product {
    private String brand;
    private String model;


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