// import java.util.Scanner;

// public class StudentManagementSystemUI {
//     private static StudentManagementSystemUI studentManagementSystem = new StudentManagementSystemUI();
//     private static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         while (true) {
//             displayMenu();
//             int choice = getUserChoice();

//             switch (choice) {
//                 case 1:
//                     addStudent();
//                     break;
//                 case 2:
//                     removeStudent();
//                     break;
//                 case 3:
//                     searchStudent();
//                     break;
//                 case 4:
//                     displayAllStudents();
//                     break;
//                 case 5:
//                     System.out.println("Exiting Student Management System. Goodbye!");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }

//     private static void displayMenu() {
//         System.out.println("\nStudent Management System Menu:");
//         System.out.println("1. Add a student");
//         System.out.println("2. Remove a student");
//         System.out.println("3. Search for a student");
//         System.out.println("4. Display all students");
//         System.out.println("5. Exit");
//     }

//     private static int getUserChoice() {
//         System.out.print("Enter your choice (1-5): ");
//         while (!scanner.hasNextInt()) {
//             System.out.print("Invalid input. Enter a number (1-5): ");
//             scanner.next(); // consume invalid input
//         }
//         return scanner.nextInt();
//     }

//     private static void addStudent() {
//         System.out.print("Enter student name: ");
//         String name = scanner.next();
//         System.out.print("Enter student roll number: ");
//         int rollNumber = getPositiveIntegerInput();
//         System.out.print("Enter student grade: ");
//         char grade = getGradeInput();

//         Student newStudent = new Student(name, rollNumber, grade);
//         studentManagementSystem.addStudent(newStudent);
//         System.out.println("Student added successfully!");
//     }

//     private static void removeStudent() {
//         System.out.print("Enter the roll number of the student to remove: ");
//         int rollNumberToRemove = getPositiveIntegerInput();
//         Student studentToRemove = studentManagementSystem.searchStudentByRollNumber(rollNumberToRemove);

//         if (studentToRemove != null) {
//             studentManagementSystem.removeStudent(studentToRemove);
//             System.out.println("Student removed successfully!");
//         } else {
//             System.out.println("Student not found.");
//         }
//     }

//     private static void searchStudent() {
//         System.out.print("Enter the roll number of the student to search: ");
//         int rollNumberToSearch = getPositiveIntegerInput();
//         Student foundStudent = studentManagementSystem.searchStudentByRollNumber(rollNumberToSearch);

//         if (foundStudent != null) {
//             System.out.println("Student found: " + foundStudent);
//         } else {
//             System.out.println("Student not found.");
//         }
//     }

//     private static void displayAllStudents() {
//         studentManagementSystem.displayAllStudents();
//     }

//     // Helper method to ensure positive integer input
//     private static int getPositiveIntegerInput() {
//         int input = -1;
//         while (input < 0) {
//             while (!scanner.hasNextInt()) {
//                 System.out.print("Invalid input. Enter a positive integer: ");
//                 scanner.next(); // consume invalid input
//             }
//             input = scanner.nextInt();
//             if (input < 0) {
//                 System.out.print("Invalid input. Enter a positive integer: ");
//             }
//         }
//         return input;
//     }

//     // Helper method to ensure valid grade input
//     private static char getGradeInput() {
//         char grade = '\0';
//         while (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'F') {
//             System.out.print("Enter a valid grade (A, B, C, D, F): ");
//             grade = scanner.next().toUpperCase().charAt(0);
//         }
//         return grade;
//     }
// }
