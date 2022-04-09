import java.util.Arrays;
public class LinearSearch {
    public static void main(String[] args) {
        
        int[] values = {3, -3, 7, 12, 9, 10, 14};
        System.out.println(linearSearch(values, 5));    // -1
        System.out.println(linearSearch(values, 9));    // 4
        
        int[] values2 = {3, -3, 7, 12, 9, 10, 14};
        Arrays.sort(values2);
        System.out.println(linearSearch2(values2, 5));
        System.out.println(linearSearch2(values2, 9));
        System.out.println(linearSearch2(values2, 14));
    }

    public static int linearSearch(int[] array, int searched) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searched) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch2(int[] array, int searched) {
        // 
        for (int i = 0; i < array.length; i++) {
            if (array[i] > searched) {
                break;
            }
            if (array[i] == searched) {
                return i;
            }         
        }
        return -1;
    }
}
