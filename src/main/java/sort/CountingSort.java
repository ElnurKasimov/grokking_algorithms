package sort;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// the algorithm works efficiently in case when array contains a lot of equal elements
// and the range of such elements is significantly less than length of the array
public class CountingSort {

    public static int findMaxElement(int[] array) {
        int result = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > result) {
                result = array[i];
            }
        }
        return result;
    }

    public static int findMinElement(int[] array) {
        int result = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }


    public static int[] createCountArray (int[] array) {
        int[] countArray = new int[findMaxElement(array) + 1];
        Arrays.fill(countArray,0);
        for (int i = 0; i < countArray.length; i++) {
            for (int k : array) {
                if (k == i) {
                    countArray[i]++;
                }
            }
        }
        return countArray;
    }

    public static int[] sortByCounting (int[] array) {
        int[] result = new int[array.length];
        int[] countArray = createCountArray(array);
        if(countArray.length > 1) {
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i - 1];
            }
        } else return array;

        for (int i = array.length - 1; i >= 0; i--) {
            result[countArray[array[i]]-1] = array[i];
            countArray[array[i]]--;
        }
        return result;
    }

}
