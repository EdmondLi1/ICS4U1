import java.util.Scanner;

public class MakeUppercase {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = reader.nextLine();
        System.out.println("Uppercase Equivalent: " + makeUpperCase(s));
    }

    public static String makeUpperCase(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                newString += Character.toString(ch - 32);
            } else {
                newString += ch;
            }
        }
        return newString;
    }
}
