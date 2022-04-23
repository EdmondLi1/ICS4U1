import java.util.ArrayList;

/**
 * Manages a course with students (type Student). Students are stored in an ArrayList, and can be edited, added,
 * removed, and printed. Each student has assignments which can be edited, added, removed and printed. Supports printing assignment
 * averages, student averages, and class average. Students are referenced by their name or student number.
 */
public class Course {

    private String courseName;
    private String courseCode;
    private ArrayList<Student> students;

    /**
     * Constructor that initalizes the course name, course code, and student list.
     * @param courseName course name
     * @param courseCode course code
     */
    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        students = new ArrayList<>();
    }

    /**
     * Gets the course name.
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the course code.
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Gets the number of students.
     * @return size of student list 
     */
    public int numberOfStudents() {
        return students.size();
    }

    /**
     * Gets the Student from the course list given student name or student number. 
     * @param nameOrNum String that is either the name or student number
     * @return the Student or null if not in the list
     */
    public Student getStudent(String nameOrNum) {
        for (Student s : students) {
            if (s.getName().equals(nameOrNum) || s.getStudentNumber().equals(nameOrNum)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Adds a student to the list.
     * @param s a Student instance
     */
    public void addStudent(Student s) {
        students.add(s);
    }

    /**
     * Edits the name and student of an existing student
     * @param nameOrNum String that is either the name or student number
     * @param name new name of student
     * @param studentNumber new student number
     */
    public void editStudentInfo(String nameOrNum, String name, String studentNumber) {
        Student s = getStudent(nameOrNum);

        if (s != null) {
            s.setName(name);
            s.setStudentNumber(studentNumber);
        }
        else {
            System.out.println("No Student " + nameOrNum + " Exists.");
        }
    }

    /**
     * Removes the first occurrence of a student in the list, if they exist.
     * @param nameOrNum Student instance to remove
     */
    public void removeStudent(String nameOrNum) {
        Student s = getStudent(nameOrNum);

        if (s != null) {
            students.remove(s);
            System.out.println("Student " + s.getName() + " successfully removed from the course.");
        }
        else {
            System.out.println("No Student " + nameOrNum + " Exists.");
        }
    }


    /**
     * Adds a mark for a Student in the course. Prints an error message if student not found.
     * @param nameOrNum String that is either a name or student number
     * @param mark mark being added
     */
    public void addMark(String nameOrNum, int mark) {
        Student s = getStudent(nameOrNum);

        if (s != null) {
            s.addMark(mark);
        }
        else {
            System.out.println("No Student " + nameOrNum + " Exists.");
        }
    }

    /**
     * Edits a mark for the student in the course, given the mark and assignment number to change.
     * @param nameOrNum String that is either a student name or student number
     * @param assignmentNumber the assignment to change
     * @param mark updated mark
     */
    public void editMark(String nameOrNum, int assignmentNumber, int mark) {
        Student s = getStudent(nameOrNum);

        if (s != null) {
            s.editMark(assignmentNumber, mark);
            // maybe success message.
        }
        else {
            System.out.println("No Student " + nameOrNum + " Exists.");
        }
    }

     /**
     * Calculate the number of assignments in the course.
     * @return the number of assignments
     */
    public int numberOfAssignments() {
        int number = 0;
        for (Student s : students) {
            if (number < s.numberOfAssignments()) {
                number = s.numberOfAssignments();
            }
        }
        return number;
    }

    /**
     * Adds a new assignment, initializing all marks to -1; no marks.
     */
    public void addAssignment() {
        for (int i = 0; i < numberOfStudents(); i++) {
            students.get(i).addMark(-1);
        }
    }

    /**
     * Edits an assignment mark, given the particular student, assignment number, and updated mark.
     * Prints and error message if student not found.
     * @param nameOrNum String that is either student name or student number
     * @param assignmentNumber particular assignment to change
     * @param mark updated mark
     */
    public void editAssignment(String nameOrNum, int assignmentNumber, int mark) {
        Student s = getStudent(nameOrNum);

        if (s != null) {
            editMark(nameOrNum, assignmentNumber, mark);
        }
        else {
            System.out.println("No Student " + nameOrNum + " Exists.");
        }
    }

    /**
     * Edits all marks for a particular assignment. Only accepts the same number of 
     * marks in order to be edited.
     * @param assignmentNumber particular assignment to change
     * @param marks a list of marks to update
     */
    public void editAssignmentMarks(int assignmentNumber, int[] marks) {
        if (marks.length == numberOfStudents()) {
            for (int i = 0; i < marks.length; i++) {
                students.get(i).editMark(assignmentNumber, marks[i]);
            }
        }
        else {
            System.out.println("Incorrect number of marks, try again.");
        }
    }

    /**
     * Removes a particular assignment from the course, given the assignment number.
     * @param assignmentNumber particular assignment to be deleted
     */
    public void removeAssignment(int assignmentNumber) {
        for (Student s: students) {
            s.removeMark(assignmentNumber);
        }
    }

    /**
     * Print the course average (to one decimal place) by computing the average of the student's averages. 
     * Ignore students wth no marks when computing the average.
     */
    public void printCourseAvg() {
        double courseAvg = 0;
        int totalMark = 0, totalStd = 0;

        for (Student s: students) {

            // dont include students with no marks
            if (s.calcAvg() != -1){
                totalMark += s.calcAvg();
                totalStd++;
            }
        }
        courseAvg = (double) totalMark/ totalStd;
        System.out.printf("Course average: %.1f%%%n", courseAvg);
    }

    /**
     * Computes the average for a particular assignment, given the assignment number. 
     * Returns -1, if there no marks in the assigment.
     * @param assignmentNumber the assignment to calculate the average
     * @return the average for the assignment, or -1 if no marks present
     */
    public double calcAssignmentAvg(int assignmentNumber) {
        int totalSum = 0, count = 0;
        double assignmentAvg = 0;

        for (Student s: students) {

            // ignore no marks when calculating average
            if (s.getMark(assignmentNumber) != -1) {
                totalSum += s.getMark(assignmentNumber);
                count++;
            }
        }

        // if all marks are no marks; display no average.
        if (count == 0) {
           assignmentAvg = -1;
        }
        else {
            assignmentAvg = (double) totalSum / count ;
        }
        return assignmentAvg;
    }

    /**
     * Prints all assignment averages in the course, formatted nicely to one decimal place.
     */
    public void printAllAssignmentAvg() {
        double assignmentAvg; 

        for (int assignNo = 0; assignNo < numberOfAssignments(); assignNo++) {
            assignmentAvg = calcAssignmentAvg(assignNo);

            // if there is no mark, print no average
            if (assignmentAvg == -1) {
                System.out.printf("Assignment: %d, No average%n", assignNo);
            }
            else {
                System.out.printf("Assignment: %d, average: %.1f%%%n", assignNo, assignmentAvg);
            }
        }
    }

    /**
     * Prints the averages of the students enrolled in the course, formatted nicely to one decimal place.
     */
    public void printStudentAvgs() {
        double average;

        for (Student s : students) {
            average = s.calcAvg();

            // if there is no mark, print no average
            if (average == -1) {
                System.out.printf("Student: %-15s No Average%n", s.getName());
            }
            else {
                System.out.printf("Student: %-15s Average: %.1f%n", s.getName(), average);
            }
        }
    }

    /**
     * Prints a list of all the marks for a particular assignment with the students name who are enrolled in the course.
     * @param assignmentNumber specific assignment's marks to print
     */
    public void printAssignmentMarks(int assignmentNumber) {
        for (Student s: students) {
            System.out.printf("Student: %-15s Assignment mark: %d%n", s.getName(), s.getMark(assignmentNumber));
        }
    }

    /**
     * Adjust the student's mark so that all students will have the same number of assignments.
     * Assigns empty marks for students with not enough assignments.
     */
    public void fixMarks() {
        // if the length of the students marks isn't the max one, set others to -1
        for (Student s: students) {
            int currentAssignments = s.numberOfAssignments();

            if (currentAssignments < numberOfAssignments()) {
                for (int i = 0; i < (numberOfAssignments() - currentAssignments); i++) {
                    s.addMark(-1);
                }
            }
        }
    }

    /**
     * Alternate representation of the Course object. Formatted and spaced nicely and includes the
     * Student's name, number, and marks.
     */
    public void printInfo() {
        System.out.println("\nCourse: " + courseName + "\t\t Course Code: " + courseCode);
        System.out.println("Students\t\tStudent Number\t\tAssignment Marks");

        for (Student s: students) {
            System.out.printf("%-23s %-15s \t", s.getName(), s.getStudentNumber());
            for (int i = 0; i < s.numberOfAssignments(); i++) {
                System.out.print(s.getMark(i) + " \t");
            }
            System.out.println();
        }
    }

    /**
     * String representation of the Course object.
     * @return the course details, formatted nicely.
     */
    @Override
    public String toString() {
        return  "\nCourse: " + courseName +
                "\n Course Code: " + courseCode +
                "\n Students: " + students.toString();
    }
}
