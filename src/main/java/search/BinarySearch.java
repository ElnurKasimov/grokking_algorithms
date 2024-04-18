package search;

import java.util.*;
import java.util.stream.IntStream;


public class BinarySearch {
    /* The implementation of te algorithm works proper if:
       1. Ascending order.
          Otherwise, the first index in the array will be always as result of the code.
       2. If the array contains equal elements the first one index will be found
       3. If the array doesn't contain the element -1 will be return as a result.
     */

    public static int findElementIndex (int[] array, int element) {
        int[] sorted = Arrays.stream(array).sorted().toArray();
        if(!Arrays.equals(array, sorted)) {
            System.out.println("Input array must be sorted.");
            return -1;
        }
        if (Arrays.stream(array).noneMatch(e -> e == element)) {
            System.out.println("Input array doesn't contain desired element.");
            return -1;
        }
        int low = 0;
        int hight = array.length - 1;
        int middle = (low + hight)/2;
        while (low <= hight) {
            if (element == array[middle]){
                break;
            } else if (element > array[middle]) {
                low = middle + 1;
            } else {
                hight = middle - 1;
            }
            middle = (low + hight)/2;
        }
        return middle;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array length, min and max value : ");
        int length = sc.nextInt();
        int minValue = sc.nextInt();
        int maxValue = sc.nextInt();
        Random random = new Random();
        int[] testArray = IntStream.generate((() -> random.nextInt(maxValue - minValue + 1) + minValue) )
                .limit(length)
                .sorted()
                .toArray();
        System.out.println("testArray = " + Arrays.toString(testArray));
        System.out.print("Input number You want to find: ");
        int number = sc.nextInt();
        System.out.println("In the array " + Arrays.toString(testArray) + "\nnumber " + number +
                            " has  index " + findElementIndex(testArray, number));
    }
}

