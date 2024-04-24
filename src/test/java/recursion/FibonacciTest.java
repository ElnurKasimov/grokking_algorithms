package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();
    @ParameterizedTest(name = "{index}. test that factorial({0}) is equal {1}")
    @MethodSource("provideDataForFibonacciCalculation")
    void testThatFactorialCalculationIsCorrect (int number, long expected) {
        assertEquals(expected, fibonacci.calculateFibonacci(number));
    }

    private static Stream<Arguments> provideDataForFibonacciCalculation () {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(10, 55),
                Arguments.of(0,0),
                Arguments.of(-2, 0)
        );
    }
}