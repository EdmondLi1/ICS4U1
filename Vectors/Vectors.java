import java.util.Scanner;
public class Vectors {

    public static void main(String[] args) {

        // Instantiate Scanner object to read input
        Scanner reader = new Scanner(System.in);

        // DEMO CODE without User input
        // Instantiate three vector objects
        Vector a = new Vector(10, 5, 10);
        Vector b = new Vector(3, 2, -4);
        Vector c = new Vector(-4, 7, 3);
        Vector d = new Vector(b);
        Vector zero = new Vector();

        System.out.println("Welcome to the Vector Playground!");
        System.out.println("Lets start off with the basics, shall we?\n");

        // printing the vectors (using toString)
        System.out.println("Here are some sample vectors to demonstrate some properties: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("0 = " + zero);

        // demonstrating getters
        System.out.println("\nVector a's properties: ");
        System.out.printf("x-comp of Vector a: %.2f%n", a.getX());
        System.out.printf("y-comp of Vector a: %.2f%n", a.getY());
        System.out.printf("z-comp of Vector a: %.2f%n", a.getZ());
        System.out.printf("magnitude of Vector a: %.2f%n%n", a.getMagnitude());
        a.printVector();

        // Setting the new vector 
        System.out.println("Changing Vector a to: (5, 2, 2) and printing it.");
        a.setVector(5, 2, 2);
        System.out.println("Vector a: " + a);
        a.printVector();

        // Show the different vector operators
        System.out.println("Vectors have different operators too! Here are some that are in the class:\n");
        System.out.println("Adding and subtracting vectors:\n");
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a + 0 = " + a.add(zero));
        System.out.println("b - 0 = " + b.subtract(zero));

        System.out.println("\n\nMORE Vector Operators! Scalar multiplication, dot product, and cross product:\n");
        System.out.println("3 * a = " + a.scalarMultiply(3));
        System.out.println("a dot c = " + a.dotProd(c));
        System.out.println("d x a = " + d.crossProd(a));

        // Show the helper methods; not operators for vectors
        System.out.println("\n\nHere are some other Vector methods that are supported by this Class!:");
        System.out.println("Unit Vector of a: " + a.unitVector());
        System.out.println("\nPrinting the Vector c nicely!");
        c.printVector();

        System.out.printf("Angle between vector a and d is: %.2f%n", Vector.getAngleBetween(a, d));
        System.out.printf("Angle between vector c and a is: %.2f%n", Vector.getAngleBetween(c, a));

        System.out.println("\nIs Vector 'a' orthogonal to Vector 'c'? " + Vector.isOrthogonal(a, c));
        System.out.println("Is Vector 'b' orthogonal to Vector 'c'? " + Vector.isOrthogonal(b, c));

        System.out.println("\nIs Vector 'a' == Vector 'b'? " + a.equals(b));
        System.out.println("Is Vector 'b' == Vector 'd'? " + b.equals(d));


        // Allow the user to Instantiate new TWO NEW Vector Object
        double x, y, z;
        System.out.println("\nNow its your turn, Enter two vectors and see all the operators in action!");
        System.out.println("\nEnter the x, y, z components for your first Vector, v (real numbers please!): ");
        System.out.print("x: ");
        x = Double.parseDouble(reader.nextLine());

        System.out.print("y: ");
        y = Double.parseDouble(reader.nextLine());

        System.out.print("z: ");
        z = Double.parseDouble(reader.nextLine());

        Vector v = new Vector(x, y, z);

        System.out.println("\nEnter the x, y, z components for your second Vector, u (real numbers please!): ");
        System.out.print("x: ");
        x = Double.parseDouble(reader.nextLine());

        System.out.print("y: ");
        y = Double.parseDouble(reader.nextLine());

        System.out.print("z: ");
        z = Double.parseDouble(reader.nextLine());

        Vector u = new Vector(x, y, z);

        // use the methods and operators above but for user's vectors now
        System.out.println("\nYour vector's now!");

        System.out.println("Vector v:");
        v.printVector();

        System.out.println("Vector u:");
        u.printVector();

        System.out.println("v + u = " + v.add(u));
        System.out.println("v - u = " + v.subtract(u));
        System.out.println("v dot u = " + v.dotProd(u));
        System.out.println("v x u = " + v.crossProd(u));

        System.out.println();

        System.out.println("Unit Vector of v: " + v.unitVector());
        System.out.println("Unit Vector of u: " + u.unitVector());

        System.out.printf("Angle between vector v and u is: %.2f%n", Vector.getAngleBetween(v, u));
        System.out.println("\nIs Vector 'v' orthogonal to Vector 'u'? " + Vector.isOrthogonal(v, u));
        System.out.println("Is Vector 'v' == Vector 'u'? " + v.equals(u));

        System.out.println("\nThank you for using the Vector's program, feel free to test again!");
    }
}