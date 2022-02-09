import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a year: ");

        int year = reader.nextInt();

        if (year % 400 == 0 ){
            System.out.println("The year " + year + " is a leap year.");
        } 
        else if (year % 100 == 0) {
            System.out.println("The year " + year + " is not a leap year.");
        } 
        else if (year % 4 == 0) {
            System.out.println("The year " + year + " is a leap year.");
        } 
        else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}
