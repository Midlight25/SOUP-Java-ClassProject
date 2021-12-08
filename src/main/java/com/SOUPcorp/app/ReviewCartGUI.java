package com.SOUPcorp.app;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewCartGUI extends JFrame {
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JPanel panel;
    private JButton checkoutButton;
    private JLabel totalCostLabel;

    private JTable table;

    public ReviewCartGUI(User buyer) {
        tablePanel = new JPanel(new GridLayout(1, 0));
        buttonPanel = new JPanel(new GridLayout(1, 3,5,5));

        JTable table = new JTable(new ReviewCartTable((Buyer) buyer));
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        totalCostLabel = new JLabel("Total: $" + ((Buyer) buyer).getShoppingCart().findTotalPrice());
        checkoutButton = new JButton("Checkout");
        checkoutButton.setSize(20, 40);

        buttonPanel.add(totalCostLabel);
        buttonPanel.add(checkoutButton);

        panel = new JPanel(new BorderLayout());

        panel.add(tablePanel, BorderLayout.NORTH);
        panel.add(buttonPanel,BorderLayout.SOUTH );
        panel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));

        JFrame frame = new JFrame("Shopping Cart ");
        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
        table.enableInputMethods(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CheckoutGUI checkoutGUI = new CheckoutGUI((Buyer)buyer);
            }
        });
    }
}

class ReviewCartTable extends AbstractTableModel {
    private String[] columnNames = {"Name", "Quantity"};
    ShoppingCart cart;
    Buyer buyer;

    public ReviewCartTable(Buyer b) {
        buyer = b;
        cart = buyer.getShoppingCart();
    }

    @Override
    public int getRowCount() {
        return cart.getItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object val = null;

        int i = 0;
        for (Item it : cart.getItems().keySet()) {
            if (i == rowIndex) {
                switch (columnIndex) {
                    case 0:
                        val = it.getName();
                        break;
                    case 1:
                        val = cart.getItems().get(it);
                        break;
                }
            }
            i++;
        }
        return val;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}

