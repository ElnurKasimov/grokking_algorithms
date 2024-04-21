package sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {
    @ParameterizedTest(name = "{index} test that in array {0} has been sorted by selection correctly")
    @MethodSource("provideArrays")
    void testForSortingBySelectionForDifferentCases(int[] inputArray, int[] sortedArray) {
        assertArrayEquals(sortedArray, Sorting.sortBySelection(inputArray));
    }

    @ParameterizedTest(name = "{index} test that in array {0} has been sorted by bubble correctly")
    @MethodSource("provideArrays")
    void testForSortingByBubbleForDifferentCases(int[] inputArray, int[] sortedArray) {
        assertArrayEquals(sortedArray, Sorting.sortByBubble(inputArray));
    }

    private static Stream<Arguments> provideArrays() {
        return Stream.of(
                Arguments.of(new int[]{6,5,4,3,2,1}, new int[]{1,2,3,4,5,6}),
                Arguments.of(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}),
                Arguments.of(new int[]{-3,-68,23,0,56},new int[]{-68,-3,0,23,56}),
                Arguments.of(new int[]{-3,-68,23,-68,0,56, 23},new int[]{-68,-68,-3,0,23,23,56}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}