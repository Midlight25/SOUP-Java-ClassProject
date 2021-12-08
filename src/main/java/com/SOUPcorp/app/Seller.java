public class Seller extends User {
    Inventory inventory;
    private double revenue;

    public Seller(String username, String password) {
        super.userType = "Seller";
        inventory = new Inventory();
    }

    public Seller() {
    }

    public Inventory getInventory() {
        return inventory;
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
        return "Seller";
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
        super.userType = "Seller";
    }
}
