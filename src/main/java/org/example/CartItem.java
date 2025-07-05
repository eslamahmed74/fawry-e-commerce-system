package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product in the cart with a specific quantity.
 */
@Getter
@AllArgsConstructor
public class CartItem {
    Product product;
    int quantity;

    /**
     * Calculates the total price of this item in the cart.
     *
     * @return total price = product price × quantity
     */
    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }
}
