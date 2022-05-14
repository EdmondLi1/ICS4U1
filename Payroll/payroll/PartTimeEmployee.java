package payroll;

public class PartTimeEmployee extends Employee {
    private static final double HOURS_PER_DAY = 7.0;
    private double numHoursAssigned;
    private double hourlyWages;
    private double sickDaysTaken;

    /**
     * Constructor that instantiates a Part-Time Employee object with the given parameters.
     *
     * @param employeeNumber the employee's number
     * @param lastName employee's last name
     * @param firstName employee's first name
     * @param jobTitle employee's job position
     * @param numHoursAssigned hours assigned to work
     * @param hourlyWages hourly wages of employee
     * @param sickDaysTaken sicks days employee has taken
     */
    public PartTimeEmployee(String employeeNumber, String lastName, String firstName,
                            String jobTitle, double numHoursAssigned, double hourlyWages, double sickDaysTaken) {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWages = hourlyWages;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * Returns the number of hours assigned for the employee.
     * @return the number of hours the employee's assigned
     */
    public double getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * Returns employee's hourly wage.
     * @return employee's hourly wage
     */
    public double getHourlyWages() {
        return hourlyWages;
    }

    /**
     * Returns the monthly pay of the part-time employee
     * based on hours worked and their hourly wage.
     *
     * Pay is reduced based on the number of hours missed.
     * @return employee's monthly pay
     */
    public double pay() {
        // pay = regular - hours missed
        return hourlyWages * (numHoursAssigned - sickDaysTaken * HOURS_PER_DAY);
    }

    /**
     * Uses the allocated amount of sick days for the employee.
     * @param amount sick days used by employee
     */
    public void useSickDay(double amount) {
        sickDaysTaken += amount;
    }

    /**
     * Returns the number of sicks days taken by the part-time employee.
     * @return sick days taken
     */
    public double getSickDays() {
        return sickDaysTaken;
    }

    /**
     * Resets the number of sick days of the employee to 0.
     */
    public void resetSickDays() {
        sickDaysTaken = 0;
    }

    /**
     * Prints the part-time employee's pay stub with the employee's information,
     * hourly wage, hours assigned, sick days taken, and current month pay.
     */
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(this);
        System.out.printf("Hourly Wage: $%.2f%n", hourlyWages);
        System.out.printf("Number of hours assigned: %.1f%n", numHoursAssigned);
        System.out.printf("Sick days taken: %.1f%n", sickDaysTaken);
        System.out.printf("Current Month pay: $%.2f%n", pay());
        System.out.println("----------------------------------------\n");
    }

    /**
     * Returns the string representation of the part-time employee object
     * @return part-time employee's details
     */
    @Override
    public String toString() {
        return super.toString() + ", part-time";
    }
}
