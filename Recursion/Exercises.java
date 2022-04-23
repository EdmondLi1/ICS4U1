public class Exercises {
    public static void main(String[] args) {
        
        int n = -5;
        int x = 2, b = 10;
        int j = 12, k = 16;
        int c = -10;
        int d = 11;
        System.out.println(n + "! = " + factorial(n));
        System.out.println("Power(" + x + ", " + n  + ") = " + power(x, n));
        System.out.println("Fib(" + b + ") = " + fib(b));
        System.out.println("gcd(" + j + ", " + k  + ") = " + gcd(j, k));
        System.out.println("Square(" + c + ") = " + square(c));
        System.out.println("Prime(" + d + ") = " + prime(d));
    }

    // Recursive factorial, n > 0 (n is a natural number)
    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    // Exercise 1
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n > 0) {
            return x * power(x , n - 1);
        }
        else {
            return 1 / x * power(x, n + 1);
        }
    }   

    // Exercise 2
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Exercise 3
    public static int gcd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m > n) {
            return gcd(n, m - n);
        } else {
            return gcd(n, m);
        }
    }

    // Exercise 4
    public static int square(int n) {
        if (n == 1) {
            return 1;
        } else if (n > 0){
            return square(n - 1) + 2 * n - 1;
        }
        else {
            return square(n + 1) - 2 * n - 1;
        }
    }

    // Exercise 5
    public static boolean prime(int m) {
        return prime(m, m - 1);
    }

    public static boolean prime(int n, int m) {
        if (m == 1) {
            return true;
        }
        else if (n % m == 0){
            return false;
        }
        return prime(n, m - 1);
    }
}
