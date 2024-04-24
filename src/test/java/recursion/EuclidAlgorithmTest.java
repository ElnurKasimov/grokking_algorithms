package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class EuclidAlgorithmTest {
    private final EuclidAlgorithm euclidAlgorithm = new EuclidAlgorithm();

    @ParameterizedTest(name = "{index}. test that for {0} and {1} GCD is {2}")
    @MethodSource("provideDataForFindGreatestCommonDivisor")
    void testThatFindGreatestCommonDivisorWorksCorrectly(int a, int b, int expected) {
        assertEquals(expected, euclidAlgorithm.findGreatestCommonDivisor(a, b));
    }

    private static Stream<Arguments> provideDataForFindGreatestCommonDivisor() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(1, 0, 0),
                Arguments.of(-3, 1, 0),
                Arguments.of(2, -4, 0),
                Arguments.of(-5,-2, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 2, 2),
                Arguments.of(6, 4, 2),
                Arguments.of(6, 9, 3),
                Arguments.of(7, 8, 1),
                Arguments.of(8, 7, 1),
                Arguments.of(1071, 462, 21)
        );
    }
}