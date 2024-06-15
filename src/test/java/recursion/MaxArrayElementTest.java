package recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxArrayElementTest {

    MaxArrayElement maxArrayElement = new MaxArrayElement();

    @ParameterizedTest(name = "{index} test that in array {0} max element {1}")
    @MethodSource
    void testForFindMaxArrayElementUsingRecursion(int[] inputArray, long max) {

        assertEquals(max, maxArrayElement.findMaxArrayElement(inputArray));
    }

    private static Stream<Arguments> testForFindMaxArrayElementUsingRecursion() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{-1,-2,0}, 0),
                Arguments.of(new int[]{1,2,3,4,-5}, 4)
        );
    }
}