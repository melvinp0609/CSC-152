import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CarolinaPanthers2026GUITesting extends JFrame {
    private JPanel mainPanel, buttonPanel, itemPanel;
    private JButton button1, button2;
    private JList<String> itemList;
    private DefaultListModel<String> listModel;

    public CarolinaPanthers2026GUITesting() {
        setTitle("NFL Carolina Panthers 2026 Season Info");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel(new CardLayout());
        buttonPanel = new JPanel();
        itemPanel = new JPanel();

        button1 = new JButton("Players");
        button2 = new JButton("Coaches/Staff");

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setVisibleRowCount(10);

        itemList.addListSelectionListener(new ItemSelectionListener());

        JScrollPane scrollPane = new JScrollPane(itemList);

        itemPanel.add(scrollPane);
        JButton backButton = new JButton("Back to Main");
        itemPanel.add(backButton);

        mainPanel.add(buttonPanel, "Buttons");
        mainPanel.add(itemPanel, "Items");

        add(mainPanel, BorderLayout.CENTER);

        button1.addActionListener(new ButtonClickListener("Items 1"));
        button2.addActionListener(new ButtonClickListener("Items 2"));
        backButton.addActionListener(e -> showButtons());
    }

    private class ButtonClickListener implements ActionListener {
        private String itemCategory;

        public ButtonClickListener(String itemCategory) {
            this.itemCategory = itemCategory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updateItemList();
            showItems();
        }

        private void updateItemList() {
            listModel.clear();
            String[] items;
            if (itemCategory.equals("Item 1")) {
                items = new String[]{"Item 1A", "Item 1B", "Item 1C"};
            }
            else {
                items = new String[]{"Item 2A", "Item 2B", "Item 2C"};
            }
            for (String item : items) {
                listModel.addElement(item);
            }
            itemList.setModel(listModel);
        }
    }

    private class ItemSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = itemList.getSelectedValue();
                if (selectedItem != null) {
                    showItemDetail(selectedItem);
                }
            }
        }
    }

    private void showItemDetail(String selectedItem) {
        String message;

        switch (selectedItem) {
            case "Item 1A":
                message = "Details about Item 1A";
                break;
            case "Item 1B": 
                message = "Details about Item 1B";
                break;
            case "Item 1C":
                message = "Details about Item 1C";
                break;
            case "Item 2A":
                message = "Details about Item 2A";
                break;
            case "Item 2B": 
                message = "Details about Item 2B";
                break;
            case "Item 2C":
                message = "Details about Item 2C";
                break;
            default:
                message = "No details available for " + selectedItem;
        }

        JOptionPane.showMessageDialog(this, message, "Item Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showItems() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Items");
    }

    private void showButtons() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Buttons");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarolinaPanthers2026GUITesting viewer = new CarolinaPanthers2026GUITesting();
            viewer.setVisible(true);
        });
    }
}
