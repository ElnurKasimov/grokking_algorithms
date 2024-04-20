package sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    @Test
    void sortBySelection() {

    }

    @ParameterizedTest(name = "{index} test that in array {0} has been sorted correctly")
    @MethodSource
    void testForSortingDifferentCases(int[] inputArray, int[] sortedArray) {
        assertArrayEquals(sortedArray, SelectionSort.sortBySelection(inputArray));
    }

    private static Stream<Arguments> testForSortingDifferentCases() {
        return Stream.of(
                Arguments.of(new int[]{6,5,4,3,2,1}, new int[]{1,2,3,4,5,6}),
                Arguments.of(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}),
                Arguments.of(new int[]{-3,-68,23,0,56},new int[]{-68,-3,0,23,56}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}