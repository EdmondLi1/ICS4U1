public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * length + 2 * width;
    }
}
