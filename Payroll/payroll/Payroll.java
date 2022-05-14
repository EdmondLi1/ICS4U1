package payroll;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Payroll {
    private ArrayList<Employee> stafflist;

    /**
     * Constructor that initializes the staff list.
     */
    public Payroll() {
        stafflist = new ArrayList<>();
    }

    /**
     * Loads the staff list information from a given file.
     * @param filename name of file to load information from
     * @return Whether loading the data was a success
     */
    public boolean loadStaffList(String filename) {
        // local variables which are needed to initialize new employee
        Employee employee;
        String id, lastName, firstName, jobTitle, employeeType;
        double salary, sickDays, hoursAssigned, hourlyWage;

        boolean success = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String content = reader.readLine();
            while(content != null) {

                // For the each line, break it up by commas
                Scanner contentReader = new Scanner(content).useDelimiter(",");

                // common attribute all employees have
                id = contentReader.next();
                lastName = contentReader.next();
                firstName = contentReader.next();
                jobTitle = contentReader.next();

                employeeType = contentReader.next();

                // check employee type
                if (employeeType.equals("part-time")) {

                    // add the attributes specific to part-time employees
                    hoursAssigned = Double.parseDouble(contentReader.next());
                    hourlyWage = Double.parseDouble(contentReader.next());
                    sickDays = Double.parseDouble(contentReader.next());
                    employee = new PartTimeEmployee(id, lastName, firstName, jobTitle, hoursAssigned, hourlyWage, sickDays);
                }
                else {

                    // add the attributes specific to full-time employees
                    salary = Double.parseDouble(contentReader.next());
                    sickDays = Double.parseDouble(contentReader.next());
                    employee = new FullTimeEmployee(id, lastName, firstName, jobTitle, salary, sickDays);
                }
                stafflist.add(employee);
                content = reader.readLine();
            }
            success = true;

        } catch (IOException ioe) {
            System.out.println("Problem reading file.");
        }
        return success;
    }

    /**
     * Saves the current state of staff list into a file.
     *
     * @param filename the name of the file to save the data
     * @return whether saving into a file was a success
     */
    public boolean saveStaffList(String filename) {
        boolean success = false;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            for (Employee staff: stafflist) {
                // Information for all Employees
                writer.write(staff.getEmployeeNumber() + "," + staff.getLastName() + ","
                        + staff.getFirstName() + "," + staff.getJobTitle() + ",");

                // If full-time employee, print special attributes only to full-time employee
                if (staff instanceof FullTimeEmployee) {
                    writer.write("full-time," + ((FullTimeEmployee) staff).getYearlySalary() + ",");
                }

                // If part-time employee, print special attributes only to part-time employee
                else {
                    writer.write("part-time," + ((PartTimeEmployee) staff).getNumHoursAssigned() + ","
                            + ((PartTimeEmployee) staff).getHourlyWages() + ",");
                }
                writer.write(staff.getSickDays() + "\n");
            }
            success = true;
            writer.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return success;
    }

    /**
     * Prints a list of all employees nicely in the staff list.
     */
    public void listAllEmployees() {
        System.out.println("All Employees: ");
        for (Employee staff : stafflist) {
            System.out.println(staff);
        }
        System.out.println();
    }

    /**
     * Returns the employee, given their id.
     * @param id the employee's number
     * @return The employee if found, or null if not found
     */
    public Employee getEmployee(String id) {
        for (Employee staff: stafflist) {
            if (staff.getEmployeeNumber().equals(id)) {
                return staff;
            }
        }
        return null;
    }

    /**
     * Prints out a particular employee's pay stub, given their id.
     * @param id the employee's number
     */
    public void printEmployeePayStub(String id) {
        Employee staff = getEmployee(id);

        if (staff != null) {
            staff.printPayStub();
        } else {
            System.out.println("Employee " + id + " not found!");
        }
        System.out.println();
    }

    /**
     * Prints the pay stubs for all employees.
     */
    public void printAllPayStubs() {
        System.out.println("All Employee Pay Stubs: ");
        for (Employee staff: stafflist) {
            staff.printPayStub();
        }
        System.out.println();
    }

    /**
     * Uses the provided amount of sick days of an employee, given the id.
     * @param id employee's number
     * @param amount the number of sick days to use
     */
    public void enterSickDay(String id, double amount) {
        Employee staff = getEmployee(id);

        if (staff != null) {
            staff.useSickDay(amount);
            System.out.printf("New sick days taken: %.1f%n%n", staff.getSickDays());
        }
        else {
            System.out.println("Employee " + id + " not found!\n");
        }
    }

    /**
     * Resets all sick days for Full-TIme Employees to default amount, 20.
     */
    public void yearlySickDayReset() {
        for (Employee staff: stafflist) {
            if (staff instanceof FullTimeEmployee) {
                staff.resetSickDays();
            }
        }
    }

    /**
     * Resets the sick days for all Part-Time Employees to default amount, 0.
     */
    public void monthlySickDayReset() {
        for (Employee staff: stafflist) {
            if (staff instanceof PartTimeEmployee) {
                staff.resetSickDays();
            }
        }
    }
}
