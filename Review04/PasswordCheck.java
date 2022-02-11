import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {
            boolean match = true;

            System.out.print("Please enter a new password: ");
            String passwordOne = reader.nextLine();

            System.out.print("Please re-enter the password: ");
            String passwordTwo = reader.nextLine();
    
            if (passwordOne.equals(passwordTwo)) {
                System.out.println("The password strength is " + passwordStrength(passwordOne) + "!");
            } 
            else {
                System.out.println("Passwords do not match. Try again.");
                match = false;
            }

            if (match) {
                boolean valid = false;

                while (!valid) {
                    
                    System.out.print("Do you want to keep this password (y/n): ");

                    String ans = reader.nextLine();

                    if (ans.length() == 1 && ans.charAt(0) == 'y') {
                        valid = true;
                        keepRunning = true;

                    } else if (ans.length() == 1 && ans.charAt(0) == 'n') {
                        valid = true;
                    } 
                    else {
                        System.out.println("Enter a damn valid command.");
                    }
                }
            }
        }
    }

    public static String passwordStrength(String s) {

        if (s.length() < 8) {
            return "invalid";
        }   
        else {
            int numOfLower = 0, numOfUpper = 0, numOfSpecialChar = 0, numOfNum = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if ('a' <= ch && ch <= 'z') {
                    numOfLower++;
                } 
                else if ('A' <= ch && ch <= 'Z') {
                    numOfUpper++;
                } 
                else {

                    if ('0' <= ch && ch <= '9') {
                        numOfNum++;
                    } 
                    else if (ch != ' ') {
                        numOfSpecialChar++;
                    }
                }
            }
            
            if (s.length() >= 16) {
                if (numOfLower > 0 && numOfUpper > 0 && numOfSpecialChar > 0 && numOfNum > 0) {
                    return "strong";
                }
            } 
            else if (numOfLower > 0 && numOfUpper > 0 && numOfNum > 0) {
                return "medium";
            }
            else if (numOfSpecialChar == 0 && numOfNum == 0) {
                return "weak";
            }
        }
    return "invalid";
    }
}
