package com.ecommerce.entities;

/**
 * The base class representing a user of the e‑commerce system.
 *
 * <p>Users can be customers or employees. All user information is
 * encapsulated with private fields and accessed through getters and
 * setters to ensure proper data hiding. Subclasses can extend this
 * class to provide role‑specific functionality.</p>
 */
public abstract class User {
    private String name;
    private String email;
    private String password;
    private String role; // e.g. "customer" or "employee"

    /**
     * Constructs a User with the specified details.
     *
     * @param name     the full name of the user
     * @param email    the email address of the user
     * @param password the password for the user account
     * @param role     the role of the user in the system
     */
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and setters for encapsulation

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Displays basic information about the user.
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }
}