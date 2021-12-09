package com.SOUPcorp.app;

/**
 * Main App Class for running the program.
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
