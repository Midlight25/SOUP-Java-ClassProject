package com.SOUPcorp.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class LoginGUI {
    private JTextField username;
    private JTextField password;
    private JLabel uLabel;
    private JLabel pLabel;
    private JPanel loginPanel;
    private JPanel buttonPanel;
    private JPanel panel;
    private JButton loginButton;
    private JButton registerBuyerButton;

    public LoginGUI() {
        username = new JTextField("", 20);
        username.setSize(5, 2);
        password = new JTextField("", 20);
        uLabel = new JLabel("Username: ");
        uLabel.setPreferredSize(new Dimension(150, 30));
        pLabel = new JLabel("Password: ");
        pLabel.setPreferredSize(new Dimension(150, 30));
        loginPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        panel = new JPanel(new BorderLayout());
        username.setBounds(15, 15, 155, 55);
        username.setPreferredSize(new Dimension(150, 25));
        password.setPreferredSize(new Dimension(150, 25));

        loginPanel.add(uLabel);
        loginPanel.add(username);
        loginPanel.add(pLabel);
        loginPanel.add(password);

        loginButton = new JButton("Login");
        registerBuyerButton = new JButton("Register Buyer");

        buttonPanel.add(loginButton);
        buttonPanel.add(registerBuyerButton);
        panel.add(loginPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createTitledBorder("Login"));

        JFrame frame = new JFrame("Shopping Cart Application");
        frame.setSize(500, 200);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText = password.getText();

                String userType = ShopSystem.getInstance().verifyLogin(usernameText, passwordText);
                if (userType.equals("Invalid")) {
                    JOptionPane.showMessageDialog(null, "Invalid Login. Try again!");
                    username.setText("");
                    password.setText("");
                } else if (userType.equals("Seller")) {
                    frame.dispose();
                    Seller seller = new Seller(usernameText, passwordText);
                    SellerGUI sellerGUI = new SellerGUI(seller);
                } else {
                    frame.dispose();
                    Buyer buyer = new Buyer(usernameText, passwordText);
                    ProductsGUI productsGUI = new ProductsGUI(buyer);
                }
            }
        });

        registerBuyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User buyer = new Buyer();
                String userInfo = username.getText() + " " + password.getText() + " Buyer";
                try {
                    ShopSystem.getInstance().addUser(userInfo);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
