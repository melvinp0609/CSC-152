import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarolinaPanthers2026GUITesting {

    // Shows the first panel which allows the user to choose between players and coaches/staff.
    private static JFrame frame;
    private static JPanel currentPanel;
    private static JLabel selectedThingLabel;
    private static JComboBox<String> thingComboBox;

    public static void main(String[] arg) {
        // Frame creation
        frame = new JFrame("NFL Carolina Panthers 2026 Season Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        // Start with the first panel
        currentPanel = createPanel1();
        frame.add(currentPanel);

        // Create buttons to switch panels
        JButton button1 = new JButton("Players");
        JButton button2 = new JButton("Coaches/Staff");

        // Add ActionListeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code
            }
        });
        
        button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                coachesstaffList(currentPanel);
           } 
        });
        
        // Create a panel for buttons and add them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private static void switchPanel(JPanel newPanel) {
        frame.remove(currentPanel);
        currentPanel = newPanel;
        frame.add(currentPanel);
        frame.revalidate();
        frame.repaint();
    }

    private static JPanel createPanel1() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Carolina Panthers Players"));
        return panel;
    }

    private static JPanel createPanel2() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Carolina Panthers Coaches/Staff"));
        return panel;
    }

    private static void playersList(JPanel panel) {
        String[] players = {
            // Active
            "Thing 1",
            "Thing 2",
            "Thing 3"
        };

        String selectedThing = (String) JOptionPane.showInputDialog(
            panel,
            "Select a thing: ",
            "Things",
            JOptionPane.PLAIN_MESSAGE,
            null,
            players,
            players[0]
        );

        if (selectedThing != null) {
            System.out.println("Selected thing: " + selectedThing);
        }
    }

    private static void coachesstaffList(JPanel panel) {

    }
}
