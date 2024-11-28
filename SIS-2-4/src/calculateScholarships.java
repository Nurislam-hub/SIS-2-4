import java.util.List;

public class calculateScholarships {
    public static void calculateScholarships(List<Student> students) {
        for (Student student : students) {
            double newScholarship = student.getScholarship();

            if (student.getFaculty().equalsIgnoreCase("Engineering") && student.getGpa() > 2.4) {
                newScholarship *= 1.10; // Увеличиваем на 10%
            } else if (student.getFaculty().equalsIgnoreCase("Economics") && student.getGpa() > 2.4) {
                newScholarship *= 1.15; // Увеличиваем на 15%
            } else if (student.getFaculty().equalsIgnoreCase("Philosophy") && student.getGpa() > 2.2) {
                newScholarship *= 1.05; // Увеличиваем на 5%
            } else if (student.getFaculty().equalsIgnoreCase("Marketing") && student.getGpa() > 2.5) {
                newScholarship *= 1.08; // Увеличиваем на 8%
            }

            student.setNewScholarship(newScholarship);
        }
    }

}
