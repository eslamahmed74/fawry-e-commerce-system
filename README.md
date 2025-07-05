# 🛒 Fawry Internship – E-Commerce System

## 👨‍💻 Developed by: Eslam Ahmed
## 💻 Language: Java (with Lombok)
## 🧰 Build Tool: Maven
## 📦 Used Library:
- [Lombok](https://projectlombok.org/) – to reduce boilerplate code (constructors, getters, setters)

---

## 📘 Problem Overview

This system simulates a basic **E-Commerce workflow** as per the Fawry internship challenge:

- Products can be:
    - **Expirable** (e.g. Cheese, Biscuits)
    - **Shippable** (e.g. Cheese, TV)
    - **Non-Shippable** (e.g. Mobile scratch cards)
- Customers can:
    - Add products to a cart with a limited quantity
    - Checkout if all conditions are valid
- Checkout will:
    - Print invoice with subtotal, shipping, and amount
    - Print shipping notice only for shippable items
    - Reject checkout if:
        - Cart is empty
        - A product is expired or out of stock
        - Customer balance is insufficient

---

## 🧱 Class Design

| Class/Interface              | Responsibility                                                                 |
|-----------------------------|----------------------------------------------------------------------------------|
| `Product` (abstract)         | Base class for all products with name, price, quantity                          |
| `Shippable` (interface)      | Interface for shippable items with `getName()` and `getWeight()`                |
| `ExpirableShippableProduct` | Products that expire and need shipping (e.g. Cheese)                            |
| `NonExpirableShippableProduct` | Products that don’t expire but need shipping (e.g. TV)                        |
| `NonShippableProduct`       | Products that neither expire nor ship (e.g. Scratch Cards)                      |
| `CartItem`                  | Holds a product and quantity                                                    |
| `Cart`                      | Holds a list of cart items, calculates subtotal and shippable items             |
| `Customer`                  | Represents a user with balance                                                  |
| `ShippingService`           | Accepts shippable items, prints shipping info, and calculates total weight      |
| `CheckoutService`           | Handles validation and checkout process                                         |
| `Main`                      | Simulates the system with a real example                                        |

---

## 💡 Assumptions

- Shipping cost = `30 × weight in kg`
- Adding a product checks if enough stock is available
- Expired products are not allowed at checkout
- If a product is shippable, each quantity is counted as individual line in shipping notice

---

## ✅ Features Implemented

- Add products to cart
- Handle expired and out-of-stock validation
- Prevent checkout when:
    - Cart is empty
    - Insufficient balance
    - Product expired or quantity exceeded
- Calculate:
    - Subtotal
    - Shipping fees (if any)
    - Total paid
- Print:
    - Shipping notice
    - Invoice receipt

---

## 🧪 Sample Test Scenario

In the `Main` class, I ran:

```java
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);
CheckoutService.checkout(customer, cart);

📤 Console Output:
** Shipment notice **
1x Cheese 20g
1x Cheese 20g
1x Biscuits 70g
Total weight is 1.1kg
** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
--------------------
Subtotal 400
Shipping 33
Amount 433
End.