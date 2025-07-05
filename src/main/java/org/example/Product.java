package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract base class for all product types.
 * Defines shared attributes such as name, price, and quantity.
 * Also defines a method to check for product expiration.
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class Product {

    protected String name;
    protected  double price;
    protected  int quantity;

    /**
     * Checks whether the product is expired.
     *
     * @return true if the product is expired, false otherwise
     */
    public abstract boolean isExpired();

    /**
     * Decreases the quantity of the product.
     *
     * @param amount amount to subtract from available quantity
     */
    public void decreaseQuantity(int amount){
        this.quantity -= amount;
    }

}
