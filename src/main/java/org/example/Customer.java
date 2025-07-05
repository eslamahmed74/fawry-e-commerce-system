package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a customer with a name and available balance.
 */
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    String name;
    double balance;

    /**
     * Deducts a specified amount from the customer's balance.
     *
     * @param amount the amount to deduct
     */
    public void deduct(double amount){
        this.balance-=amount;
    }
}
