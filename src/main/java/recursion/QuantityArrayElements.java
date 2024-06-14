package recursion;

import java.util.Arrays;

public class QuantityArrayElements {
    public int calculateQuantityArrayElements (int[] array) {
        int result = 0;
        if (array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            result = 1;
        } else {
            int[] shortArray = Arrays.copyOfRange(array, 1, array.length);
            result = 1 + calculateQuantityArrayElements(shortArray);
        }
        return result;
    }

}
