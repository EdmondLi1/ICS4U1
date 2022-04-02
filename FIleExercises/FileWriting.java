import java.io.*;

public class FileWriting {

    public static void main(String[] args) {

        // exerciseOne();
        // exerciseTwo();
        // exerciseThree();
        // exerciseFour();
    }

    public static void exerciseOne () {
        BufferedReader in;
        BufferedWriter out;

        String readFileName = "ICS4U1/FileExercises/sisters.txt";
        String writeFileName = "ICS4U1/FileExercises/sistersCopy.txt";

            try {
            in = new BufferedReader(new FileReader(readFileName));
            out = new BufferedWriter(new FileWriter(writeFileName, false));

            int c = in.read();
            while (c != -1) {
                out.write(c);
                c = in.read();
            }
            out.close();
            in.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void exerciseTwo() {
        BufferedReader in;
        BufferedWriter out;

        String readFileName = "ICS4U1/FileExercises/sisters.txt";
        String writeFileName = "ICS4U1/FileExercises/SISTERS_COPY.txt";

        try {
            in = new BufferedReader(new FileReader(readFileName));
            out = new BufferedWriter(new FileWriter(writeFileName, false));

            int c = in.read();
            while (c != -1) {
                if (c >= 'a' && c <= 'z') {
                    out.write(c - 32);
                }
                else {
                    out.write(c);
                }
                c = in.read();
            }
            out.close();
            in.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void exerciseThree() {
        BufferedReader in;
        BufferedWriter out;

        String readFileName = "ICS4U1/FileExercises/SISTERS_COPY.txt";
        String writeFileName = "ICS4U1/FileExercises/SISTERSCLEAN.txt";

        try {
            in = new BufferedReader(new FileReader(readFileName));
            out = new BufferedWriter(new FileWriter(writeFileName, false));

            int c = in.read();
            while (c != -1) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '\n' || c  == ' ') ) {
                    out.write(c);
                }
                c = in.read();
            }
            out.close();
            in.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void exerciseFour() {
        BufferedReader in;
        BufferedWriter out;

        String readFileName = "ICS4U1/FileExercises/SISTERSCLEAN.txt";
        String writeFileName = "ICS4U1/FileExercises/stats.txt";

        int total = 0, vowels = 0;

        try {
            in = new BufferedReader(new FileReader(readFileName));
            out = new BufferedWriter(new FileWriter(writeFileName, false));

            int c = in.read();
            while (c != -1) {
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vowels++;
                }
                if (c != ' ' || c != '\n') {
                    total++;
                }
                c = in.read();
            }

            double percentage = 100.0 * vowels / total;

            out.write("Vowel count: " + vowels);
            out.newLine();

            out.write("Total letters: " + total);
            out.newLine();

            out.write(String.format("Vowel percentage: %.2f%%", percentage));

            out.close();
            in.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
