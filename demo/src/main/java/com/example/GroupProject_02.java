package com.example;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GroupProject_02 {
    private JFrame frame;
    private JButton createFileButton;
    private JButton openFileButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GroupProject_02().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame("NFL Team");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        createFileButton = new JButton("Create New File");
        openFileButton = new JButton("Open Existing File");

        createFileButton.addActionListener(e -> createNewFile());
        openFileButton.addActionListener(e -> openExistingFile());

        JPanel panel = new JPanel();
        panel.add(createFileButton);
        panel.add(openFileButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void createNewFile() {
        String fileName = JOptionPane.showInputDialog("Enter new file name (without extension):");
        if (fileName != null && !fileName.trim().isEmpty()) {
            try {
                File file = new File(fileName + ".csv");
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(frame, "File created: " + file.getName());
                } else {
                    JOptionPane.showMessageDialog(frame, "File already exists.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error creating file.");
            }
        }
    }

    private void openExistingFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV & Excel Files", "csv", "xlsx"));
        int returnValue = fileChooser.showOpenDialog(frame);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.getName().endsWith(".csv")) {
                openCSVFile(selectedFile);
            } else if (selectedFile.getName().endsWith(".xlsx")) {
                openExcelFile(selectedFile);
            }
        }
    }

    private void openCSVFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error opening CSV file.");
        }
    }

    private void openExcelFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error opening Excel file.");
        }
    }
}
