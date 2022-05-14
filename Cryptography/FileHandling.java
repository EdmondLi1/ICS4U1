import java.io.*;
import java.util.Scanner;

public class FileHandling {

    /**
     * Reads the content of the file and returns it in a String.
     * @param fileName the file to read
     * @return the exact content within the file
     */
    public static String readFile(String fileName) {
        String line = "", content = "";
        File file = new File(fileName);

        try {
            // Set the Scanner to read the file
            Scanner reader = new Scanner(file);

            // Read the file line by line and appends to the content String
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                content += line + "\n";
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return content;
    }

    /**
     * Writes the given encrypted or decrypted text into the file specified.
     * @param fileName the file to write in
     * @param content the text to be written on the file
     */
    public static void writeFile(String fileName, String content) {
        int charCounter = 0;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            // Iterate the text by character
            for (int index = 0; index < content.length(); index++) {
                // If there are 5 blocks of letters, make a new line
                if (charCounter % 30 == 0 && charCounter != 0) {
                    writer.write('\n');
                    charCounter = 0;
                }
                writer.write(content.charAt(index));
                charCounter++;
            }
            writer.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
