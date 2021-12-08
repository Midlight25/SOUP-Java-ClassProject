import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProductsGUI extends JFrame {
    private JPanel tablePanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel panel;
    private JLabel productName;
    private JLabel productQuantity;
    private JTextField productNameText;
    private JTextField productQuantityText;
    private JButton addButton;
    private JButton reviewButton;

    public ProductsGUI(User buyer) {
        tablePanel = new JPanel(new GridLayout(1, 0));
        textPanel = new JPanel(new GridLayout(5, 2));
        buttonPanel = new JPanel(new GridLayout(1, 3,5,5));

        JTable table = new JTable(new ProductsTable((Buyer) buyer));
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        productName = new JLabel("Name: ");
        productQuantity = new JLabel("Quantity: ");
        productNameText = new JTextField("", 15);
        productQuantityText = new JTextField("", 15);
        textPanel.add(productName);
        textPanel.add(productNameText);
        textPanel.add(productQuantity);
        textPanel.add(productQuantityText);

        addButton = new JButton("Add To Cart");
        addButton.setSize(20, 40);
        reviewButton = new JButton("Review Cart");
        reviewButton.setSize(20, 40);
        buttonPanel.add(addButton);
        buttonPanel.add(reviewButton);

        panel = new JPanel(new BorderLayout());
        panel.add(tablePanel, BorderLayout.NORTH);
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH );
        panel.setBorder(BorderFactory.createTitledBorder("Products"));

        JFrame frame = new JFrame("Products ");
        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
        table.enableInputMethods(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Item, Integer> products = ShopSystem.getInstance().fetchInventory();
                String productName = productNameText.getText().trim();
                int productStock = 0;

                for (Item key : products.keySet()) {
                    if (key.getName().equals(productName)) {
                        productStock = products.get(key);
                        int quantity = Integer.parseInt(productQuantityText.getText().trim());

                        if (quantity <= productStock) {
                            ((Buyer) buyer).addToCart(key, quantity);
                            ShopSystem.getInstance().inventory.updateQuantity(key, productStock - quantity);
                            table.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Please change quantity!");
                            productQuantityText.setText("");
                        }
                    }
                }
            }
        });

        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ReviewCartGUI reviewCartGUI = new ReviewCartGUI((Buyer)buyer);
            }
        });
    }
}

class ProductsTable extends AbstractTableModel {
    private String[] columnNames = {"Name", "Quantity", "Price"};
    Map<Item, Integer> products;
    Buyer buyer;

    public ProductsTable(Buyer b) {
        buyer = b;
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




