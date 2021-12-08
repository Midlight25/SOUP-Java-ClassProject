import java.util.*;

public class Inventory implements Iterable<Item> {
    private Map<Item, Integer> items;
    ArrayList<String> products;

    public Inventory() {
        items = new HashMap<Item, Integer>();
        products = ShopSystem.fetchProducts();

        for (String productStr : products) {
            String[] split = productStr.split("\\s+");
            System.out.println(split);
            System.out.println(split.length);
            String name = split[0];
            double price = Double.parseDouble(split[1]);
            Product product = new Product(name, price);
            int quantity = Integer.parseInt(split[2]);
            items.put(product, quantity);
        }
    }

    public void updateQuantity(Item item, Integer newQuantity) {
        items.replace(item, newQuantity);
        ShopSystem.getInstance().updateProducts(item.getName(), newQuantity);
    }

    public Map<Item, Integer> getInventory() {
        return items;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    /*
    private class ItemIterator implements Iterator<Item> {
        private int i;

        public ItemIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < items.size();
        }

        @Override
        public Item next() {
            Item item = items.keySet().toArray()[i];
            i++;
            return item;
        }

        @Override
        public void remove() {
            items.remove(i);
        }
    }
     */
}
