import java.util.Scanner;

public class SortThreeLetters {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a single letter followed by 'Enter': ");

        char a = reader.nextLine().charAt(0);
        char b = reader.nextLine().charAt(0);
        char c = reader.nextLine().charAt(0);
        char temp;

        if (a > b) {
            temp = a;
            // make b bigger
            a = b;
            b = temp;
        }

        if (b > c) {
            temp = c;
            c = b;
            b = temp;
        }
        if (a > c) {
            temp = c;
            c = a;
            a = temp;
        }
        System.out.print(a + " " + b + " " + c);
    }
}