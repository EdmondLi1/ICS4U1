import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeBook {

    public static final Scanner READER = new Scanner(System.in);
    public static Course course = new Course("Introduction to Computer Science", "CSC100");

    public static void main(String[] args) {

        // Instantiate preexisting student data and add to the course
        Student a = new Student("Alan T",   "110101011", new ArrayList<>(Arrays.asList(83, 71, 76, 91, 85)));
        Student b = new Student("Donald K", "314159265", new ArrayList<>(Arrays.asList(84, 90, 88, 99, 80)));
        Student c = new Student("Albert E", "299792458", new ArrayList<>(Arrays.asList(93, 65, 95, 40, 19)));
        Student d = new Student("Marie C",  "002661600", new ArrayList<>(Arrays.asList(76, 52, 96, 92, 66)));
        Student e = new Student("Ada L",    "018151210", new ArrayList<>(Arrays.asList(91, 98, 89, 99, 99)));

        course.addStudent(a);
        course.addStudent(b);
        course.addStudent(c);
        course.addStudent(d);
        course.addStudent(e);

        boolean finished = false;
        int choice = -1;

        // main loop helper variables
        Student s;
        int mark;
        int marks[];
        int assignmentNumber;
        int numberOfAssignments;

        System.out.println("Opening Gradebook Application...");

        // main gradebook loop
        while (!finished) {

            System.out.println("\n\n-GRADEBOOK-");
            course.printInfo();
            printOptions();

            choice = getChoice();

            System.out.println();

            // valiadate each one!
            switch (choice) {
                case 0:     // Exit the program
                    finished = true;
                    System.out.println("Closing Gradebook Application...");
                    break;

                case 1:     // Add a student
                    addStudent();
                    course.fixMarks();
                    break;

                case 2:     // Edit an existing student's infomation (name / student number)
                    editStudent();
                    break;

                case 3:     // Remove a student
                    s = getStudent("Please enter a student to delete: ");
                    course.removeStudent(s.getName());
                    break;

                case 4:     // add a mark to a student
                    s = getStudent("Enter a student to add a mark: ");
                    mark = getMark();

                    s.addMark(mark);
                    course.fixMarks();
                    break;

                case 5:     // Edits a student's mark
                    s = getStudent("Enter a student to edit their mark: ");
                    assignmentNumber = getAssignmentNumber();

                    mark = getMark();
                    s.editMark(assignmentNumber, mark);
                    break;

                case 6:     // Edit all of a student's marks
                    s = getStudent("Enter a student to edit all their marks: ");
                    numberOfAssignments = s.numberOfAssignments();

                    for (int assignNum = 0; assignNum < numberOfAssignments; assignNum++) {
                        mark = getMark();
                        s.editMark(assignNum, mark);
                    }
                    break;

                case 7:     // Adds a new assignment to all students
                    System.out.println("Adding new assignment to each student, initializing with a no mark (-1)");
                    course.addAssignment();
                    break;

                case 8:     // Edit a mark for a particular assignment
                    System.out.print("Enter the assignment number: ");
                    assignmentNumber = getAssignmentNumber(); 

                    s = getStudent("Enter the student to change that corresponding assignment: ");
                    mark = getMark();

                    s.editMark(assignmentNumber, mark);
                    break;

                case 9:     // Edits all marks for an assignment
                    assignmentNumber = getAssignmentNumber();
                    marks = new int[course.numberOfStudents()];

                    for (int i = 0; i < course.numberOfStudents(); i++) {
                        marks[i] = getMark();
                    }
                    course.editAssignmentMarks(assignmentNumber, marks);
                    break;

                case 10:    // Delete an assignment
                    assignmentNumber = getAssignmentNumber();
                    course.removeAssignment(assignmentNumber);
                    break;

                case 11:    // print the course averge
                    course.printCourseAvg();
                    break;

                case 12:    // Prints an assingment marks
                    assignmentNumber = getAssignmentNumber();
                    course.printAssignmentMarks(assignmentNumber);
                    break;

                case 13:    // prints a student's marks, with assignment number
                    s = getStudent("Enter a student to see their marks: ");
                    s.printMarks();
                    break;

                case 14:    // prints an assignment average
                    assignmentNumber = getAssignmentNumber();
                    if (course.calcAssignmentAvg(assignmentNumber) != -1) {
                        System.out.printf("Assignment %d, Average: %.1f%%%n", assignmentNumber, course.calcAssignmentAvg(assignmentNumber));
                    }
                    else {
                        System.out.printf("Assignment %d, No Average%n", assignmentNumber, course.calcAssignmentAvg(assignmentNumber));
                    }
                    break;

                case 15:    // prints all the assignment averages
                    course.printAllAssignmentAvg();
                    break;


                case 16:    // Print a student's average
                    s = getStudent("Enter a student to check their average: ");
                    if (s.calcAvg() != -1) {
                        System.out.printf("Student: %-15s Average: %.1f%%%n", s.getName(), s.calcAvg());
                    }
                    else {
                        System.out.printf("Student: %-15s No Average%n", s.getName(), s.calcAvg());
                    }
                    break;

                case 17:    // prints all the student's average in the course
                    course.printStudentAvgs();
                    break;

                default:    // If no cases, means the choice was invalid
                    System.out.println("Please enter a valid choice.");
            }
        }
    }

    public static void printOptions() {
        // Helper method used to print the menu of the Gradebook application

        System.out.println("\nGradebook Application Menu");
        System.out.println("------------------------------------------");
        System.out.println("0.  Quit");
        System.out.println("1.  Add student");
        System.out.println("2.  Edit student info");
        System.out.println("3.  Remove a student");
        System.out.println("4.  Add a mark for an existing student");
        System.out.println("5.  Edit a mark for an existing student");
        System.out.println("6.  Edit all marks for an existing student");
        System.out.println("7.  Add a new assignment");
        System.out.println("8.  Edit a mark for an assignment");
        System.out.println("9.  Edit all marks for an assignment");
        System.out.println("10. Delete a particular assignment");
        System.out.println("11. Print the course average");
        System.out.println("12. Print an assignment's marks");
        System.out.println("13. Print a student's marks");
        System.out.println("14. Print an assignment average");
        System.out.println("15. Print all assignment averages");
        System.out.println("16. Print a student's average");
        System.out.println("17. Print all student averages in a course\n");
    }

    public static int getChoice() {
        // Helper method used to get a VALIDchoice from the user
        int choice;

        while (true) {
            System.out.println("Please enter a choice: ");
            System.out.print(">> ");
            try {
                choice = Integer.parseInt(READER.nextLine());
                // if choice within range, return that (validated)
                if (choice >= 0 && choice <= 17) {
                    return choice;
                }
                System.out.println("Please enter a choice within the range provided.\n");

                // if user enters string/float, give error message
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid choice, please enter an integer within the list.\n");
            }
        }
    }


    public static int getMark() {
        // Helper method used to get a valid mark (0 - 100)
        int mark;

        while (true) {
            System.out.print("Enter a mark, -1 for no mark: ");
            try {
                mark = Integer.parseInt(READER.nextLine());

                // No mark is included and represented as -1.
                if (mark >= -1 && mark <= 100) {
                    return mark;
                }
                System.out.println("Enter a mark within the range.\n");

                // if user enters string/float, give error message
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input, please enter an integer.\n");
            }
        }
    }


    public static int getAssignmentNumber() {
        // Helper method used to get a valid assignment (0 - maxAssignment).
        int assignmentNumber;

        while (true) {
            System.out.print("Please enter an assignment number: ");
            try {
                assignmentNumber = Integer.parseInt(READER.nextLine());
                if (assignmentNumber >= 0 && assignmentNumber < course.numberOfAssignments()) {
                    return assignmentNumber;
                }
                System.out.println("Number not within the range of the assignments.\n");

            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input, please enter an integer.\n");
            }
        }
    }


    public static Student getStudent(String prompt) {
        // Helper method which takes a prompt, and returns the student when given
        // the name or student number of the student
        String nameOrNum;

        while (true) {
            System.out.print(prompt);

            nameOrNum = READER.nextLine();
            Student s = course.getStudent(nameOrNum);

            if (s != null) {
                return s;
            } else {
                System.out.println("The student's name or number is not listed in this class, please try again!\n");
            }
        }
    }


    public static void addStudent() {
        // Helper method used to add a student to the course

        boolean finished = false;
        ArrayList<Integer> stdMarks = new ArrayList<>();
        int mark;
        String input;

        System.out.println("Please enter the new student's name: ");
        String name = READER.nextLine();

        System.out.println("Please enter their student number: ");
        String studentNumber = READER.nextLine();

        System.out.println("Enter mark(s) for the student (0 - 100, -1 for no mark).");
        System.out.println("Enter nothing if you wish to terminate:");

        // Continue until user is finished
        while (!finished) {

            input = READER.nextLine();

            // if user enters nothing, finish entering marks
            if (input.isBlank()) {
                finished = true;
            }
            else {
                try {
                    mark = Integer.parseInt(input);

                    // add mark if in valid range
                    if (mark >= -1 && mark <= 100) {
                        stdMarks.add(mark);
                    }
                    else {
                        System.out.println("Please enter a valid mark (0 to 100); -1 for no mark.");
                    }
                }
                // if user enters a string/float, give error message
                catch (NumberFormatException nfe) {
                    System.out.println("Invalid input, please enter an integer.");
                }
            }
        }
        // add the student to the course
        course.addStudent(new Student(name, studentNumber, stdMarks));
    }

    public static void editStudent() {
        // Helper method used to edit a current student in the class

        Student s = getStudent("Please enter a student to edit: ");

        System.out.print("Enter a new name, Enter empty to not change: ");
        String name = READER.nextLine();

        System.out.print("Enter a new student number, Enter empty to not change: ");
        String studentNumber = READER.nextLine();

        // If user enters whitespace or empty string, set to the same name / username
        if (name.isBlank()) {
            name = s.getName();
        }
        if (studentNumber.isBlank()) {
            studentNumber = s.getStudentNumber();
        }

        // edit the student with new name / student name if provided
        course.editStudentInfo(s.getName(), name, studentNumber);
    }
}
