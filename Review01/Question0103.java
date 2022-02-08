import java.util.Scanner;

public class Question0103 {
    public static void main(String[] args) {
    
        Scanner reader = new Scanner(System.in);
        double a,b,c;

        a = Double.parseDouble(reader.nextLine());
        b = Double.parseDouble(reader.nextLine());
        c = Double.parseDouble(reader.nextLine());

        double average = (a + b + c) / 3;

       System.out.println(average); 
       
       reader.close();
    }
}
