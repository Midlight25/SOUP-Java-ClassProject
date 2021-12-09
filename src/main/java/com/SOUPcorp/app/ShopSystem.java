package com.SOUPcorp.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ShopSystem {
    public static ShopSystem instance = new ShopSystem();
    public Inventory inventory = new Inventory();

    /**
     * ShopSystem constructor
     */
    private ShopSystem() {
    }

    /**
     * instance getter
     * @return ShopSystem instance (Singleton pattern)
     */
    public static ShopSystem getInstance() {
        return instance;
    }

    /**
     * adds user to UserInfo file
     * @param userInfo String (username, password, userType)
     * @throws FileNotFoundException
     */
    public void addUser(String userInfo) throws FileNotFoundException {
        try (FileWriter out = new FileWriter("data/UserInfo.txt", true)) {
            out.write(userInfo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * fetches products from Products file
     * @return ArrayList products
     */
    public static ArrayList<String> fetchProducts() {
        ArrayList<String> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/Products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * updates quantity of product in Products file
     * @param name Name of product to be updated
     * @param newQuantity New quantity of updated product
     */
    public void updateProducts(String name, int newQuantity) {
        ArrayList<String> products = fetchProducts();
        try (FileWriter out = new FileWriter("data/Products.txt")) {
            for (String product : products) {
                String[] split = product.split("\\s+");
                if (split[0].equals(name)) {
                    out.write(split[0] + " " + split[1] + " " + newQuantity + "\n");
                }
                else {
                    out.write(product + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * verifies that login user exists by checking UserInfo file
     * @param username Name of user trying to login
     * @param password Password of user trying to login
     * @return String userType or Invalid if user doesn't exist
     */
    public String verifyLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/UserInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\s+");
                if (split[0].equals(username) && split[1].equals(password)) {
                    return split[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Invalid";
    }

    /**
     * fetches current inventory of products
     * @return Map inventory
     */
    public Map<Item, Integer> fetchInventory() {
        return inventory.getInventory();
    }

    /**
     * writes new order details to OrderHistory file
     * @param orderDetails Name and CC number of customer
     */
    public void updateOrderHistory(String orderDetails) {
        try (FileWriter out = new FileWriter("data/OrderHistory.txt", true)) {
            out.write(orderDetails + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads order history from OrderHistory file
     * @return ArrayList orderHistory
     */
    public ArrayList<String> fetchOrderHistory() {
        ArrayList<String> orderHistory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/OrderHistory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                orderHistory.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

}
