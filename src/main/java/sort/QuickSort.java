package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    //there is an implementation using Lists not arrays
    public List<Integer> quickSort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }
        int pivot = inputList.size() / 2;
        Integer pivotValue = inputList.get(pivot);
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if (i != pivot) {
                if (inputList.get(i) <= pivotValue) {
                    less.add(inputList.get(i));
                } else {
                    greater.add(inputList.get(i));
                }
            }
        }
        List<Integer> result = new ArrayList<>(quickSort(less));
        result.add(pivotValue);
        result.addAll(quickSort(greater));
        return result;
    }

    //there is an implementation using arrays
    public int[] quickArraySort(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray;
        }
        if (inputArray.length == 2) {
            int[] result = new int[2];
            if (inputArray[0] <= inputArray[1]) {
                result[0] = inputArray[0];
                result[1] = inputArray[1];
            } else {
                result[0] = inputArray[1];
                result[1] = inputArray[0];

            }
            return result;
        }
        int pivot = inputArray.length / 2;
        int pivotValue = inputArray[pivot];
        int[] less = new int[inputArray.length - 1];
        int[] greater = new int[inputArray.length - 1];
        int lessIndex = 0;
        int greaterIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != pivot) {
                if (inputArray[i] <= pivotValue) {
                    less[lessIndex] = inputArray[i];
                    lessIndex++;
                } else {
                    greater[greaterIndex] = inputArray[i];
                    greaterIndex++;
                }
            }
        }
        int[] sortedLess = quickArraySort(Arrays.copyOf(less,lessIndex));
        int[] sortedGreater = quickArraySort(Arrays.copyOf(greater,greaterIndex));
        int[] result = new int[sortedLess.length + 1 + sortedGreater.length];
        for (int i = 0; i < sortedLess.length; i++) {
                result[i] = sortedLess[i];
            }
        result[sortedLess.length] = pivotValue;
        for (int i = sortedLess.length + 1; i < inputArray.length; i++) {
                result[i] = sortedGreater[i - sortedLess.length - 1];
            }
        return result;
    }

}
