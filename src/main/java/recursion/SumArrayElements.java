package recursion;

import java.util.Arrays;

public class SumArrayElements {
    public long sumArrayElements (int[] array) {
        long result = 0;
        if (array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            result = array[0];
        } else {
            int[] shortArray = Arrays.copyOfRange(array, 1, array.length);
            result = array[0] + sumArrayElements(shortArray);
        }
        return result;
    }

}
