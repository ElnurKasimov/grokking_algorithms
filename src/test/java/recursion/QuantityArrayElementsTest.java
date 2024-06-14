package recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuantityArrayElementsTest {

    QuantityArrayElements quantityArrayElements = new QuantityArrayElements();

    @ParameterizedTest(name = "{index} test that in array {0} quantity its elements {1}")
    @MethodSource
    void testForQuantityArrayElementsUsingRecursion(int[] inputArray, int quantity) {

        assertEquals(quantity, quantityArrayElements.calculateQuantityArrayElements(inputArray));
    }

    private static Stream<Arguments> testForQuantityArrayElementsUsingRecursion() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{7}, 1),
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{-1,-2,0}, 3),
                Arguments.of(new int[]{1,2,3,4,-5}, 5)
        );
    }
}