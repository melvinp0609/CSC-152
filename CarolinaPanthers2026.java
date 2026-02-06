import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarolinaPanthers2026 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NFL Carolina Panthers 2026 Season Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        pantherPlayers(panel);
        pantherCoaches(panel);
        
        // Wilsonb2742's code ------------------------------------------------------------------------------
        boolean running = true;
        while (running) {
            String[] mainOptions = {"Players", "Coaches/Staff", "Exit"};
            String mainChoice = (String) JOptionPane.showInputDialog(
                panel,
                "Select a category:",
                "Carolina Panthers 2026",
                JOptionPane.PLAIN_MESSAGE,
                null,
                mainOptions,
                mainOptions[0]
            );

            if (mainChoice == null || mainChoice.equals("Exit")) {
                running = false;
                break;
                // TODO: Stop another panel from popping up after clicking exit or the (x) button.
            }

            switch (mainChoice) {
                case "Players":
                    showPlayers(panel);
                    break;
                case "Coaches/Staff":
                    showCoaches(panel);
                    break;
                default:
                    JOptionPane.showMessageDialog(panel, "Invalid choice.");
            }
        }
        // ------------------------------------------------------------------------------------------------

        frame.setVisible(true);
    }

    private static void pantherPlayers(JPanel panel) {
        JButton pantherPlayersButton = new JButton("Players");
        panel.add(pantherPlayersButton);

        pantherPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] items = { "Player 1", "Player 2", "Player 3", "Player 4" };
                String message = "Click on a player:";

                String selectedItem = (String) JOptionPane.showInputDialog(
                    panel,
                    message,
                    "Select Item",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    items,
                    items[0]
                );

                if (selectedItem != null) {
                    String info = getItemInfo(selectedItem);
                    JOptionPane.showMessageDialog(panel, info);
                }
            }
        });
    }

    private static String getItemInfo(String item) {
        switch (item) {
            case "Item 1":
                return "Information about Item 1.";
            case "Item 2":
                return "Information about Item 2.";
            case "Item 3":
                return "Information about Item 3.";
            case "Item 4":
                return "Information about Item 4.";
            default:
                return "No information available.";
        }
    }

    private static void pantherCoaches(JPanel panel) {
        JButton pantherCoachesButton = new JButton("Coaches");
        panel.add(pantherCoachesButton);
    }
}