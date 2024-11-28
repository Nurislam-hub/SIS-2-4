import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String inputFile = "src/main/resources/students.xlsx";
        String outputFile = "src/main/resources/updated_students.xlsx";

        try {
            List<Student> students = ScholarshipProcessor.readExcelFile(inputFile);

            ScholarshipProcessor.calculateScholarships(students);

            ScholarshipProcessor.writeExcelFile(students, outputFile);

            System.out.println("Обработанные данные успешно записаны в файл: " + outputFile);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

