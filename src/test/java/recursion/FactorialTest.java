package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private final Factorial factorial = new Factorial();
    @ParameterizedTest(name = "{index}. test that factorial({0}) is equal {1}")
    @MethodSource("provideDataForFactorialCalculation")
    void testThatFactorialCalculationIsCorrectly (int number, long expected) {
        assertEquals(expected, factorial.calculateFactorial(number));
    }

    private static Stream<Arguments> provideDataForFactorialCalculation () {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(5, 120),
                Arguments.of(0,0),
                Arguments.of(-2, 0)
        );
    }
}