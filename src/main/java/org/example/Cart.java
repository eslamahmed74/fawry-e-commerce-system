package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's shopping cart.
 * Contains multiple cart items and provides logic for subtotal and shipping.
 */
@Getter
public class Cart {
    List<CartItem> items=new ArrayList<>();

    /**
     * Adds a product to the cart if the quantity is available in stock.
     *
     * @param product  the product to add
     * @param quantity the quantity to add
     */
    public  void add(Product product,int quantity){
        if(quantity>product.getQuantity()){
            throw new IllegalArgumentException("there is no enough stock for product : "+product.getName());
        }
        items.add(new CartItem(product,quantity));
    }

    /**
     * Checks if the cart is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }


    /**
     * Calculates the total price of all items in the cart.
     *
     * @return subtotal of the cart
     */
    public double getSubTotal(){
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    /**
     * Filters and returns all shippable products in the cart.
     * Each unit is counted separately.
     *
     * @return list of shippable items
     */
    public List<Shippable> getShippableItem(){
        List<Shippable> list= new ArrayList<>();

        for (CartItem item:items){
            if (item.getProduct() instanceof Shippable shippable){
                for (int i=0;i<item.getQuantity();i++){
                    list.add(shippable);
                }
            }
        }
        return list;
    }
}
