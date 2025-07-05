package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ExpirableShippableProduct extends Product implements Shippable{

    LocalDate expiryDate;
    double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate,double weight){
        super(name,price,quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
