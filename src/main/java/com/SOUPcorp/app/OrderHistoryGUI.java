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

    public OrderHistoryTable(Seller s) {
        seller = s;
        orderHistory = ShopSystem.getInstance().fetchOrderHistory();
    }

    @Override
    public int getRowCount() {
        return orderHistory.size();
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
        for (String order : orderHistory) {
            String[] split = order.split("\\s+");
            if (i == rowIndex) {
                switch (columnIndex) {
                    case 0:
                        val = split[0];
                        break;
                    case 1:
                        val = split[1];
                        break;
                    case 2:
                        val = split[2];
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