package com.SOUPcorp.app;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class OrderHistoryGUI extends JFrame {
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JPanel panel;
    private JButton backButton;

    /**
     * OrderHistoryGUI constructor
     * @param seller Currently logged in Seller
     */
    public OrderHistoryGUI(Seller seller) {
        tablePanel = new JPanel(new GridLayout(1, 0));
        buttonPanel = new JPanel(new GridLayout(1, 3,5,5));

        JTable table = new JTable(new OrderHistoryTable(seller));
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        backButton = new JButton("Go Back");
        backButton.setSize(20, 40);
        buttonPanel.add(backButton);

        panel = new JPanel(new BorderLayout());
        panel.add(tablePanel, BorderLayout.NORTH);
        panel.add(buttonPanel,BorderLayout.SOUTH );
        panel.setBorder(BorderFactory.createTitledBorder("Order History"));

        JFrame frame = new JFrame("Order History ");
        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
        table.enableInputMethods(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SellerGUI sellerPage = new SellerGUI(seller);
            }
        });

    }
}

class OrderHistoryTable extends AbstractTableModel {
    private String[] columnNames = {"Name", "CC Number", "Total"};
    ArrayList<String> orderHistory;
    Seller seller;

    /**
     * OrderHistoryTable constructor
     * @param s Currently logged in Seller
     */
    public OrderHistoryTable(Seller s) {
        seller = s;
        orderHistory = ShopSystem.getInstance().fetchOrderHistory();
    }

    /**
     * rowCount getter
     * @return int Number of rows in table model
     */
    @Override
    public int getRowCount() {
        return orderHistory.size();
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
        for (String order : orderHistory) {
            String[] split = order.split("\\s+");
            if (i == rowIndex) {
                if (columnIndex == 0) {
                    val = split[0];
                    break;
                }
                else if (columnIndex == 1) {
                    val = split[1];
                    break;
                }
                else {
                    val = split[2];
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