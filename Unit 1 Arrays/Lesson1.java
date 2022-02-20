import java.util.Arrays;
import java.util.Scanner;

public class Lesson1 {

    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionThree();
        questionFourA();
        questionFourB();
        questionFiveA();
        questionFiveB();
    }

    public static void questionOne() {

        // a. Ask user to enter an integer n, then declare an array of integers of size n
        System.out.print("Enter a positive integer: ");
        int n = Integer.parseInt(INPUT.nextLine());

        int[] nums = new int[n];

        // b. Initialize all elements of the array to 1
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        // c. Ask user to enter n integers, and fill the array with these integers in order

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter an integer to fill the array at index " + i + " : ");
            nums[i] = Integer.parseInt(INPUT.nextLine());
        }

        System.out.println(Arrays.toString(nums));

        // d. Switch the first and last values of the array

        int temp = nums[0];
        int maxIndex = nums.length - 1;

        nums[0] = nums[maxIndex];
        nums[maxIndex] = temp;

        System.out.println(Arrays.toString(nums));

        // e. Change any negative values to positive values (of the same magnitude), but don't touch the positive ones

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        System.out.println(Arrays.toString(nums));

        // f. Print a line of *, one for each number in the array.
        //    The number of stars equals the value of each cell. If the array was [1, 4, 2], you should print:

        for (int numbers : nums) {
            for (int i = 0; i < numbers; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // g. Print all the even numbers in the array
        for (int numbers : nums) {
            if (numbers % 2 == 0) {
                System.out.println(numbers);
            }
        }
    }

    public static void questionTwo() {
        int[] numbers = {13, 60, 50, 46, 56, 83, 22, 71};

        // a. Simply print the elements in reverse order. No new array.
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
        // b. Create an empty array of identical length. The original array is not changed.
        //    The second array gets the elements of the first array in reversed order. The second array is then printed.
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(reversed));
    }

    public static void questionThree() {
        // a. Get an integer n from the user and initialize a double array of length n.
        // Ask the user to enter n numbers, and fill the array with them in order.
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(INPUT.nextLine());
        double[] arr = new double[n];
        double sum = 0, average = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a double: ");
            arr[i] = Double.parseDouble(INPUT.nextLine());
        }

        // b. Calculate and print the sum and average of all the elements in the array.
        for (double number : arr) {
            sum += number;
        }
        average = sum / n;
        System.out.printf("Sum of numbers: " + sum + "\nAverage of numbers: %.2f\n", (float) average);

        // c. Print all the elements of the array “nicely”, without using the Arrays.toString() method.
        // If the array was [3.0, 5.0, -4.0, 1.0], the print out should be exactly as:
        // 3.0, 5.0, -4.0, 1.0
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        // d. Identify and print the smallest value of the array.
        double min = arr[0];
        for (double number : arr) {
            if (min > number) {
                min = number;
            }
        }
        // e. Identify and print the index of the smallest value (first occurence, if more than 1) of the array.
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                System.out.print("Minimum value of the arr is located at index: " + i);
                break;
            }
        }
    }

    public static void questionFourA() {
        // a. Ask the user to enter a string. Add each character of the string to two different arrays:
        // char[] and String[], e.g. "Java" → ['J', 'a', 'v', 'a'] and ["J", "a", "v", "a"]
        // (Though when printed, both will look like [J, a, v, a])

        System.out.print("Enter string: ");
        String s = INPUT.nextLine();

        char[] ch = new char[s.length()];
        String[] str = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
            str[i] = s.substring(i, i + 1);
        }
        System.out.println(str + "\n" + ch);
    }

    // b. Get an integer n from the user and initialize a String array of length n.
    // Ask the user to enter n strings and fill the array. Create a new string which is the elements of the array in order,
    // concatenated with spaces between each element but not after the last string,
    // e.g. ["All", "your", "base"] → "All your base"

    public static void questionFourB() {
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(INPUT.nextLine());

        String[] str = new String[n];
        String concatenation = "";

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string for me <3: ");
            str[i] = INPUT.nextLine();
        }

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                concatenation = concatenation.concat(str[i] + " ");
            } else {
                concatenation = concatenation.concat(str[i]);
            }
        }
        System.out.println(Arrays.toString(str));
        System.out.println(concatenation);
    }

    public static void questionFiveA() {
        String[] names = {"Alan", "Ada", "Grace", "Linus"};
        String[] numbers = {"181256345", "181159830", "181245891", "189875304"};
        String className;

        System.out.print("Class: ");
        className = INPUT.nextLine();

        System.out.println("Students: ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ", " + numbers[i]);
        }
    }
    public static void questionFiveB() {
        // b. Ask the user to enter a student's name and if that name exists, print the student number.
        // If it doesn't exist, print an error message:
        String[] names = {"Alan", "Ada", "Grace", "Linus"};
        String[] numbers = {"181256345", "181159830", "181245891", "189875304"};

        System.out.print("Please enter a name: ");
        String studentName = INPUT.nextLine();
        int index = -1;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(studentName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(names[index] + "'s student name is " + numbers[index] + ".");
        }
        else {
            System.out.println("Student " + studentName + " does not exist.");
        }
    }
}
