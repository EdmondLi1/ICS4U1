public class Question0301 {
    public static void main(String[] args) {
        doubleValue(3);
        average(4, 9, 7);
        printTriangle(3);
    }

    public static int doubleValue(int num) {
        return 2 * num;
    }

    public static double average(double x, double y, double z) {
        return (x + y + z) / 3;
    }
    
    public static void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
                }
            System.out.println();
            }
        }
        
    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }
}