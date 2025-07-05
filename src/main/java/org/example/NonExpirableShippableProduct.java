package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonExpirableShippableProduct extends  Product implements Shippable{
    double weight;

    public NonExpirableShippableProduct(String name,double price,int quantity,double weight){
        super(name,price,quantity);

        this.weight=weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
