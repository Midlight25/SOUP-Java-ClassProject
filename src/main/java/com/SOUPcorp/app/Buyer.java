package com.SOUPcorp.app;

/**
 * Representation for a buyer in the shop system. Extends the user superclass.
 */
public class Buyer extends User {
    private ShoppingCart shoppingCart;

    /**
     * Buyer constructor
     */
    public Buyer() {
        super.userType = "Buyer";
        shoppingCart = new ShoppingCart();
    }

    /**
     * Buyer adds item to their shopping cart
     * @param item Item to add
     * @param quantity Quantity of item to add
     */
    public void addToCart(Item item, int quantity) {
        shoppingCart.addCartItem(item, quantity);
    }

    /**
     * ShoppingCart getter
     * @return ShoppingCart object
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
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
     * @return String userType which is buyer
     */
    @Override
    public String getUserType() {
        return "Buyer";
    }
}
