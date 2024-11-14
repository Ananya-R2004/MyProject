import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelExample {
    public static void main(String[] args) {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();
        
        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee Performance");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Employee ID");
        headerRow.createCell(1).setCellValue("Employee Name");
        headerRow.createCell(2).setCellValue("Attendance");
        headerRow.createCell(3).setCellValue("Productivity Score");
        headerRow.createCell(4).setCellValue("Performance Rating");

        // Create data rows
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(101);
        row1.createCell(1).setCellValue("John Doe");
        row1.createCell(2).setCellValue(90);
        row1.createCell(3).setCellValue(85.5);
        row1.createCell(4).setCellValue(4);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue(102);
        row2.createCell(1).setCellValue("Jane Smith");
        row2.createCell(2).setCellValue(95);
        row2.createCell(3).setCellValue(88.5);
        row2.createCell(4).setCellValue(5);

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("employee_performance.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel file created successfully!");
    }
}
