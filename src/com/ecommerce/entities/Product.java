package com.ecommerce.entities;


public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int stockQuantity;
    private static int idCounter = 1;


    public Product(String name, double price, int stockQuantity) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public boolean reduceStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            return true;
        }
        return false;
    }


    public void displayInfo() {
        System.out.printf("ID: %d, Name: %s, Price: %.2f, Stock: %d\n", id, name, price, stockQuantity);
    }
}