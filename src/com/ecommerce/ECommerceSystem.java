package com.ecommerce;

import com.ecommerce.entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ECommerceSystem {
    private List<User> users;
    private List<Product> products;
    private List<Order> orders;
    private Scanner scanner;

    public ECommerceSystem() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeSampleData();
    }


    private void initializeSampleData() {
        // default admin employee
        Employee admin = new Employee("Admin", "admin@example.com", "admin123");
        users.add(admin);
        // sample products
        products.add(new Book("The Great Gatsby", 9.99, 10, "F. Scott Fitzgerald", "9780743273565"));
        products.add(new Electronics("Smartphone", 399.99, 20, "TechBrand", "X100"));
        products.add(new Clothing("T‑Shirt", 14.99, 50, "M", "Blue"));
    }


    public void start() {
        System.out.println("Welcome to the Console‑Based E‑Commerce System!");
        boolean running = true;
        while (running) {
            System.out.println("\nSelect your role:");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.println("3. Register as new user");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    employeeLogin();
                    break;
                case "2":
                    customerLogin();
                    break;
                case "3":
                    registerUser();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the system. Goodbye!");
    }


    private void employeeLogin() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        for (User u : users) {
            if (u instanceof Employee && u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                employeeMenu((Employee) u);
                return;
            }
        }
        System.out.println("Authentication failed. Please check your credentials or register.");
    }


    private void employeeMenu(Employee employee) {
        boolean running = true;
        while (running) {
            System.out.println("\nEmployee Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Add User");
            System.out.println("4. List Users");
            System.out.println("0. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    listProducts();
                    break;
                case "3":
                    registerUser();
                    break;
                case "4":
                    listUsers();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void customerLogin() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        for (User u : users) {
            if (u instanceof Customer && u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                customerMenu((Customer) u);
                return;
            }
        }
        System.out.println("Authentication failed. Please check your credentials or register.");
    }


    private void customerMenu(Customer customer) {
        boolean running = true;
        while (running) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. List Products");
            System.out.println("2. Place Order");
            System.out.println("3. View My Orders");
            System.out.println("0. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    placeOrder(customer);
                    break;
                case "3":
                    viewCustomerOrders(customer);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void registerUser() {
        System.out.println("\nRegister New User");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you registering as a customer or employee? (c/e): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("c")) {
            Customer customer = new Customer(name, email, password);
            users.add(customer);
            System.out.println("Customer registered successfully!");
        } else if (type.equalsIgnoreCase("e")) {
            Employee employee = new Employee(name, email, password);
            users.add(employee);
            System.out.println("Employee registered successfully!");
        } else {
            System.out.println("Invalid user type. Registration failed.");
        }
    }


    private void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("\nRegistered Users:");
        for (User u : users) {
            u.displayInfo();
            System.out.println();
        }
    }


    private void addProduct() {
        System.out.println("\nAdd Product");
        System.out.println("Select product type:");
        System.out.println("1. Book");
        System.out.println("2. Electronics");
        System.out.println("3. Clothing");
        System.out.print("Enter choice: ");
        String type = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = parseDoubleInput();
        System.out.print("Enter stock quantity: ");
        int stock = parseIntInput();
        switch (type) {
            case "1":
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                products.add(new Book(name, price, stock, author, isbn));
                break;
            case "2":
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                products.add(new Electronics(name, price, stock, brand, model));
                break;
            case "3":
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                products.add(new Clothing(name, price, stock, size, color));
                break;
            default:
                System.out.println("Invalid product type. Product not added.");
                return;
        }
        System.out.println("Product added successfully!");
    }


    private void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            p.displayInfo();
        }
    }


    private void placeOrder(Customer customer) {
        if (products.isEmpty()) {
            System.out.println("No products available to order.");
            return;
        }
        Order order = new Order(customer);
        boolean ordering = true;
        while (ordering) {
            listProducts();
            System.out.print("Enter the ID of the product to add to your order (0 to finish): ");
            int id = parseIntInput();
            if (id == 0) {
                ordering = false;
                break;
            }
            Product selected = null;
            for (Product p : products) {
                if (p.getId() == id) {
                    selected = p;
                    break;
                }
            }
            if (selected == null) {
                System.out.println("Product ID not found.");
                continue;
            }
            if (selected.getStockQuantity() == 0) {
                System.out.println("Selected product is out of stock.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = parseIntInput();
            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                continue;
            }
            if (selected.getStockQuantity() < quantity) {
                System.out.println("Insufficient stock. Available: " + selected.getStockQuantity());
                continue;
            }
            // reduce stock and add duplicates of product to order
            for (int i = 0; i < quantity; i++) {
                order.addProduct(selected);
            }
            selected.reduceStock(quantity);
            System.out.println(quantity + " " + selected.getName() + "(s) added to order.");
        }
        if (!order.getProducts().isEmpty()) {
            orders.add(order);
            System.out.println("Order placed successfully!");
            order.printReceipt();
        } else {
            System.out.println("No items were added to the order.");
        }
    }


    private void viewCustomerOrders(Customer customer) {
        boolean found = false;
        for (Order o : orders) {
            if (o.getCustomer().equals(customer)) {
                o.printReceipt();
                found = true;
            }
        }
        if (!found) {
            System.out.println("You have no orders.");
        }
    }


    private int parseIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }


    private double parseDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }


    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        system.start();
    }
}