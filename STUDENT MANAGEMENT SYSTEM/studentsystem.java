import java.util.Scanner;

public class studentsystem {
    private static StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Loading students from a file on application start
        studentManagementSystem.loadFromFile("students_data.dat");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 8:
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System Menu:");
        System.out.println("1. Add a student");
        System.out.println("2. Edit student information");
        System.out.println("3. Remove a student");
        System.out.println("4. Search for a student");
        System.out.println("5. Display all students");
        System.out.println("6. Save students to file");
        System.out.println("7. Load students from file");
        System.out.println("8. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice (1-8): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number (1-8): ");
            scanner.next(); // consume invalid input
        }
        return scanner.nextInt();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student roll number: ");
        int rollNumber = getPositiveIntegerInput();
        System.out.print("Enter student grade: ");
        char grade = getGradeInput();

        Student newStudent = new Student(name, rollNumber, grade);
        studentManagementSystem.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void editStudent() {
        System.out.print("Enter the roll number of the student to edit: ");
        int rollNumberToEdit = getPositiveIntegerInput();
        Student studentToEdit = studentManagementSystem.searchStudentByRollNumber(rollNumberToEdit);

        if (studentToEdit != null) {
            System.out.println("Current student information: " + studentToEdit);
            System.out.print("Enter new student name (press Enter to keep current): ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                studentToEdit.setName(newName);
            }

            System.out.print("Enter new student grade (press Enter to keep current): ");
            String newGrade = scanner.nextLine().trim().toUpperCase();
            if (!newGrade.isEmpty() && newGrade.length() == 1 && Character.isLetter(newGrade.charAt(0))) {
                studentToEdit.setGrade(newGrade.charAt(0));
            }

            System.out.println("Student information edited successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumberToRemove = getPositiveIntegerInput();
        Student studentToRemove = studentManagementSystem.searchStudentByRollNumber(rollNumberToRemove);

        if (studentToRemove != null) {
            studentManagementSystem.removeStudent(studentToRemove);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumberToSearch = getPositiveIntegerInput();
        Student foundStudent = studentManagementSystem.searchStudentByRollNumber(rollNumberToSearch);

        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        studentManagementSystem.displayAllStudents();
    }

    private static void saveToFile() {
        studentManagementSystem.saveToFile("students_data.dat");
    }

    private static void loadFromFile() {
        studentManagementSystem.loadFromFile("students_data.dat");
    }

    private static void exitApplication() {
        // Saving students to a file before exiting
        saveToFile();
        System.out.println("Exiting Student Management System. Goodbye!");
        System.exit(0);
    }

    // Helper method to ensure positive integer input
    private static int getPositiveIntegerInput() {
        int input = -1;
        while (input < 0) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a positive integer: ");
                scanner.next(); // consume invalid input
            }
            input = scanner.nextInt();
            if (input < 0) {
                System.out.print("Invalid input. Enter a positive integer: ");
            }
        }
        return input;
    }

    // Helper method to
}