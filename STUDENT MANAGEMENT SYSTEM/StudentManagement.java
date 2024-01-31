import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    // Method to add a student to the 
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student from the 
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Method to search for a student by roll number in the 
    public Student searchStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to display all students in the 
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Student management system is empty.");
        } else {
            System.out.println("All Students in the System:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        StudentManagement studentManagementSystem = new StudentManagement();

        // Adding students
        studentManagementSystem.addStudent(new Student("Alice", 101, 'A'));
        studentManagementSystem.addStudent(new Student("Bob", 102, 'B'));

        // Displaying all students
        studentManagementSystem.displayAllStudents();

        // Searching for a student by roll number
        int searchRollNumber = 101;
        Student foundStudent = studentManagementSystem.searchStudentByRollNumber(searchRollNumber);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found for roll number: " + searchRollNumber);
        }

        // Removing a student
        studentManagementSystem.removeStudent(foundStudent);

        // Displaying all students after removal
        studentManagementSystem.displayAllStudents();
    }
}
