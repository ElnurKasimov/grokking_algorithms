package sort;

import java.util.Arrays;

public class SelectionSort {

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

    public static void main(String[] args) {
        int[] array = {-12, 2345, 435, 97, -67, 0, -3786, 645, 123, 1900};
        System.out.println("input array - " + Arrays.toString(array));
        System.out.println("sorted array - " + Arrays.toString(sortBySelection(array)));
    }


}
