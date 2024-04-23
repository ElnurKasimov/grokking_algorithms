package sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @ParameterizedTest(name = "{index} test that in array {0} max element {1}")
    @MethodSource
    void findMaxElement (int[] inputArray, int expected) {
        assertEquals(expected, CountingSort.findMaxElement(inputArray));
    }

    private static Stream<Arguments> findMaxElement() {
        return Stream.of(
                Arguments.of(new int[]{6,5,4,3,2,1}, 6),
                Arguments.of(new int[]{0,0,0,0,0}, 0),
                Arguments.of(new int[]{-3,-68,-23,0,6},6),
                Arguments.of(new int[]{-3,-68,-23,-68,-23}, -3)
        );
    }

    @ParameterizedTest(name = "{index} test that in array {0} max element {1}")
    @MethodSource
    void findMinElement (int[] inputArray, int expected) {
        assertEquals(expected, CountingSort.findMinElement(inputArray));
    }

    private static Stream<Arguments> findMinElement() {
        return Stream.of(
                Arguments.of(new int[]{6,5,4,3,2,1}, 1),
                Arguments.of(new int[]{0,0,0,0,0}, 0),
                Arguments.of(new int[]{-3,-68,-23,0,6}, -68),
                Arguments.of(new int[]{-3,68,-23,68,-23}, -23)
        );
    }


    @ParameterizedTest(name = "{index} test that for array {0} max countArray is {1}")
    @MethodSource
    void createCountArray (int[] inputArray, int[] expected) {
        assertArrayEquals(expected, CountingSort.createCountArray(inputArray));
    }

    private static Stream<Arguments> createCountArray () {
        return Stream.of(
                Arguments.of(new int[]{0,0,0,0,0}, new int[]{5}),
                Arguments.of(new int[]{1,1,1}, new int[]{3}),
                Arguments.of(new int[]{6,5,4,3,2,1}, new int[]{1,1,1,1,1,1}),
                Arguments.of(new int[]{1,2,3,3,2,1}, new int[]{2,2,2})
//                Arguments.of(new int[]{-23,-68,-23,0,-68}, new int[]{2,2,1}),
//                Arguments.of(new int[]{-3,-68,-23,-68,-23}, new int[]{2,2,1,0})
        );
    }

    @ParameterizedTest(name = "{index} test that array {0} has been sorted correctly")
    @MethodSource
    void sortByCounting (int[] inputArray, int[] expected) {
        assertArrayEquals(expected, CountingSort.sortByCounting(inputArray));
    }

    private static Stream<Arguments> sortByCounting () {
        return Stream.of(
                Arguments.of(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}),
                Arguments.of(new int[]{1,1,1}, new int[]{1,1,1}),
                Arguments.of(new int[]{6,5,4,3,2,1}, new int[]{1,2,3,4,5,6}),
                Arguments.of(new int[]{1,2,3,3,2,1}, new int[]{1,1,2,2,3,3})
//                Arguments.of(new int[]{-23,-68,-23,0,-68}, new int[]{2,2,1}),
//                Arguments.of(new int[]{-3,-68,-23,-68,-23}, new int[]{2,2,1,0})
        );
    }

}