public class MoreExercises {
    
    public static void main(String[] args) {
        int a = 4, d = 5, b = 10;
        String br = "Hello";
        System.out.println("reverse(" + br + ") = " + reverse(br));
        System.out.println("triangle(" + d + ") = ");
        printTriangle(d);
        System.out.println("numDigits(" + a + ") = " + numDigits(a));
        System.out.print("hailstone(" + b + ") = " );
        hailstone(b);
    }

    // Exercise 1 
    public static String reverse(String s) {
        int n = s.length() - 1;
        if (n < 0) {
            return "";
        }
        else {
            return s.charAt(n) + reverse(s.substring(0, n));
        }
    }

    // Exercise 2 
    public static String printTriangle(int n) {
        if (n <= 0) {
            return "";
        }
        String res = printTriangle(n - 1);

        res += "*";
        System.out.println(res);
        return res;
    }

    // Exercise 3
    public static int numDigits(int n) {
        if (n == 0) {
            return 0;
        }
        else {
            return 1 + numDigits(n / 10);
        }
    }

    // Exercise 4
    public static void hailstone(long n) {
        System.out.print(n + ", ");

        if (n == 2) {
            System.out.println(1);
        }
        else if (n % 2 == 0) {
            hailstone(n / 2);
        }
        else {
            hailstone(3 * n + 1);
        }
    }
}
