public class BinarySearch {
    public static void main(String[] args) {
        
        int[] values = {-42, -40, -39, -37, -30, -24, -22, -12, -10, -3, -2, 4, 7, 9, 14, 19, 25, 32, 34, 36, 39, 41, 43, 48};
        System.out.println(binarySearch(values, -40)); // 1
        System.out.println(binarySearch(values, -30)); // 4
        System.out.println(binarySearch(values, -36)); // -1
        System.out.println(binarySearch(values, 34)); // 18
        System.out.println(binarySearch(values, 48)); // 23
        System.out.println(binarySearch(values, -42)); // -1
        System.out.println(binarySearch(values, 50)); // -1
    }

    public static int binarySearch(int[] array, int searched) {

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middleIndex = -1;

        while (leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;

            if (array[middleIndex] > searched) {
                rightIndex = middleIndex - 1;
            }
            else if (array[middleIndex] < searched){
                leftIndex = middleIndex + 1;
            }
            else {
                return middleIndex;
            }
        }
        return -1;
    }
}
