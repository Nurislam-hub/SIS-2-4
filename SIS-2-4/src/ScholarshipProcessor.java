import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class ScholarshipProcessor {

    public static List<Student> readExcelFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Student student = new Student();

                student.setId((int) row.getCell(0).getNumericCellValue());
                student.setName(row.getCell(1).getStringCellValue());
                student.setGroup(row.getCell(2).getStringCellValue());
                student.setScholarship(row.getCell(3).getNumericCellValue());
                student.setGpa(row.getCell(4).getNumericCellValue());
                student.setFaculty(row.getCell(5).getStringCellValue());

                students.add(student);
            }
        }

        return students;
    }
}