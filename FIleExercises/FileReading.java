import java.io.*;
import java.util.*;

public class FileReading {
    public static void main(String[] args) {
        // exerciseOne();
        exerciseTwo();
    }

    public static void exerciseOne() {

        String fileName = "ICS4U1/FileExercises/grid.txt";
        File file = new File(fileName); 
        int[][] grid = new int[20][20];

        try {
            Scanner in = new Scanner(file);
            int c = Integer.parseInt(in.next());

            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    grid[row][col] = c;
                    if (in.hasNext()) {
                        c = Integer.parseInt(in.next());
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
        // insert algo here
        int rowMax = 0, colMax = 0, diaLeft = 0, diaRight = 0, prod = 0;

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col <= 16; col++) {

                // row prod
                prod = grid[row][col] * grid[row][col + 1] * grid[row][col + 2] * grid[row][col + 3];
                if (rowMax < prod) {
                    rowMax = prod;
                }

                // col prod
                prod = grid[col][row] * grid[col + 1][row] * grid[col + 2][row] * grid[col + 3][row];
                if (colMax < prod) {
                    colMax = prod;
                }
            }
        }

        // diagonals        
        for (int row = 0; row <= 16; row++) {
            for (int col = 0; col <= 16; col++) {
                prod = grid[row][col] * grid[row + 1][col + 1] * grid[row + 2][col + 2] * grid[row + 3][col + 3];
                if (diaLeft < prod) {
                    diaLeft = prod;
                }
                prod = grid[row][col + 3] * grid[row + 1][col + 2] * grid[row + 2][col + 1] * grid[row + 3][col];
                if (diaRight < prod) {
                    diaRight = prod;
                }
            }
        }
        System.out.println(Math.max(Math.max(rowMax, colMax), Math.max(diaLeft, diaRight)));
    }

   
    public static void exerciseTwo() {
        
        ArrayList<String> names = new ArrayList<>();
        int maxScore = 0;

        String fileName = "ICS4U1/FileExercises/names.txt";
        File file = new File(fileName); 

        try {
            Scanner in = new Scanner(file);
            in.useDelimiter("\",\"");

            String name = in.next();
            name = name.substring(1);
            while (in.hasNext()) {
                names.add(name);
                name = in.next();
            }
            name = name.substring(0, name.length() - 1);
            names.add(name);
            
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        Collections.sort(names);

        for (int i = 0; i < names.size(); i++) {
            maxScore += nameScore(names.get(i)) * (i + 1);
           
        }
        System.out.println(maxScore);
    }

    public static int nameScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            score += (s.charAt(i) - 64);
        }
        return score;
    }
}
