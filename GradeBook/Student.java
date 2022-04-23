import java.util.ArrayList;

/**
 * A class that represents a student and has attributes name, student number, and a list of marks. Each student can
 * change their name, student number, and marks. Moreover, you can add, edit, remove a student's marks and calculate
 * their overall average.
 */
public class Student {

    private String name;
    private String studentNumber;
    private ArrayList<Integer> marks;

    /**
     * Constructor that intializes the name, student number, and marks for the object.
     * @param name name of the student
     * @param studentNumber the student's number
     * @param marks a list of marks of the student
     */
    public Student(String name, String studentNumber, ArrayList<Integer> marks) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.marks = marks;
    }

    /**
     * Gets the name of the student.
     * @return name of student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the student, given a new name.
     * @param name new name for student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student number of the student.
     * @return student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Sets the student number for the student with the given student name.
     * @param studentNumber new student number
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

   /**
     * Gets the number of assignments (marks), the student currently has.
     * @return number of assignments
     */
    public int numberOfAssignments() {
        return marks.size();
    }

    /**
     * Gets the mark of the student, given the assignment number.
     * @param assignmentNumber the index of mark
     * @return the mark corresponding to that assignment number
     */
    public int getMark(int assignmentNumber) {
        return marks.get(assignmentNumber);
    }

    /**
     * Adds a mark for the student at the end of the list, given a mark.
     * @param mark the mark being added
     */
    public void addMark(int mark) {
        marks.add(mark);
    }

    /**
     * Edit a current mark, given the assignment number (index) and the new mark.
     * @param assignmentNumber the assignment to be edited
     * @param mark new mark to replace
     */
    public void editMark(int assignmentNumber, int mark) {
        marks.set(assignmentNumber, mark);
    }

    /**
     * Removes the assignment mark, given the assignment number.
     * @param assignmentNumber assignment to remove
     */
    public void removeMark(int assignmentNumber) {
        marks.remove(assignmentNumber);
    }

    /**
     * Prints a list of the student's marks with the assignment number above. No marks
     * are displayed as '-1'.
     */ 
    public void printMarks() {
        System.out.println("\nStudent: " + name + "\nStudent number: " + studentNumber);
        System.out.println("Marks:");

        for (int number = 0; number < numberOfAssignments(); number++) {
            System.out.print("\t" + number);
        }
        System.out.println();

        for (int number = 0; number < numberOfAssignments(); number++) {
            System.out.print("\t" + getMark(number));
        }
        System.out.println();
    }

    /**
     * Calculates the average of the student's marks. Ignores all empty marks (-1). Returns -1 if
     * the student has no average; all empty marks.
     * @return the average of student's marks
     */
    public double calcAvg() {
        int totalSum = 0, count = 0;
        double average;

        // iterate through the marks; ignore empty '-1' marks when calculating average.
        for (int mark: marks) {
            if (mark != -1) {
                totalSum += mark;
                count++;
            }
        }

        if (count == 0) {
            average = -1;
        }
        else {
            average = (double) totalSum / count;
        }
        return average;
    }

    /**
     * Returns the string representation of the object.
     * @return the student details formatted nicely
     */
    @Override
    public String toString() {
        return  "\nStudent: " + name +
                "\n Student Number: " + studentNumber +
                "\n Marks: " + marks.toString();
    }
}
