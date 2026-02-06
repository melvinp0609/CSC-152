import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSwitcherExample {

    private static JFrame frame; // Frame for the application
    private static JPanel currentPanel; // Reference to the current panel

    public static void main(String[] args) {
        // Frame creation
        frame = new JFrame("Panel Switcher Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Start with the first panel
        currentPanel = createPanel1();
        frame.add(currentPanel);

        // Create buttons to switch panels
        JButton button1 = new JButton("Show Panel 1");
        JButton button2 = new JButton("Show Panel 2");
        JButton button3 = new JButton("Show Panel 3");

        // Add ActionListeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(createPanel1()); // Switch to Panel 1
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(createPanel2()); // Switch to Panel 2
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(createPanel3()); // Switch to Panel 3
            }
        });

        // Create a panel for buttons and add them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Add components to the frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    // Method to switch panels
    private static void switchPanel(JPanel newPanel) {
        // Remove the current panel and add the new one
        frame.remove(currentPanel);
        currentPanel = newPanel;
        frame.add(currentPanel);
        frame.revalidate(); // Refresh the frame
        frame.repaint(); // Repaint the frame
    }

    // Private static method for Panel 1
    private static JPanel createPanel1() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("This is Panel 1"));
        return panel;
    }

    // Private static method for Panel 2
    private static JPanel createPanel2() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("This is Panel 2"));
        return panel;
    }

    // Private static method for Panel 3
    private static JPanel createPanel3() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("This is Panel 3"));
        return panel;
    }
}
