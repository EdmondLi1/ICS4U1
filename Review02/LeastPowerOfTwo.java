import java.util.Scanner;

public class LeastPowerOfTwo {
     public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a positve integer: ");

        int num = reader.nextInt();
        int power = 1;
        int leastTwo = 1;

        while (num > Math.pow(2, power)){
            power++;
        }
        leastTwo = (int) Math.pow(2, power);

        System.out.println(leastTwo + " is the smallest power of 2 greater than " + num);
     }
}
