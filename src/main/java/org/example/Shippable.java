package org.example;

/**
 * Represents products that can be shipped.
 * Implementing classes must provide product name and weight.
 */
public interface Shippable {
    String getName();
    double getWeight();
}
