package com.SOUPcorp.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> items;

    public ShoppingCart() {
        items = new HashMap<Item, Integer>();
    }

    public void addCartItem(Item item, int quantity) {
        items.put(item, quantity);
    }

    public ArrayList<Double> findEachPrice() {
        ArrayList<Double> prices = new ArrayList<Double>();

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            Integer value = entry.getValue();
            prices.add(item.getPrice() * value);
        }

        return prices;
    }

    public double findTotalPrice() {
        double total = 0.0;

        ArrayList<Double> prices = findEachPrice();
        for (int i = 0; i < prices.size(); i++) {
            total = total + prices.get(i);
        }

        return total;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}
