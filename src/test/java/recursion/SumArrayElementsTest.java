package recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import search.BinarySearch;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SumArrayElementsTest {

    SumArrayElements sumArrayElements = new SumArrayElements();

    @ParameterizedTest(name = "{index} test that in array {0} sum its elements {1}")
    @MethodSource
    void testForSumArrayElementsUsingRecursion(int[] inputArray, int sum) {

        assertEquals(sum, sumArrayElements.sumArrayElements(inputArray));
    }

    private static Stream<Arguments> testForSumArrayElementsUsingRecursion() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{1,2,3}, 6),
                Arguments.of(new int[]{-1,-2,0}, -3),
                Arguments.of(new int[]{1,2,3,4,-5}, 5)
        );
    }
}