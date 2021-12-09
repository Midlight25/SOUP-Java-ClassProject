package com.SOUPcorp.app;

public class Product implements Item {
    private String name;
    private double price;

    /**
     * Product constructor
     * @param name Name of product
     * @param price Price of product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * name getter
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * price getter
     * @return double price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Product toString
     * @return String name and price of product
     */
    public String toString() {
        String s = name + " " + price;
        return s;
    }
}
