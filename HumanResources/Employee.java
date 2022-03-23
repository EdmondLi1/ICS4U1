/**
 * Manages an employee's information, such as name, ID, yearly salary, and
 * number of sick days.
 *
 * @author Edmond Li
 */
public class Employee {
    private String name;
    private String id;
    private int salary;
    private int sickDays;

    /**
     * Constructor with name only. Do not assign other fields.
     * @param name Name of employee
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * Constructor with name and employee ID only. Do not assign other fields.
     * @param name Name of employee
     * @param id ID of employee
     */
    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Constructor with name, employee ID, salary, and sick days.
     * @param name Name of employee
     * @param id ID of employee
     * @param salary Salary of employee
     * @param sickDays Number of sick days allocated
     */
    public Employee(String name, String id, int salary, int sickDays) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.sickDays = sickDays;
    }

    /**
     * Gets the name of the employee
     * @return Employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee
     * @param name Name of employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the ID of the employee
     * @return Employee ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID code of the employee.
     * @param id Employee ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets salary of employee
     * @return Employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets employee's salary (yearly)
     * @param salary Salary of employee
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the number of sick days
     * @return number of sick days remaining
     */
    public int getSickDays() {
        return sickDays; 
    }

    /**
     * Sets the number of sick days.
     * @param sickDays number of sick days allocated
     */
    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }

    /**
     * Override for toString method.
     * @return String of the employee's information formatted nicely
     */
    @Override
    public String toString() {
        return  "\nEmployee Information:" +
                "\n Name: " + name +
                "\n ID: " + id  +
                "\n Salary: $" + salary +
                "\n Sick Days: " + sickDays;
    }
}