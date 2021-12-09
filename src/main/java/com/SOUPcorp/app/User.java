package com.SOUPcorp.app;

public abstract class User {
    protected String username;
    protected String password;
    protected String userType;

    /**
     * User toString
     * @return String s (username, userType)
     */
    public final String toString() {
        String s = "Username: " + getUsername() + " User Type: " + getUserType();
        return s;
    }

    /**
     * username getter
     * @return String username
     */
    public abstract String getUsername();

    /**
     * password getter
     * @return String password
     */
    public abstract String getPassword();

    /**
     * userType getter
     * @return String userType
     */
    public abstract String getUserType();
}
