import java.util.Scanner;
public class Question0105 {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Please enter a three-digit number: ");

        int num = reader.nextInt();
        
        int hundreads = num / 100 % 10;
        int tens = num / 10 % 10;
        int ones = num % 10;
        int sumOfDigits = ones + tens + hundreads;

        System.out.println("Number: " + num + "\nSum of digits: " + sumOfDigits);

        reader.close();

    }
}
