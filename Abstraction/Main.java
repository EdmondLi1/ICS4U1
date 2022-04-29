import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Shape a = new Rectangle(4, 5);
        Shape b = new Triangle(3, 4 ,5);
        Shape c = new Circle(10);
        Shape d = new Rectangle(15, 6);
        Shape e = new Triangle(12, 13 ,5);
        Shape f = new Circle(5.5);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(a);
        shapes.add(b);
        shapes.add(c);
        shapes.add(d);
        shapes.add(e);
        shapes.add(f);

        for (Shape s : shapes) {
            System.out.println(s.getClass());
            System.out.println("Area: " + s.area());
            System.out.println("Perimeter: " + s.perimeter());
            System.out.println("===========");
        }
    }
}
