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

    /**
     * ReviewCartGUI constructor
     * @param buyer Currently logged in Buyer
     */
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

    /**
     * ReviewCartTable constructor
     * @param b Currently logged in Buyer
     */
    public ReviewCartTable(Buyer b) {
        buyer = b;
        cart = buyer.getShoppingCart();
    }

    /**
     * rowCount getter
     * @return int Number of rows in table model
     */
    @Override
    public int getRowCount() {
        return cart.getItems().size();
    }

    /**
     * columnCount getter
     * @return int Number of columns in table model
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * columnName getter
     * @param column Index of column
     * @return String Name of column
     */
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * valueAtIndex getter
     * @param rowIndex Current Row
     * @param columnIndex Current Column
     * @return Object Value at row and column
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object val = null;

        int i = 0;
        for (Item it : cart.getItems().keySet()) {
            if (i == rowIndex) {
                if (columnIndex == 0) {
                    val = it.getName();
                }
                else {
                    val = cart.getItems().get(it);
                    break;
                }
            }
            i++;
        }
        return val;
    }

    /**
     * columnClass getter
     * @param c Column index
     * @return Class Class of value
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}

