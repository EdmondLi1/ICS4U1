package payroll;

public abstract class Employee {
    protected String employeeNumber;
    protected String lastName;
    protected String firstName;
    protected String jobTitle;

    /**
     * Constructor which initializes the given parameters for its subclasses.
     *
     * @param employeeNumber the employee's number
     * @param lastName last name of employee
     * @param firstName first name of employee
     * @param jobTitle the job position of the employee
     */
    public Employee(String employeeNumber, String lastName, String firstName, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
    }

    /**
     * Returns the employee's number.
     *
     * @return the employee number
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Returns the last name of the employee.
     *
     * @return the employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the first name of the employee.
     *
     * @return the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the employee's job position.
     *
     * @return the employee's job
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Returns the string representation of the employee object.
     *
     * @return the employee's details
     */
    @Override
    public String toString() {
        return "Employee: " + employeeNumber + ", " + firstName + " " + lastName + ", " + jobTitle;
    }

    /**
     * Returns an employee's pay.
     * @return the employee's pay
     */
    abstract double pay();

    /**
     * Returns the number of sick days taken or left for an employee.
     * @return number of sick days taken or left
     */
    abstract double getSickDays();

    /**
     * Updates the sick days information for an employee.
     * @param amount number fo days to use
     */
    abstract void useSickDay(double amount);


    /**
     * Resets the sick day information for an employee.
     */
    abstract void resetSickDays();

    /**
     * Prints the monthly pay stub for an employee.
     */
    abstract void printPayStub();
}
