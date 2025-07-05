package org.example;

import java.util.List;

/**
 * Service responsible for validating and processing checkout operations.
 */
public class CheckoutService {

    /**
     * Validates the cart and customer, calculates totals, and prints the receipt.
     *
     * @param customer the customer performing the checkout
     * @param cart     the cart to checkout
     * @throws IllegalStateException if any condition is invalid (e.g. expired product, insufficient balance)
     */
    public static void checkout(Customer customer,Cart cart){
        if(cart.isEmpty())
            throw new IllegalStateException("Cart is empty");


        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isExpired())
                throw new IllegalStateException("Product" + product.getName() + " is expired");

            if (item.getQuantity() > product.getQuantity())
                throw new IllegalStateException("Product" + product.getName() + "is out of stock");
        }

            double subtotal = cart.getSubTotal();
            List<Shippable> shippableItems=cart.getShippableItem();
            double shippableFees=ShippingService.calculateShipping(shippableItems);
            double total=subtotal+shippableFees;

            if(customer.getBalance() < total)
                throw new  IllegalStateException("Not enough balance");

            customer.deduct(total);

            System.out.println("** Checkout receipt **");

            for (CartItem item:cart.getItems()){
                System.out.println(item.getQuantity() + "x "+item.getProduct().getName() + " "+(int)item.getTotalPrice());
                item.getProduct().decreaseQuantity(item.getQuantity());
            }

        System.out.println("--------------------");
        System.out.println("Subtotal "+(int)subtotal);
        System.out.println("Shipping "+(int)shippableFees);
        System.out.println("Amount "+(int)total);
        System.out.println("End.");
        }


}
