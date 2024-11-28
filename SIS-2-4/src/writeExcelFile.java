import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class writeExcelFile {
    public static void writeExcelFile(List<Student> students, String outputPath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Students");
            Row headerRow = sheet.createRow(0);


            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Group");
            headerRow.createCell(3).setCellValue("Scholarship");
            headerRow.createCell(4).setCellValue("GPA");
            headerRow.createCell(5).setCellValue("Faculty");
            headerRow.createCell(6).setCellValue("New Scholarship");

            int rowNum = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getName());
                row.createCell(2).setCellValue(student.getGroup());
                row.createCell(3).setCellValue(student.getScholarship());
                row.createCell(4).setCellValue(student.getGpa());
                row.createCell(5).setCellValue(student.getFaculty());
                row.createCell(6).setCellValue(student.getNewScholarship());
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
            }
        }
    }
}

