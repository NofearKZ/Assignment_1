package com.ecommerce.entities;

/**
 * Represents a generic product in the e‑commerce system.
 * Subclasses add domain‑specific attributes such as author for books or brand
 * for electronics. All product details are encapsulated and accessed
 * via getters and setters.
 */
public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int stockQuantity;
    private static int idCounter = 1;

    /**
     * Constructs a Product with the specified details.
     *
     * @param name          the product's name
     * @param price         the product's price
     * @param stockQuantity the quantity in stock
     */
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

    /**
     * Decreases the stock quantity by the specified amount.
     *
     * @param quantity the amount to decrease
     * @return true if the operation is successful, false otherwise
     */
    public boolean reduceStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            return true;
        }
        return false;
    }

    /**
     * Displays information about the product. Subclasses override this
     * method to add more details.
     */
    public void displayInfo() {
        System.out.printf("ID: %d, Name: %s, Price: %.2f, Stock: %d\n", id, name, price, stockQuantity);
    }
}