package com.SOUPcorp.app;

import java.util.ArrayList;

public class Combo implements Item {
    private ArrayList<Item> items;
    private String name;
    private Double price;

    public Combo() {
        items = new ArrayList<Item>();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "";
        for (Item item : items) {
            s += item.getName();
        }
        return s;
    }
}
