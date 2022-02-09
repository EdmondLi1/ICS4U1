import java.util.Scanner;

public class PythagoreanTriples {

    public static int gcd(int a, int b){
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Enter a postive integer: ");
        int num = Integer.parseInt(reader.nextLine());
        int repeat = 0;

        for(int c = 5; c < num + 1; c++) {
            for (int b = 4; b < num; b++) {
                for (int a = 3; a < num - 1; a++) {
                    double root = Math.sqrt(a * a + b * b);
                    if (root == repeat) {
                        continue;
                    }
                    else if (root % 1 == 0 && root == c) {
                        int tempFactor = gcd(a, b);
                        int greatFactor = gcd(tempFactor, c);

                        if (greatFactor == 1) {
                            repeat = c;
                            System.out.println(a + " " + b + " " + c);
                        }
                    }
                }
               
            }
        }
    }
}
