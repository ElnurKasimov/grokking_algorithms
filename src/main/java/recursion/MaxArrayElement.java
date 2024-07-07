package recursion;

import java.util.Arrays;

public class MaxArrayElement {

    public long findMaxArrayElement(int[] array) {
        long result = 0;
        if (array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            result = array[0];
        } else {
            int[] shortArray = Arrays.copyOfRange(array, 1, array.length);
            long temp = findMaxArrayElement(shortArray);
            result = array[0] > temp ? array[0] : temp;
        }
        return result;
    }
}

