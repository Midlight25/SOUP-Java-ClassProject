public class Buyer extends User {
    private ShoppingCart shoppingCart;

    public Buyer(String username, String password) {
        super.userType = "Buyer";
        shoppingCart = new ShoppingCart();
    }

    public Buyer() {
    }

    public void addToCart(Item item, int quantity) {
        shoppingCart.addCartItem(item, quantity);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String getUsername() {
        return super.username;
    }

    @Override
    public String getPassword() {
        return super.password;
    }

    @Override
    public String getUserType() {
        return "Buyer";
    }

    @Override
    public void setUsername(String username) {
        super.username = username;
    }

    @Override
    public void setPassword(String password) {
        super.password = password;
    }

    @Override
    public void setUserType() {
        super.userType = "Buyer";
    }
}
