import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] values = {6, 5, 8, 7, 11};
        System.out.println("smallest: " + smallest(values));
        System.out.println("Index of the smallest: " + indexOfTheSmallest(values));

        int[] values2 = {-1, 6, 9, 8, 12};
        System.out.println(indexOfTheSmallestStartingFrom(values2, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values2, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values2, 4));

        System.out.println();

        int[] values3 = {3, 2, 5, 4, 8};
        System.out.println(Arrays.toString(values3));
        swap(values3, 1, 0);
        System.out.println(Arrays.toString(values3));
        swap(values3, 0, 3);
        System.out.println(Arrays.toString(values3));

        System.out.println();

        int[] values4 = {8, 3, 7, 9, 1, 2, 4};
        System.out.println(Arrays.toString(values4));
        sort(values4);

        int[] arr = new int[(int) (Math.random() * 100 + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200 + 1);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i: array) {
            if (i < smallest) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallest(array)) {
                return i;
            }
        }
        return 0;
    }


    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int smallest = array[index];
        int smallestIndex = index;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(array, i, indexOfTheSmallestStartingFrom(array, i));
            // System.out.println(Arrays.toString(array));
        }
    }
}
