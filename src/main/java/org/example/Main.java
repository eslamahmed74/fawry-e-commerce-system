package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product cheese= new ExpirableShippableProduct("Cheese",100,10, LocalDate.now().plusDays(2),0.2);
        Product biscuits=new ExpirableShippableProduct("Biscuits",150,5, LocalDate.now().plusDays(2),0.7);
        Product tv= new NonExpirableShippableProduct("TV",3000,3,5.0);
        Product scratchCard= new NonShippableProduct("Scratch Card",50,20);

        Customer customer= new Customer("Eslam",10000);
        Cart cart= new Cart();
        cart.add(cheese,2);
        cart.add(biscuits,1);
        cart.add(scratchCard,1);

        CheckoutService.checkout(customer,cart);
    }
}