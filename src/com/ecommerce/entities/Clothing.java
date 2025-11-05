package com.ecommerce.entities;

/**
 * Represents a clothing product in the e‑commerce system.
 */
public class Clothing extends Product {
    private String size;
    private String color;

    /**
     * Constructs a Clothing product with the specified details.
     *
     * @param name          the name of the clothing item
     * @param price         the price of the item
     * @param stockQuantity the available stock
     * @param size          the size (e.g. S, M, L)
     * @param color         the color of the item
     */
    public Clothing(String name, double price, int stockQuantity, String size, String color) {
        super(name, price, stockQuantity);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Size: " + size + ", Color: " + color);
    }
}