package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private static QuickSort quickSort;

    @BeforeAll
    public static void init() {
        quickSort = new QuickSort();
    }

    @ParameterizedTest(name = "{index} test that List {0} has been sorted correctly")
    @MethodSource
    void testThatQuickSortWorkCorrectlyWithList (List<Integer> inputList, List<Integer> expected) {

        assertEquals(expected, quickSort.quickSort(inputList));
    }

    private static Stream<Arguments> testThatQuickSortWorkCorrectlyWithList () {
        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(Arrays.asList(1), Arrays.asList(1)),
                Arguments.of(Arrays.asList(2,1), Arrays.asList(1,2)),
                Arguments.of(Arrays.asList(4,2,1), Arrays.asList(1,2,4)),
                Arguments.of(Arrays.asList(3,4,1,2), Arrays.asList(1,2,3,4)),
                Arguments.of(Arrays.asList(1,1,1), Arrays.asList(1,1,1)),
                Arguments.of(Arrays.asList(3,4,1,4), Arrays.asList(1,3,4,4)),
                Arguments.of(Arrays.asList(3,-4,1,-8), Arrays.asList(-8,-4,1,3)),
                Arguments.of(Arrays.asList(-3, -5, -4), Arrays.asList(-5, -4, -3))
        );
    }

    @ParameterizedTest(name = "{index} test that array {0} has been sorted correctly")
    @MethodSource
    void testThatQuickSortWorkCorrectlyWithArray(int[] inputArray, int[] expected) {
        assertArrayEquals(expected, quickSort.quickArraySort(inputArray));
    }

    private static Stream<Arguments> testThatQuickSortWorkCorrectlyWithArray () {
        return Stream.of(
                Arguments.of(new int[1], new int[1]),
                Arguments.of(new int[]{2}, new int[]{2}),
                Arguments.of(new int[]{2,1}, new int[]{1,2}),
                Arguments.of(new int[]{1,1,1}, new int[]{1,1,1}),
                Arguments.of(new int[]{2,1,5}, new int[]{1,2,5}),
                Arguments.of(new int[]{1,2,3,3,2,1}, new int[]{1,1,2,2,3,3}),
                Arguments.of(new int[]{6, 0, -23}, new int[]{-23,0,6}),
                Arguments.of(new int[]{-3,-68,-23,-68,-23}, new int[]{-68,-68,-23,-23,-3},
                Arguments.of(new int[]{-15, 0, 6, 0, -23, 19, 0}, new int[]{-23,-15,0,0,0,6,19}))
        );
    }
}