import java.util.Scanner;

public class AddPairs {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Intput: ");

        String nums = reader.nextLine();
        String pair = "";
        int sum = 0;

        for (int i = 0; i < nums.length(); i += 2) {

            // bruh
            if (i != nums.length() - 1 || nums.length() % 2 == 0){
                pair = nums.substring(i, i + 2);
            } else if (nums.length() % 2 == 1 && i == nums.length() - 1) {
                pair = nums.substring(i, i + 1);
            }
            System.out.println(pair);
            sum += Integer.parseInt(pair);
        }

        System.out.print("Output: " + sum);
    }
}
