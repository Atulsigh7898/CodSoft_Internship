// ... (other methods)

private static void addStudent() {
    System.out.print("Enter student name: ");
    String name = getNonEmptyInput();
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
        String newName = getNonEmptyInput();
        if (!newName.isEmpty()) {
            studentToEdit.setName(newName);
        }

        System.out.print("Enter new student grade (press Enter to keep current): ");
        char newGrade = getGradeInput();
        studentToEdit.setGrade(newGrade);

        System.out.println("Student information edited successfully!");
    } else {
        System.out.println("Student not found.");
    }
}

// Helper method to ensure non-empty input
private static String getNonEmptyInput() {
    String input = scanner.nextLine().trim();
    while (input.isEmpty()) {
        System.out.print("Field cannot be empty. Please enter again: ");
        input = scanner.nextLine().trim();
    }
    return input;
}

// Helper method to ensure valid grade input
private static char getGradeInput() {
    char grade = '\0';
    while (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'F') {
        System.out.print("Enter a valid grade (A, B, C, D, F): ");
        String input = scanner.next().toUpperCase();
        if (!input.isEmpty() && input.length() == 1 && Character.isLetter(input.charAt(0))) {
            grade = input.charAt(0);
        }
    }
    return grade;
}

// ... (other methods)
