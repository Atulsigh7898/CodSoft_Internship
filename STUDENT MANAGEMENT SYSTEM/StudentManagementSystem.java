import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // ... (other methods)

    // Method to save students to a file using serialization
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Students saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

    // Method to load students from a file using deserialization
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Students loaded from file: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
        }
    }

    // Example usage
    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        // Adding students
        studentManagementSystem.addStudent(new Student("Alice", 101, 'A'));
        studentManagementSystem.addStudent(new Student("Bob", 102, 'B'));

        // Saving students to a file with a different name
        studentManagementSystem.saveToFile("students_backup.dat");

        // Clearing students (simulating a new instance)
        studentManagementSystem = new StudentManagementSystem();

        // Loading students from a file with a different name
        studentManagementSystem.loadFromFile("students_backup.dat");

        // Displaying all students after loading
        studentManagementSystem.displayAllStudents();
    }
}
