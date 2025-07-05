package org.example;

import java.util.List;

/**
 * Service responsible for handling the shipping of products.
 */
public class ShippingService {
    /**
     * Calculates the total shipping cost and prints shipment details to the console.
     *
     * @param items list of shippable items to be shipped
     * @return total shipping fee based on weight (30 per kg)
     */
    public static double calculateShipping(List<Shippable> items){
        double totalWeight=items.stream().mapToDouble(Shippable::getWeight).sum();

        if(!items.isEmpty()){
            System.out.println("** Shipment notice **");
            for (Shippable item:items){
                System.out.println("1x "+item.getName() + " "+(int) (item.getWeight()*100)+"g");

            }

            System.out.println("Total weight is "+totalWeight+"kg");
        }
        return  totalWeight*30;
    }
}
