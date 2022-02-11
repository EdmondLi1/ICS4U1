import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a message to be encrypted: ");
        String s = reader.nextLine();

        System.out.println("The ciphertext is: " + encrpyt(s));
    }

    public static String encrpyt(String s) {
        String ciphertext = "";

        if (s.length() == 1) {
            return s;
        } 
        else {
            ciphertext += s.charAt(s.length() - 1);

            for (int i = 1; i < s.length() - 1; i++) {
                char ch = s.charAt(i);
                String newC = Character.toString(ch);

                if (ch != ' '){
                    newC = Character.toString(ch + 2);
                }
                ciphertext += newC;
            }
            ciphertext += s.charAt(0);
        }
        // else { (s.length() >= 3)
        //     return "" + s.charAt(1) + s.charAt(0);
        // }
    return ciphertext;
    }
}
