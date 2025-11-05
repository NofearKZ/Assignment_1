package com.ecommerce.entities;

/**
 * Represents a book product in the e‑commerce system.
 */
public class Book extends Product {
    private String author;
    private String isbn;

    /**
     * Constructs a Book with the specified details.
     *
     * @param name          the title of the book
     * @param price         the price of the book
     * @param stockQuantity the available stock
     * @param author        the author of the book
     * @param isbn          the ISBN number of the book
     */
    public Book(String name, double price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Author: " + author + ", ISBN: " + isbn);
    }
}