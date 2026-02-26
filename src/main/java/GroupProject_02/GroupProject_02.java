package src.main.java.GroupProject_02;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GroupProject_02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Open File Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new FlowLayout());

            JButton openButton = new JButton("Open CSV/Excel File");
            openButton.addActionListener(e -> openFile());

            frame.add(openButton);
            frame.setVisible(true);
        });
    }

    private static void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV and Excel Files", "csv", "xlsx", "xls");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            
            if (filePath.endsWith(".csv")) {
                readCsvFile(selectedFile);
            } else if (filePath.endsWith(".xls") || filePath.endsWith(".xlsx")) {
                readExcelFile(selectedFile);
            }
        }
    }

    private static void readCsvFile(File file) {
        try (FileReader fr = new FileReader(file)) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readExcelFile(File file) {
        try (Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            break;
                    }
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
