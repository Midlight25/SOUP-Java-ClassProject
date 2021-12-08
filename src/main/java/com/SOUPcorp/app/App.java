package com.SOUPcorp.app;

/**
 * Hello world!
 *
 */
public class App {
    /**
     * Main Function, only prints Hello World at the moment.
     * 
     * @param args String arguments from the command line.
     */
    public static void main(String[] args) {
        System.out.println("Starting Shop Application");
        FirstTimeSetup.setup();
        LoginGUI GUI = new LoginGUI();
    }
}
