package com.SOUPcorp.app;

public class Seller extends User {
    Inventory inventory;

    /**
     * Seller constructor
     */
    public Seller() {
        super.userType = "Seller";
        inventory = new Inventory();
    }

    /**
     * username getter
     * @return String username
     */
    @Override
    public String getUsername() {
        return super.username;
    }

    /**
     * password getter
     * @return String password
     */
    @Override
    public String getPassword() {
        return super.password;
    }

    /**
     * userType getter
     * @return String userType which is seller
     */
    @Override
    public String getUserType() {
        return "Seller";
    }
}
