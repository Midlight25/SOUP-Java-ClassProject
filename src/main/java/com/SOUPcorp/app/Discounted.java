package com.SOUPcorp.app;

public class Discounted implements Item {
    private Item item;
    private double discount;

    public Discounted(Item item, double discount) {
        this.item = item;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return item.getPrice() * discount;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public String toString() {
        return "Discounted Item: " + item.getName() + " by" + discount;
    }
}