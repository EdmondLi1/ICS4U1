import java.util.Arrays;

public class InsertionAndBubbleSort {

    public static void main(String[] args) {
        int[] values = {54, 26, 93, 17, 77, 31, 44, 55};
        System.out.println(Arrays.toString(values));
        bubbleSort(values);
        System.out.println(Arrays.toString(values));

        int[] values2 = {8, 3, 7, 9, 1, 2, 4, 11, 9, 0, -1, 7, 92, 100};
        System.out.println(Arrays.toString(values2));
        bubbleSort(values2);
        System.out.println(Arrays.toString(values2));

        int[] values3 = {54, 26, 93, 17, 77, 31, 44, 55};
        System.out.println(Arrays.toString(values3));
        insertionSort(values3);
        System.out.println(Arrays.toString(values3));

        int[] values4 = {8, 3, 7, 9, 1, 2, 4, 11, 9, 0, -1, 7, 92, 100};
        System.out.println(Arrays.toString(values4));
        enchancedInsertionSort(values4);
        System.out.println(Arrays.toString(values4));

        // make a random to test asymptotic run-time behavior
    }


    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void bubbleSort(int[] array) {
        int sorted = 0;
        // maybe do a while loop for if (...);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                } else if (array[j] < array[j + 1]) {
                    sorted++;
                }
                // System.out.println(Arrays.toString(array));
                if (sorted == array.length - i) {
                    break;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        // use counter var to check if swapped; o(n)
        int swapCounter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    swapCounter++;
                }
                // System.out.println(Arrays.toString(array));
            }
            if (swapCounter == 0) {
                break;
            }
        }
    }

    public static void enchancedInsertionSort(int[] array) {
        int i = 1, j;
        while (i < array.length) {
            j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j, j - 1);
                j--;
            }
            i++;
        }
    }
}
