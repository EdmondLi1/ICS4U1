public class Circle {

    // instantiate field variables
    private double centreX;
    private double centreY;
    private double radius;

    // Constructor methods for Circle Class
    public Circle(double centreX, double centreY, double radius) {
        this.centreX = centreX;
        this.centreY = centreY;
        // if radius is negative; make it positive
        this.radius = Math.abs(radius);
    }

    // no param, default values for Circle Object; (0, 0), r = 1.
    public Circle() {
        centreX = 0;
        centreY = 0;
        radius = 1;
    }

    // copy of another Circle Object's field
    public Circle(Circle c) {
        centreX = c.centreX;
        centreY = c.centreY;
        radius = c.radius;
    }

    // Accessors and Mutators Method
    public double getCentreX() {
        return centreX;
    }

    public void setCentreX(double centreX) {
        this.centreX = centreX;
    }

    public double getCentreY() {
        return centreY;
    }

    public void setCentreY(double centreY) {
        this.centreY = centreY;
    }

    public double getR() {
        return radius;
    }

    public void setR(double radius) {
        this.radius = radius;
    }

    public void setCircle(double centreX, double centreY, double radius) {
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
    }

    // Instance Methods
    public double area() {
        // method that returns area; A = πr²
        return Math.PI * radius * radius;
    }

    public double circumference() {
        // method that returns the circumference / perimeter ; C = 2πr
        return 2 * Math.PI * radius;
    }

    public double diameter() {
        // method that returns the diameter; d = 2r
        return 2 * radius;
    }

    public Circle smaller(Circle c) {
        // method takes a Circle object c; returns the Object with the SMALLER area
        if (this.area() <= c.area()) {
            // if this obj area <= c.area; return this instance circle
            return this;
        }
        return c;
    }

    public double distance(Circle c) {
        // method takes another circle; calculates the distance between two centres of the circle
        // uses pythagorean theorem -> sqrt([Δx]² + [Δy]²)
        return Math.sqrt(Math.pow(centreX - c.centreX, 2) + Math.pow((centreY - c.centreY), 2));
    }

    public boolean isInside(Circle c) {

        // Method takes another Circle object; returns boolean expression of the result of
        // the current Circle Object's radius + distance between the 2 centres exceeds the 'outer' circle's radius
        return (this.distance(c) + radius < c.radius);
    }

    public boolean equals(Circle c) {
        // Method takes another Circle object, checks if each field property matches the current circle object (to see if same)
        return (centreX == c.centreX) && (centreY == c.centreY) && (radius == c.radius);
    }

    // Class Method
    public static void printEquation(Circle c) {
        // Method takes a Circle object, and prints the mathematical implicit equation representing a circle
        // regular expression has negative i.e (x - x0)² + (y - y0)² = r²; when x0, y0, r > 0
        String xSign = "-";
        String ySign = "-";

        // if negative; use '+'' within the implicit equation
        if (c.centreX < 0) {
            xSign = "+";
        }

        if (c.centreY < 0) {
            ySign = "+";
        }
        System.out.printf("(x %s %.1f)² + (y %s %.1f)² = %.1f%n", xSign, Math.abs(c.centreX),
                ySign, Math.abs(c.centreY), Math.pow(c.radius, 2));
    }

    // Overriding Java default toString
    @Override
    public String toString() {
        // Method prints the properties of the Circle object nicely
        return "Circle: centre at (" + centreX + ", " + centreY + ") and radius " + radius;
    }
}
