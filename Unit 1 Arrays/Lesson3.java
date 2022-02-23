import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Lesson3 {

    public static final Scanner INPUT = new Scanner(System.in);
    public static void main(String[] args) {
        // questionOne();
        // questionTwo();
    }

    /////////////////////////////////////////////////////////////////////////
    //  Question One
    /////////////////////////////////////////////////////////////////////////

    public static void questionOne() {
        // i) ask the user to enter values for an integer list
        ArrayList<Integer> arr = getIntList();

        // j) print the list
        System.out.println(arr);

        // k) print the greatest value, sum, average, median, 
        // and variance nicely with explanatory statements
        System.out.println("Greatest value: " + greatest(arr));
        System.out.println("Sum of Array: " + sum(arr));
        System.out.println("Average of Array: " + average(arr));
        System.out.println("Variance: " + variance(arr));

        // l) asks the user for an integer to check if it appears 
        // more than once in the list and print the result
        System.out.print("Enter an integer to check if in array: ");
        int n = Integer.parseInt(INPUT.nextLine());

        System.out.println("Is the number, " + n + " appear more than once in the list? " + moreThanOnce(arr, n));
        
        // m) asks the user to enter values for another integer list and combine it with the list from above; 
        // print each entered list and the combined list
        System.out.println("Enter the values for another array:");
        ArrayList<Integer> newArr = getIntList();
        ArrayList<Integer> combined = combine(newArr, arr);

        System.out.println(arr);
        System.out.println(newArr);
        System.out.println(combined);
    }

    // a) getIntList that prompts the user for integer values (one to a line) 
    // and stores them in an ArrayList; when the user enters an empty line, 
    // the list ends; the method should return the list as ArrayList<Integer>
    public static ArrayList<Integer> getIntList() {
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Enter an integer to store in the list: ");
        String input = INPUT.nextLine();

        while(!(input.equals(" ") || input.equals(""))) {
            // assume valid input or rip.
            arr.add(Integer.parseInt(input));
            System.out.print("Enter an integer to store in the list: ");
            input = INPUT.nextLine();
        }
        return arr;
    }

    // b) greatest that takes as parameter an integer ArrayList and 
    // returns the greatest value in the list (don't sort the list
    public static int greatest(ArrayList<Integer> arr) {    
        int biggest = arr.get(0);

        for (int number : arr) {
            if (number > biggest) {
                biggest = number;
            }
        }
        return biggest;
    }

    // c) sum that takes as parameter an Integer ArrayList and 
    // returns the sum of all values of the list
    public static int sum(ArrayList<Integer> arr) {

        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        return sum;
    }

    // d) average that takes as parameter an integer ArrayList and 
    // returns the average of all values (must use sum); 
    // return 0 if the list is empty
    public static double average(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        return sum(arr) / arr.size();
    }

    // e) median that takes as parameter an integer ArrayList and returns 
    // the median value (the middle value of sorted list, or the average of 
    // the middle two of an even number of values); 
    // return 0 if the list is empty
    public static int median(ArrayList<Integer> arr) {
        // do not sort the actual array, but a copy of it
        ArrayList<Integer> copy = new ArrayList<>();
        for (int integer : arr) {
            copy.add(integer);
        }
        Collections.sort(copy);

        int len = arr.size();
        int median = 0;

        if (arr.size() == 0) {
            return median;
        }
        else if (len % 2 == 0) {
            median = 1/2 * (arr.get(len / 2) + arr.get(len / 2 + 1));
        }
        else {
            median = arr.get((len / 2 + 1));
        }
        return median;
    }
    // f) variance that takes as parameter an integer list and returns the sample variance of the list 
    // (must use average); see this Wikipedia entry to determine the unbiased sample variance: 
    public static double variance(ArrayList<Integer> arr) {
        double variance = 0;
        double avg = average(arr);

        for (int number : arr) {
            variance += Math.pow((number - avg), 2);
        }
        variance *= 1.0 / (arr.size() - 1);
        return variance;
    }
    // g) moreThanOnce that takes as parameters an integer list and an integer and 
    // returns true if the integer appears more than once in the list 
    public static boolean moreThanOnce(ArrayList<Integer> arr, int num) {
        int count = 0;
        for (int number : arr) {
            if (number == count) {
                count++;
            }
        }
        return (count > 1);
    }

    // h) combine that takes as parameters two integer lists and combines them into 
    // a new list, which is then returned; however, duplicate entries are not included
    public static ArrayList<Integer> combine(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean duplicate = false;

        // elms in arr 2
        for (int num2 : arr2) {
            duplicate = false;
            for (int num1 : arr1) {
                if (num1 == num2) {
                    duplicate = true;
                    break;
                }
            } 
            if (!duplicate) {
                result.add(num2);
            }
        }

        // elms in arr 1
        for (int num1 : arr1) {
            duplicate = false;
            for (int num2 : arr2) {
                if (num1 == num2) {
                    duplicate = true;
                    break;
                }
            } 
            if (!duplicate) {
                result.add(num1);
            }
        }
        return result;
    }


    
    /////////////////////////////////////////////////////////////////////////
    //  Question Two
    /////////////////////////////////////////////////////////////////////////

    public static void questionTwo() {
        // g) ask the user to enter values for a string ArrayList
        ArrayList<String> arr = getStringList();

        // h) print each string on its own line
        System.out.println("\nStrings in the list: ");
        printList(arr);

        // i) print the lengths of all the strings
        System.out.println("\nLengths of the string: ");
        int[] lengths = lengthsOfStrings(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i) + " length: " + lengths[i]);
        }

        //j) print the list in reverse order
        System.out.println("\nStrings in the list in REVERSESD ORDER: ");
        printReversed(arr);

        // k) remove the first and last items and print the list
        System.out.println("\nRemoving the last and first string in the list: ");
        removeFirst(arr);
        removeLast(arr);
        printList(arr);

        // l) asks the user for a string to remove from the list, and if possible, 
        // removes it and prints the new list, or prints an error; 
        // ask the user for an index and remove that index element from the list, if possible.
        System.out.println("Enter a String to remove from the list: ");
        String s = INPUT.nextLine();
        removeItem(arr, s);
        System.out.println(arr);

        /*
        System.out.println("Enter an index to remove from the list: ");
        int index = Integer.parseInt(INPUT.nextLine());
        removeItem(arr, index);
        System.out.println(arr);
        */
    }

    // a) getStringList that prompts the user to enter string values until they 
    // enter an empty string; store the values in a string ArrayList and return it
    public static ArrayList<String> getStringList() {
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Enter the string to the list: ");
        String input = INPUT.nextLine();

        while(!input.equals("")) {
            list.add(input);

            System.out.print("Enter the string to the list: ");
            input = INPUT.nextLine();
        }
        return list;
    }
    // b) lengthsOfStrings that takes as parameter a string ArrayList and 
    // returns the length of each string as an int[]
    public static int[] lengthsOfStrings(ArrayList<String> arr) {
        int[] lengths = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            lengths[i] = arr.get(i).length();
        }
        return lengths;
    }
    // c) removeLast that takes as parameter a string ArrayList and 
    // removes the last item in the list
    public static void removeLast(ArrayList<String> arr) {
        arr.remove(arr.size() - 1);
    }

    // d) removeFirst that takes as parameter a string ArrayList and 
    // removes the first item in the list
    public static void removeFirst(ArrayList<String> arr) {
        arr.remove(0);
    }

    // e) printList that takes as parameter a string ArrayList and 
    // prints the items each on their own line
    public static void printList(ArrayList<String> arr) {
        for (String string : arr) {
            System.out.println(string);
        }
    }

    // f) printReversed that takes as parameter a string ArrayList and prints 
    // the items in reverse order without changing or copying the list
    public static void printReversed(ArrayList<String> arr) {
        for (int index = arr.size() - 1; index >= 0; index--) {
            System.out.println(arr.get(index));
        }
    }

    // l) methods removeItem with 'int index' and 'String s'
    /*
    public static void removeItem(ArrayList<String> arr, int index) {
        if (0 <= index && index <= arr.size() - 1) {
            arr.remove(index);
        }
        else {
            System.out.println("IndexError: please provide a valid index. ");
        }
    } 
    */
    public static void removeItem(ArrayList<String> arr, String s) {
        // removes the first apparence of 's'in arr.
        boolean inList = false;
        for (String elm : arr) {
            if (s.equals(elm)) {
                inList = true;
                arr.remove(s);
                break;
            }
        }
        if (!inList) {
            System.out.println("String was not found in list!");
        }
        System.out.print("Perphaps you were looking for an index: ");

        int index = Integer.parseInt(INPUT.nextLine());

        if (0 <= index && index <= arr.size() - 1) {
            arr.remove(index);
        }
        else {
            System.out.println("IndexError: please provide a valid index. ");
        }
    }
}
