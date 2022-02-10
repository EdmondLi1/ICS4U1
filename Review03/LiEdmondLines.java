import java.util.Scanner;

public class LiEdmondLines {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        // Points corresponding to line 1
        System.out.println("Please enter the coordinates of two points on line segment 1: ");
        System.out.print("point A x-value: ");
        double ax = Double.parseDouble(reader.nextLine());

        System.out.print("point A y-value: ");
        double ay = Double.parseDouble(reader.nextLine());

        System.out.println();

        System.out.print("point B x-value: ");
        double bx = Double.parseDouble(reader.nextLine());

        System.out.print("point B y-value: ");
        double by = Double.parseDouble(reader.nextLine());

        System.out.println();

        // Points corresponding to line 2
        System.out.println("Please enter the coordinates of two points on line segment 1: ");
        System.out.print("point C x-value: ");
        double cx = Double.parseDouble(reader.nextLine());

        System.out.print("point C y-value: ");
        double cy = Double.parseDouble(reader.nextLine());

        System.out.println();

        System.out.print("point D x-value: ");
        double dx = Double.parseDouble(reader.nextLine());

        System.out.print("point D y-value: ");
        double dy = Double.parseDouble(reader.nextLine());

        System.out.println("\nResults: ");

        // Length comparison
        double lineOneLength = calcLength(ax, ay, bx, by);
        double lineTwoLength = calcLength(cx, cy, dx, dy);

        if ( lineOneLength == lineTwoLength) {
            System.out.println("The two line segments do have the same length.");
        } else {
            System.out.println("The two line segments do not have the same length.");
        }

        // Check if parrallel, perdendicular or neither
        double lineOneSlope = calcSlope(ax, ay, bx, by);
        double lineTwoSlope = calcSlope(cx, cy, dx, dy);

        if (lineOneSlope == lineTwoSlope) {
            System.out.println("The two line segments are parallel.");

        } else if (lineOneSlope == - 1 / lineTwoSlope) {
            System.out.println("The two line segments are perpendicular.");

        } else {
            System.out.println("The two line segments are neighter parallel nor perpendicular.");
        }
    }

    public static double calcSlope(double x1, double y1, double x2, double y2) { 
        if (x2 - x1 == 0) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (y2 - y1) / (x2 - x1);
        }
    }

    public static double calcLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}