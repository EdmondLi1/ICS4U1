import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Path for all files
        final String FILE_PATH = "ICS4U1/Cryptography/";

        // Variables for cryptography program
        String padKey, plaintext, ciphertext, fileName;
        int choice = -1;
        boolean running = true;

        // Main menu loop
        while (running) {

            // Main menu
            System.out.println("o---------------------------------o");
            System.out.println("| S-E-C-R-E-T-+-M-E-S-S-E-N-G-E-R |");
            System.out.println("o---------------------------------o");
            System.out.println();
            System.out.println("Choose from the following options:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("3. View file");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("> ");

            // Get the choice from the user, catch Strings and decimals
            try {
                choice = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid input. (Integer only)");
            }

            switch (choice) {
                case 1:     // encrypting plaintext and putting into file (given the key)
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println("| F-I-L-E-+-E-N-C-R-Y-P-T-I-O-N |");
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println();

                    // Takes the filename and stores into the plaintext and padKey Strings
                    System.out.print("Enter the filename of the plaintext message: ");
                    fileName = FILE_PATH + input.nextLine();
                    plaintext = Cryptography.formatText(FileHandling.readFile(fileName));

                    System.out.print("Enter the filename of the one-pad key: ");
                    fileName = FILE_PATH + input.nextLine();
                    padKey = Cryptography.formatText(FileHandling.readFile(fileName));

                    System.out.print("Enter the filename of the ciphertext message: ");
                    fileName = FILE_PATH + input.nextLine();

                    // Encrypt the plaintext using key String and write the new cipher text to 'fileName'
                    Cryptography.encrypt(fileName, padKey, plaintext);

                    System.out.println("Your message has been encrypted!\n");
                    break;

                case 2:     // decrypting ciphertext and putting into file (given the key)
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println("| F-I-L-E-+-D-E-C-R-Y-P-T-I-O-N |");
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println();

                    // Takes the filename and stores into the ciphertext and padKey Strings
                    System.out.print("Enter the filename of the ciphertext message: ");
                    fileName = FILE_PATH + input.nextLine();
                    ciphertext = Cryptography.formatText(FileHandling.readFile(fileName));

                    System.out.print("Enter the filename of the one-pad key: ");
                    fileName = FILE_PATH + input.nextLine();
                    padKey = Cryptography.formatText(FileHandling.readFile(fileName));

                    System.out.print("Enter the filename of the plaintext message: ");
                    fileName = FILE_PATH + input.nextLine();

                    // Decrypt the ciphertext using key String and write the new plaintext to 'fileName'
                    Cryptography.decrypt(fileName, padKey, ciphertext);
                    System.out.println("Your message has been decrypted!\n");
                    break;

                case 3:     // displays the content of the specified file
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println("| F-I-L-E-+-V-I-E-W-E-R |");
                    System.out.println("o-+-+-+-+-+-+-+-+-+-+-+-o");
                    System.out.println();
                    System.out.print("Enter the name of the file you would like to view: ");
                    fileName = FILE_PATH + input.nextLine();

                    System.out.println("-+-Begin view-+-\n");

                    // Print the content of the file
                    System.out.println(FileHandling.readFile(fileName));

                    System.out.println("-+-End view-+-\n");
                    break;

                case 0:     // quits the program
                    running = false;
                    System.out.println("Thanks for using the Secret Messenger!");
                    break;

                default:    // invalid integer input; display error message
                    System.out.println("Please enter a valid option on the menu!");
                    System.out.println();
            }
        }
    }
}
