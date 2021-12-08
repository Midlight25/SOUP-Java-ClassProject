import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Map;

public class SellerGUI extends JFrame {
    private JPanel tablePanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel panel;
    private JLabel productName;
    private JLabel productQuantity;
    private JTextField productNameText;
    private JTextField productQuantityText;
    private JButton updateButton;
    private JButton ordersButton;
    private JTable table;

    public SellerGUI(Seller seller) {
        tablePanel = new JPanel(new GridLayout(1, 0));
        textPanel = new JPanel(new GridLayout(5, 2));
        buttonPanel = new JPanel(new GridLayout(1, 3,5,5));

        JTable table = new JTable(new SellerTable(seller));
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        productName = new JLabel("Name: ");
        productQuantity = new JLabel("New Quantity: ");
        productNameText = new JTextField("", 15);
        productQuantityText = new JTextField("", 15);
        textPanel.add(productName);
        textPanel.add(productNameText);
        textPanel.add(productQuantity);
        textPanel.add(productQuantityText);

        updateButton = new JButton("Update Quantity");
        updateButton.setSize(20, 40);
        buttonPanel.add(updateButton);
        ordersButton = new JButton("Order History");
        ordersButton.setSize(20, 20);
        buttonPanel.add(ordersButton);


        panel = new JPanel(new BorderLayout());
        panel.add(tablePanel, BorderLayout.NORTH);
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH );
        panel.setBorder(BorderFactory.createTitledBorder("Seller Page"));

        JFrame frame = new JFrame("Seller Page ");
        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
        table.enableInputMethods(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newQuantity = Integer.parseInt(productQuantityText.getText().trim());
                Map<Item, Integer> products = ShopSystem.getInstance().fetchInventory();
                for (Item key : products.keySet()) {
                    if (key.getName().equals(productNameText.getText().trim())) {
                        ShopSystem.getInstance().inventory.updateQuantity(key, newQuantity);
                        table.repaint();
                        productNameText.setText("");
                        productQuantityText.setText("");
                    }
                }
            }
        });

        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                OrderHistoryGUI orderHistoryGUI = new OrderHistoryGUI(seller);
            }
        });
    }
}

class SellerTable extends AbstractTableModel {
    private String[] columnNames = {"Name", "Quantity", "Price"};
    Map<Item, Integer> products;
    Seller seller;

    public SellerTable(Seller s) {
        seller = s;
        products = ShopSystem.getInstance().fetchInventory();
    }

    @Override
    public int getRowCount() {
        return products.size();
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
        for (Item it : products.keySet()) {
            if (i == rowIndex) {
                switch (columnIndex) {
                    case 0:
                        val = it.getName();
                        break;
                    case 1:
                        val = products.get(it);
                        break;
                    case 2:
                        val = it.getPrice();
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
