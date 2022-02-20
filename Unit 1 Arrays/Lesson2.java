import java.util.Arrays;
import java.util.Scanner;

public class Lesson2 {

    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        // questionOne();
        // questionTwo();
        questionThree();
    }

    //////////////////////////////////////////////////////////////////////////
    // QUESITON 1
    //////////////////////////////////////////////////////////////////////////

    public static void questionOne() {
        int x, y;
        System.out.print("Enter the length of the array: ");
        x = Integer.parseInt(INPUT.nextLine());

        int[][] array = new int[x][];

        for (int i = 0; i < x; i++) {
            System.out.println("Array " + (i + 1) + ":");
            System.out.print("Enter the length of the array: ");
            y = Integer.parseInt(INPUT.nextLine());

            array[i] = new int[y];

            for (int j = 0; j < y; j++) {
                array[i][j] = Integer.parseInt(INPUT.nextLine());
            }
        }
        System.out.println("The array is:");
        System.out.println(Arrays.deepToString(array));
    }

    //////////////////////////////////////////////////////////////////////////
    // QUESITON 2
    //////////////////////////////////////////////////////////////////////////
    
    // a) a method arraySum() to compute and return the sum of the elements of an int[]
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }   

    // b) a method printArray() to print an int[][] using Arrays.toString(), 
    // but not deepToString().
    public static void printArray(int[][] arr) {

        System.out.print("[ ");
        for (int i = 0; i < arr.length - 1; i++) {
                System.out.println(Arrays.toString(arr[i]) + ",");
        }
        System.out.println(Arrays.toString(arr[arr.length - 1]) + " ]");
    }

    // c) a method printAll() to print all the elements in the array 
    public static void printAll(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("row %d, col %d = %d%n",i, j, arr[i][j] );
            }
        }
    }

    // d), e) , f)
    public static void questionTwo() {
        int[][] data = { {3, 2, 5},
                        {1, 4, 4, 8, 13},
                        {9, 1, 0, 2},
                        {0, 2, 6, 4, -1, -8} };

        int allSum = 0;
        for (int i = 0; i < data.length; i++) {
            // d) print the sum of each of the inside arrays (rows)

            System.out.println(arraySum(data[i]));
            allSum += arraySum(data[i]);
        }
        // e) print the sum of all elements in the array
        System.out.println("Sum of all elements are: " + allSum);

        // f) print all the elements in the array using printArray() and printAll()
        printArray(data);
        printAll(data);
    }

    //////////////////////////////////////////////////////////////////////////
    // QUESITON 3
    //////////////////////////////////////////////////////////////////////////

    public static void questionThree() {
        int[][] arr = { {72, 44, 12},
                        {47, 88, 21},
                        {1 , 36, 14} };

        // swapRows(arr, 1, 2);
        // swapCol(arr, 2, 1);
        // multiplyRow(arr, 1, 3);
        // System.out.println(Arrays.deepToString(arr));
        printArray(arr);
        printArray(rotate(arr));

    }

    // a) Write a method swapRow() that swaps two rows in an array. 
    // The method should take as parameters the array and two row indexes to be swapped. 
    // Assume the array has enough rows.

    public static void swapRows(int[][] arr, int r1, int r2) {
        // 0 base indexing (row 1, 2, .. n)
        int[] temp = arr[r1];

        arr[r1] = arr[r2];
        arr[r2] = temp;
    }

    // b) Write a method swapCol() that swaps two columns in an array. 
    // The method should take as parameters the array and two column indexes to be swapped.
    // Assume the array has enough columns.
    public static void swapCol(int[][] arr, int c1, int c2) {
        int temp;

        for (int i = 0; i < arr.length; i++) {
            temp = arr[i][c1];
            arr[i][c1] = arr[i][c2];
            arr[i][c2] = temp;
        }
    }

    // c) Write a method multiplyRow() that multiplies every element in a particular row by a given integer constant. 
    // The method should take as parameters the array, the row index, and the constant.
    public static void multiplyRow(int[][] arr, int row, int num) {
        for (int i = 0; i < arr[row].length; i++) {
                arr[row][i] *= num;
        }
    }

    // d) Write a method rotate() that rotates the array clockwise 90° 
    // and returns the new array.
    public static int[][] rotate(int[][] arr) {

        //  init a new rotated array
        int[][] rotated = new int[arr[0].length][arr.length];

        //  go through the new array;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                rotated[i][arr.length - 1 - j] = arr[j][i];
            }
        }
        return rotated;
    }

}