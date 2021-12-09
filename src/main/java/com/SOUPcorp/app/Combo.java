package com.SOUPcorp.app;

import java.util.ArrayList;

public class Combo implements Item {
    private ArrayList<Item> items;
    private String name;
    private double price;

    /**
     * Combo constructor
     */
    public Combo() {
        items = new ArrayList<Item>();
    }

    /**
     * price getter
     * @return Double price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * name getter
     * @return String name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Combo toString
     * @return String s List of items in combo
     */
    @Override
    public String toString() {
        String s = "";
        for (Item item : items) {
            s += item.getName();
        }
        return s;
    }
}
