package payroll;

public class FullTimeEmployee extends Employee {
    private static final double YEARLY_SICK_DAYS = 20.0;
    private static final int MONTHS = 12;
    private double yearlySalary;
    private double sickDaysLeft;

    /**
     * Constructor which instantiates a Full-Time employee object with the given parameters.
     *
     * @param employeeNumber the employee's number
     * @param lastName employee's last name
     * @param firstName employee's first name
     * @param jobTitle employee's job position
     * @param yearlySalary employee's yearly salary
     * @param sickDaysLeft employee's sick days remaining
     */
    public FullTimeEmployee(String employeeNumber, String lastName, String firstName,
                            String jobTitle, double yearlySalary, double sickDaysLeft) {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    /**
     * Returns the employee's yearly salary.
     * @return employee's yearly salary
     */
    public double getYearlySalary() {
        return yearlySalary;
    }


    /**
     * Returns the monthly pay for the employee.
     * @return employee's monthly pay
     */
    public double pay() {
        return yearlySalary / MONTHS;
    }

    /**
     * Uses the number of sick days given.
     * @param amount the number of sick days to use
     */
    public void useSickDay(double amount) {
        sickDaysLeft -= amount;
    }

    /**
     * Returns the number of sick days remaining for the employee.
     * @return number of sick days remaining
     */
    public double getSickDays() {
        return sickDaysLeft;
    }

    /**
     * Resets the number of sick to the allotted amount, 20.
     */
    public void resetSickDays() {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    /**
     * Prints the full-time employee's pay stub with the employee's information,
     * yearly salary, monthly pay, and sick days left.
     */
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(this);
        System.out.printf("Yearly Salary: $%.2f%n", yearlySalary);
        System.out.printf("Current Month pay: $%.2f%n", pay());
        System.out.printf("Sick days left: %.1f%n", sickDaysLeft);
        System.out.println("----------------------------------------\n");
    }

    /**
     * Returns the string representation of the full-time employee object.
     * @return the full-time employee's details
     */
    @Override
    public String toString() {
        return super.toString() + ", full-time";
    }
}
