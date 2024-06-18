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

//    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = Arrays.asList(1);
//        List<Integer> list3 = Arrays.asList(2,1);
//        List<Integer> list4 = Arrays.asList(4,2,1);
//        List<Integer> list5 = Arrays.asList(3,4,2,1);
//        List<Integer> list6= Arrays.asList(-3, -5, -4);
//        System.out.println("list1 = " + quickSort(list1));
//        System.out.println("list2 = " + quickSort(list2));
//        System.out.println("list3 = " + quickSort(list3));
//        System.out.println("list4 = " + quickSort(list4));
//        System.out.println("list5 = " + quickSort(list5));
//        System.out.println("list6 = " + quickSort(list6));
//    }


}
