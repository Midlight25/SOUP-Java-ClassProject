import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ShopSystem {
    public static ShopSystem instance = new ShopSystem();
    public Inventory inventory = new Inventory();

    private ShopSystem() {
    }

    public static ShopSystem getInstance() {
        return instance;
    }

    public void addUser(String userInfo) throws FileNotFoundException {
        try (FileWriter out = new FileWriter("src/UserInfo.txt", true)) {
            out.write(userInfo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fetchUser(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/UserInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\s+");
                if (split[0] == username)
                    return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "User not found!";
    }

    public static ArrayList<String> fetchProducts() {
        ArrayList<String> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProducts(String name, int newQuantity) {
        ArrayList<String> products = fetchProducts();
        try (FileWriter out = new FileWriter("src/Products.txt")) {
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

    public String verifyLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/UserInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\s+");
                if (split[0].equals(username) && split[1].equals(password)) {
                    System.out.println("Success");
                    return split[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Invalid";
    }

    public Map<Item, Integer> fetchInventory() {
        return inventory.getInventory();
    }

    public void updateOrderHistory(String orderDetails) {
        try (FileWriter out = new FileWriter("src/OrderHistory.txt", true)) {
            out.write(orderDetails + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> fetchOrderHistory() {
        ArrayList<String> orderHistory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/OrderHistory.txt"))) {
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
