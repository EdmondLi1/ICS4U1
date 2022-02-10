import java.util.Scanner;

public class LiEdmondQuadraticSolver {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double a, b, c, D;

        System.out.println("Please enter your a, b, and c values for a quadractic in the form ax ^ 2 + bx + c.");
        System.out.print("\na: ");
        a = Double.parseDouble(reader.nextLine());

        System.out.print("b: ");
        b = Double.parseDouble(reader.nextLine());

        System.out.print("c: ");
        c = Double.parseDouble(reader.nextLine());

        D = discriminant(a, b, c);
        System.out.println("\nThe Discriminant of the quadratic is: " + D);
       
        solveEquation(a, b, c);

        System.out.println();

        if (isFactorable(a, b, c) == true) {
            System.out.println("The quadratic equation is factorable!");
        } else {
            System.out.println("The quadratic equation is NOT factorable.");
        }
    }

    public static double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static int numSolutions(double a, double b, double c) {
        double D = discriminant(a, b, c);
        int numSol;

        if (D > 0) {
            numSol = 2;
        } else if (D < 0){
            numSol = 0;
        } else {
            numSol = 1;
        }
        return numSol;
    }

    public static void solveEquation(double a, double b, double c) {
        double x1, x2;
        double D = discriminant(a, b, c);
        int numSol = numSolutions(a, b, c);

        if (numSol == 2) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.printf("There are two real roots to the quadratic equation. They are: %.2f and %.2f", x1, x2);

        } else if (numSol == 1) {
            x1 = -b / (2 * a);
            System.out.printf("There is only one real root to the quadratic eqution. It is: %.2f.", x1);

        } else {
            System.out.printf("There are no real roots to this quadratic equation.");
        }
    }

    public static boolean isFactorable(double a, double b, double c) {
        return (Math.sqrt(discriminant(a, b, c)) % 1 == 0);
    }
}
