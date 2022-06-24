import java.util.Scanner;

public class MenuProgram {

    Scanner input = new Scanner(System.in);

    List list = new List();
    int value;

    while(true) {
        System.out.print("Enter a positive integer (0 to stop): ");
        value = Integer.parseInt(input.next());

        if (value == 0) {
            break;
        }
        else if (value < 0) {
            System.out.println("Enter a postive integer!");
        }
        else {
            list.insertRecursive(value);
        }
    }
}