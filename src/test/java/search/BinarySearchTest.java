package search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    @DisplayName("Test that if input array is non-sorted the method returns -1")
    void testForUnsortedInputArray() {
        int[] input = {3,6,23,8,56};
        assertEquals(-1, BinarySearch.findElementIndex(input, 8));
    }

    @Test
    @DisplayName("Test that if input array doesn't contain desired element the method returns -1")
    void testForSortedInputArrayAndNonexistingDesiredElement() {
        int[] input = {3,6,8,23,43,56};
        assertEquals(-1, BinarySearch.findElementIndex(input, 33));
    }

    @ParameterizedTest(name = "{index} test that in array {0} element {1} has index {2}")
    @MethodSource
    void testForSortedInputArrayAndExistingDesiredElement(int[] inputArray, int desiredElement, int expected) {
        int[] input = {3,6,8,23,43,56};
        assertEquals(-1, BinarySearch.findElementIndex(input, 33));
    }

    private static Stream<Arguments> testForSortedInputArrayAndExistingDesiredElement() {
        return Stream.of(
                Arguments.of(new int[]{3,6,8,23,43,56}, 3, 0),
                Arguments.of(new int[]{3,6,8,23,43,56}, 56, 5),
                Arguments.of(new int[]{3,6,8,23,43,56}, 23, 3)
        );
    }

}