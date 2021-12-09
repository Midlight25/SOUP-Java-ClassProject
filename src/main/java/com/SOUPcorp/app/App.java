package com.SOUPcorp.app;

/**
 * Main Application Class, program starts here.
 *
 */
public class App {
    /**
     * Starts Shopping Cart application.
     *
     * @param args String arguments from the command line.
     */
    public static void main(String[] args) {
        System.out.println("Starting Shop Application");
        FirstTimeSetup.setup();
        LoginGUI GUI = new LoginGUI();
    }
}
