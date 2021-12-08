import java.io.FileNotFoundException;

public abstract class User {
    protected String username;
    protected String password;
    protected String userType;

    public final void register() throws FileNotFoundException {
        String userInfo = getUsername() + " " + getPassword() + " " + getUserType();
        ShopSystem.getInstance().addUser(userInfo);
    }

    public final String toString() {
        String s = "Username: " + getUsername() + " User Type: " + getUserType();
        System.out.println(s);
        return s;
    }

    public abstract String getUsername();
    public abstract String getPassword();
    public abstract String getUserType();

    public abstract void setUsername(String username);
    public abstract void setPassword(String password);
    public abstract void setUserType();
}
