package com.SOUPcorp.app;

public class Discounted implements Item {
    private Item item;
    private double discount;

    /**
     * Discounted constructor
     * @param item Discounted item
     * @param discount Discount to place on item
     */
    public Discounted(Item item, double discount) {
        this.item = item;
        this.discount = discount;
    }

    /**
     * price getter
     * @return Double discounted price
     */
    @Override
    public double getPrice() {
        return item.getPrice() * discount;
    }

    /**
     * name getter
     * @return String discounted item name
     */
    @Override
    public String getName() {
        return item.getName();
    }

    /**
     * Discounted toString
     * @return String item and it's discount
     */
    @Override
    public String toString() {
        return "Discounted Item: " + item.getName() + " by" + discount;
    }
}