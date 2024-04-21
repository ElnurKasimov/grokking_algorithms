package sort;

import java.util.Arrays;

public class Sorting {

    public static int[] sortBySelection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i; j < (array.length); j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
        return array;
    }

    public static int[] sortByBubble(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = {-12, 2345, 435, 97, -67, 0, -3786, 645, 123, 1900};
        System.out.println("input array - " + Arrays.toString(array));
        System.out.println("sorted array by selection - " + Arrays.toString(sortBySelection(array)));
        System.out.println("sorted array by bubble - " + Arrays.toString(sortByBubble(array)));
    }


}
