package com.SOUPcorp.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutGUI extends JFrame {
    private JPanel panel;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private JLabel nameLabel;
    private JLabel ccInfoLabel;
    private JLabel costLabel;
    private JButton orderB;
    private JTextField nameText;
    private JTextField ccInfoText;

    /**
     * CheckoutGUI constructor
     * @param buyer Currently logged in Buyer
     */
    public CheckoutGUI(Buyer buyer) {
        double totalCost = ((Buyer) buyer).getShoppingCart().findTotalPrice();

        nameLabel = new JLabel("Name: ");
        ccInfoLabel = new JLabel("Credit Card Number: ");
        nameText = new JTextField("", 15);
        ccInfoText = new JTextField("", 15);

        costLabel = new JLabel("Total: $" + totalCost);
        orderB = new JButton("Order");

        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Checkout"));
        buttonPanel = new JPanel(new FlowLayout());
        textPanel = new JPanel(new GridLayout(5, 2));

        textPanel.add(nameLabel);
        textPanel.add(nameText);
        textPanel.add(ccInfoLabel);
        textPanel.add(ccInfoText);

        buttonPanel.add(costLabel);
        buttonPanel.add(orderB);

        panel.add(textPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Checkout");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        orderB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderDetails = nameText.getText().trim() + " " + ccInfoText.getText().trim() + " " + totalCost;
                JOptionPane.showMessageDialog(null, "Order submitted!");
                ShopSystem.getInstance().updateOrderHistory(orderDetails);
                frame.dispose();
                ProductsGUI browseCatalog = new ProductsGUI(buyer);
            }
        });
    }
}
