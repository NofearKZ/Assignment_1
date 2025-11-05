E-Commerce Console System in Java

Student: Zhan Kudaibergenov

Student ID: 10623198

Course: Information and Communication Technologies

Date: November 05 2025

Objective

The main objective of this project was to design a simple e-commerce console system in Java that
demonstrates core Object-Oriented Programming (OOP) principles such as inheritance,
encapsulation, and polymorphism. The project aims to simulate a small marketplace where users
can browse products, place orders, and manage them through a simple command-line interface.

Requirement Analysis

The requirements for the system included creating classes for User, Customer, Employee, Product,
and Order. The system should allow different roles to perform specific tasks: employees can add
products or manage users, while customers can view products and place orders. The system
should store products in a collection and display them in a readable format.

UML Class Diagram

The simplified UML diagram below shows the main relationships among the classes.
```
+-------------------+          calls           +-------------------+
| ExampleController |------------------------->| ExampleService    |
| - service         |                          | - repo            |
| + getById()       |                          | + findById()      |
| + create()        |                          | + save()          |
+-------------------+                          +-------------------+
          |  uses                                          |
          v                                                v
+-------------------+          returns         +-------------------+
|     ExampleDto    |<-------------------------|  ExampleRepository|
+-------------------+                          | + findById()      |
                                               | + save()          |
                                               +-------------------+
```
 

Design and Implementation Notes

The system was implemented using core Java. The main class (ECommerceSystem.java) acts as
the entry point, creating a simple console-based interface. All data, such as users, products, and
orders, are stored in ArrayLists for simplicity. Inheritance was used to create subclasses of User
and Product. Encapsulation ensured that data fields were private and accessible only via getters
and setters. Basic input validation was implemented using Scanner to handle incorrect inputs
gracefully.

Git Repository

The full project source code is hosted on GitHub as part of the Information and Communication
Technologies course: https://github.com/NofearKZ/Assignment_1

Conclusion

This project provided valuable hands-on experience with object-oriented programming in Java. By
developing an e-commerce console system, I learned how to structure a program using classes
and inheritance, handle user input, and design a basic interactive system. The task helped reinforce
concepts such as encapsulation, polymorphism, and abstraction in a practical context.
